package com.cjs.boot.controller;

import com.cjs.boot.domain.entity.CouponInfo;
import com.cjs.boot.response.RespResult;
import com.cjs.boot.service.CouponInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.List;


@Controller
@RequestMapping("/coupon")
@Validated
public class CouponController extends BaseController {

    @Autowired
    private CouponInfoService couponInfoService;

    @GetMapping("/detail.html")
    public ModelAndView detail(@NotNull(message = "ID不能为空") Long id) {
        ModelAndView modelAndView = new ModelAndView("coupon/detail");
        //  TODO 查询
        return modelAndView;
    }

    @GetMapping("/getByMechantId.json")
    @ResponseBody
    public RespResult<List<CouponInfo>> getByMechantId(Integer merchantId) {
        List<CouponInfo> list = couponInfoService.getByMerchantId(merchantId);
        return new RespResult<List<CouponInfo>>(list);
    }

    @GetMapping("/deleteByMechantId.json")
    @ResponseBody
    public RespResult<List<CouponInfo>> deleteByMerchantId(Integer merchantId) {
        couponInfoService.deleteByMerchantId(merchantId);
        return RespResult.success();
    }

    @GetMapping("/getById.json")
    @ResponseBody
    public RespResult<CouponInfo> getById(Long id) {
        CouponInfo couponInfo = couponInfoService.getById(id);
        return new RespResult<CouponInfo>(couponInfo);
    }

    @GetMapping("/deleteById.json")
    @ResponseBody
    public RespResult deleteById(Long id) {
        couponInfoService.deleteById(id);
        return RespResult.success();
    }

    @GetMapping("/add.html")
    public ModelAndView add() {
        return new ModelAndView("coupon/add");
    }

    @PostMapping("/save.json")
    @ResponseBody
    public RespResult save(@RequestBody CouponInfo couponInfo, @CookieValue String token) {
        couponInfoService.save(couponInfo);
        return RespResult.success();
    }
}
