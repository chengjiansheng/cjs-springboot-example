package com.cjs.boot.service;

import com.cjs.boot.domain.entity.CouponInfo;

import java.util.List;

public interface CouponInfoService {

    List<CouponInfo> getAll();

    List<CouponInfo> getByMerchantId(Integer merchantId);

    void deleteByMerchantId(Integer merchantId);

    CouponInfo getById(Long id);

    void deleteById(Long id);

    int save(CouponInfo couponInfo);

    int update(CouponInfo couponInfo);

}
