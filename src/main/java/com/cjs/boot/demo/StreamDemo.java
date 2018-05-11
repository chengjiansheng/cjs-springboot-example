package com.cjs.boot.demo;

import com.cjs.boot.constants.CouponTypeEnum;
import com.cjs.boot.domain.entity.CouponInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        List<CouponInfo> couponInfoList = getCouponList();

        List<String> list = Arrays.asList(new String[]{"A", "S", "D", "F", "X", "C", "Y", "H", "", null});

        System.out.println("========= filter =========");

        List<String> list1 = list.stream().filter(e-> StringUtils.isNotBlank(e)).collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("========= forEach =========");

        list.stream().forEach(System.out::println);

        System.out.println("========= limit =========");

        list.stream().limit(3).forEach(System.out::println);

        System.out.println("========= sorted =========");

        List<String> list2 = list1.stream().sorted().collect(Collectors.toList());
        List<String> list3 = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> list4 = list1.stream().sorted(Comparator.nullsLast(Comparator.naturalOrder())).collect(Collectors.toList());
        list1.stream().sorted(Comparator.comparing(e->e));
        List<String> list5 = list1.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).collect(Collectors.toList());
        List<CouponInfo> list6 = couponInfoList.stream().sorted(Comparator.comparing(CouponInfo::getId)).collect(Collectors.toList());
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(list5);
        list6.stream().forEach(System.out::println);

        System.out.println("========= map =========");

        List<String> list7 = list1.stream().map(e->e+e).collect(Collectors.toList());
        Map<Long, CouponInfo> couponInfoMap = couponInfoList.stream().collect(Collectors.toMap(CouponInfo::getId, e->e));
        System.out.println(list7);
        couponInfoMap.entrySet().stream().forEach(System.out::println);
        System.out.println(list1.stream().collect(Collectors.joining(":")));

        System.out.println(couponInfoList.stream().collect(Collectors.toMap(CouponInfo::getId, Function.identity())));

        //  Key重复的时候覆盖处理
        Map<Integer, CouponInfo> couponInfoMap2 = couponInfoList.stream().collect(Collectors.toMap(CouponInfo::getMerchantId, Function.identity(), (v1, v2)->v2));
        couponInfoMap2.entrySet().forEach(System.out::println);

        System.out.println("========= group by =========");

        Map<Integer, List<CouponInfo>> map3 = couponInfoList.stream().collect(Collectors.groupingBy(CouponInfo::getMerchantId));
        map3.entrySet().forEach(System.out::println);

        Map<Integer, Long> map4 = couponInfoList.stream().collect(Collectors.groupingBy(CouponInfo::getMerchantId, Collectors.counting()));
        map4.entrySet().forEach(System.out::println);

        List<Integer> list8 = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 6, 2, 3});

        IntSummaryStatistics summaryStatistics = list8.stream().mapToInt(x->x).summaryStatistics();
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getSum());

    }

    private static List<CouponInfo> getCouponList() {
        CouponInfo couponInfo1 = new CouponInfo(123L, 10001, "5元现金券");
        CouponInfo couponInfo2 = new CouponInfo(124L, 10001, "10元现金券");
        CouponInfo couponInfo3 = new CouponInfo(125L, 10002, "全场9折");
        CouponInfo couponInfo4 = new CouponInfo(126L, 10002, "全场8折");
        CouponInfo couponInfo5 = new CouponInfo(127L, 10003, "全场7折");

        List<CouponInfo> couponInfoList = new ArrayList<>();
        couponInfoList.add(couponInfo1);
        couponInfoList.add(couponInfo2);
        couponInfoList.add(couponInfo3);
        couponInfoList.add(couponInfo4);
        couponInfoList.add(couponInfo5);

        return couponInfoList;
    }

}
