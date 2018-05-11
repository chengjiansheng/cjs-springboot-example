package com.cjs.boot.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CouponInfo implements Serializable {

    private Long id;

    private Integer merchantId;

    private String couponName;

    private Byte couponType;

    private Integer parValue;

    private Integer quantity;

    private Date releaseStartTime;

    private Date releaseEndTime;

    private Byte limitType;

    private Integer limitNum;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private Byte yn;

    public CouponInfo() {
    }

    public CouponInfo(Long id, Integer merchantId, String couponName) {
        this.id = id;
        this.merchantId = merchantId;
        this.couponName = couponName;
    }

    @Override
    public String toString() {
        return "CouponInfo{" +
                "id=" + id +
                ", merchantId=" + merchantId +
                ", couponName='" + couponName + '\'' +
                '}';
    }
}