package com.cjs.boot.mapper;

import com.cjs.boot.domain.entity.CouponInfo;
import com.cjs.boot.domain.entity.CouponInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 如果不想每个Mapper都加@Mapper注解，可以在启动类上加@MapperScan注解
 */

@Repository
@Mapper
public interface CouponInfoMapper {

    long countByExample(CouponInfoExample example);

    int deleteByExample(CouponInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponInfo record);

    int insertSelective(CouponInfo record);

    List<CouponInfo> selectByExample(CouponInfoExample example);

    CouponInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponInfo record, @Param("example") CouponInfoExample example);

    int updateByExample(@Param("record") CouponInfo record, @Param("example") CouponInfoExample example);

    int updateByPrimaryKeySelective(CouponInfo record);

    int updateByPrimaryKey(CouponInfo record);

    List<CouponInfo> selectByMerchantId(Integer merchantId);
}