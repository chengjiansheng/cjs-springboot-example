package com.cjs.boot.constants;

public enum CouponTypeEnum {
    CASH_COUPON((byte)1, "代金券"),
    DISCOUNT_COUPONT((byte) 2, "折扣券");

    private Byte type;

    private String name;

    CouponTypeEnum(Byte type, String name) {
        this.type = type;
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
