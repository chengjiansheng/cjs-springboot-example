package com.cjs.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.cjs.boot.mapper.CouponInfoMapper;
import com.cjs.boot.domain.entity.CouponInfo;
import com.cjs.boot.service.CouponInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class CouponInfoServiceImpl implements CouponInfoService {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Autowired
    private CouponInfoMapper couponInfoMapper;

    @Cacheable(cacheNames = "coupon", key = "'merchantId:' + #merchantId", unless = "#result == null or #result.size() <= 0")
    @Override
    public List<CouponInfo> getByMerchantId(Integer merchantId) {
        List<CouponInfo> list = couponInfoMapper.selectByMerchantId(merchantId);
        return list ;
    }

    @CacheEvict(cacheNames = "coupon", key = "'merchantId:' + #merchantId")
    @Override
    public void deleteByMerchantId(Integer merchantId) {
        //  TODO 数据库中删除
    }

    @Override
    public CouponInfo getById(Long id) {
        CouponInfo couponInfo = null;
        String key = "coupon:" + id;
        if (redisTemplate.hasKey(key)) {
            String value = redisTemplate.opsForValue().get(key);
            log.info("从缓存中获取");
            if (StringUtils.isNotBlank(value)) {
                couponInfo = JSON.parseObject(value, CouponInfo.class);
            }
        }else {
            log.info("从数据库中获取");
            couponInfo = couponInfoMapper.selectByPrimaryKey(id);
            if (null != couponInfo) {
                String value = JSON.toJSONString(couponInfo);
                redisTemplate.opsForValue().set(key, value, 1, TimeUnit.HOURS);
            }
        }
        return couponInfo;
    }

    @Override
    public void deleteById(Long id) {
        String key = "coupon:" + id;
        if (redisTemplate.delete(key)) {
            log.info("缓存中删除");
//            couponInfoMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int save(CouponInfo couponInfo) {
        couponInfo.setCreateTime(new Date());
        couponInfo.setUpdateTime(new Date());
        return couponInfoMapper.insertSelective(couponInfo);
    }
}
