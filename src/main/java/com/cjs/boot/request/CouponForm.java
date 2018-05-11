package com.cjs.boot.request;

import com.cjs.boot.request.custom.CheckTimeInterval;
import com.cjs.boot.request.custom.CheckValidityMode;
import com.cjs.boot.request.group.GroupCouponAdd;
import com.cjs.boot.request.group.GroupCouponEdit;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@CheckTimeInterval(startTime = "releaseStartTime", endTime = "releaseEndTime", message = "发放开始时间不能大于发放结束时间")
@CheckValidityMode(message = "领取后有效天数不能为空")
public class CouponForm {

    @NotNull(groups = {GroupCouponEdit.class}, message = "优惠券ID不能为空")
    private Long couponId;      //  优惠券ID

    @NotNull(groups = {GroupCouponAdd.class, GroupCouponEdit.class}, message = "商家ID不能为空")
    private Integer merchantId;        //  商家ID

    @NotBlank(groups = {GroupCouponAdd.class, GroupCouponEdit.class}, message = "优惠券名称不能为空")
    @Length(groups = {GroupCouponAdd.class, GroupCouponEdit.class}, max = 16, message = "优惠券名称最大长度为16")
    private String couponName;      //  优惠券名称

    @NotNull(groups = {GroupCouponAdd.class, GroupCouponEdit.class}, message = "优惠券类型不能为空")
    private Integer couponType;     //  优惠券类型

    @NotNull
    private Integer parValue;   //  面值

    @NotNull
    private Integer quantity;   //  发放数量

    private Date releaseStartTime;  //  发放开始时间

    private Date releaseEndTime;    //  发放结束时间

    @NotNull
    private Integer validityMode;   //  有效期模式

    private Integer days;       //  领取后多少天内有效

    private Integer limitType;  //  限制领取类型

    private Integer limitNum;   //  限制领取数量

    private Date validityStartTime;     //  有效期开始时间

    private Date validityEndTime;       //  有效期结束时间

    @Size(max = 200)
    private String remark;  //  备注
}
