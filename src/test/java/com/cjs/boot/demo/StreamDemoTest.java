package com.cjs.boot.demo;

import com.cjs.boot.domain.entity.CouponInfo;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemoTest {

    private List<CouponInfo> couponInfoList;

    private List<String> strList;

    private List<Integer> intList;

    @Before
    public void init() {
        CouponInfo couponInfo1 = new CouponInfo(123L, 10001, "5元现金券");
        CouponInfo couponInfo2 = new CouponInfo(124L, 10001, "10元现金券");
        CouponInfo couponInfo3 = new CouponInfo(125L, 10002, "全场9折");
        CouponInfo couponInfo4 = new CouponInfo(126L, 10002, "全场8折");
        CouponInfo couponInfo5 = new CouponInfo(127L, 10003, "全场7折");

        couponInfoList = new ArrayList<>();
        couponInfoList.add(couponInfo1);
        couponInfoList.add(couponInfo2);
        couponInfoList.add(couponInfo3);
        couponInfoList.add(couponInfo4);
        couponInfoList.add(couponInfo5);

        couponInfoList = new ArrayList<>();
        couponInfoList.add(couponInfo1);
        couponInfoList.add(couponInfo2);
        couponInfoList.add(couponInfo3);
        couponInfoList.add(couponInfo4);
        couponInfoList.add(couponInfo5);

        strList = Arrays.asList(new String[]{"A", "S", "D", "F", "X", "C", "Y", "H", "", null});

        intList = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 6, 2, 3});
    }

    /**
     * 迭代  forEach
     */
    @Test
    public void testForEach() {
        strList.stream().forEach(System.out::println);
        strList.stream().forEach(e->System.out.print(e));
        System.out.println();
        strList.forEach(System.out::print);
    }

    /**
     * 过滤  filter
     */
    @Test
    public void testFilter() {
        List<String> list = strList.stream().filter(x-> StringUtils.isNotBlank(x)).collect(Collectors.toList());
        System.out.println(list);
        List<Integer> list2 = intList.stream().distinct().collect(Collectors.toList());
        System.out.println(list2);
        List<CouponInfo> list3 = couponInfoList.stream().filter(x->x.getMerchantId() != 10001).collect(Collectors.toList());
        System.out.println(list3);
    }

    /**
     * limit
     */
    @Test
    public void testLimit() {
        List<String> list = strList.stream().limit(3).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 排序  sorted
     */
    @Test
    public void testSorted() {
        List<Integer> list = intList.stream().sorted().collect(Collectors.toList());
        System.out.println(list);
        //  倒序
        List<Integer> list2 = intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list2);

        List<String> list3 = strList.stream().sorted(Comparator.nullsLast(Comparator.naturalOrder())).collect(Collectors.toList());
        List<String> list4 = strList.stream().sorted(Comparator.nullsLast(Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(list3);
        System.out.println(list4);

        List<CouponInfo> list5 = couponInfoList.stream().sorted(Comparator.comparing(CouponInfo::getId)).collect(Collectors.toList());
        List<CouponInfo> list6 = couponInfoList.stream().sorted(Comparator.comparing(CouponInfo::getId).reversed()).collect(Collectors.toList());
        List<Long> list51 = list5.stream().map(e->e.getId()).collect(Collectors.toList());
        List<Long> list61 = list6.stream().map(e->e.getId()).collect(Collectors.toList());
        System.out.println(list51);
        System.out.println(list61);
    }

    /**
     * map
     * 对每个元素进行处理，相当于MapReduce中的map阶段
     * Collectors.mapping()类似
     */
    @Test
    public void testMap() {
        List<Integer> list = intList.stream().map(e->2*e).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 转成Map<K,V>
     *
     * 特别注意，key不能重复，如果重复的话默认会报错，可以指定key重复的时候怎么处理
     *
     * 例如：Map<String, Student> studentIdToStudent = students.stream().collect(toMap(Student::getId, Functions.identity());
     */
    @Test
    public void testToMap() {
        //  因为ID不重复，所以这里这么写没问题；但如果key换成CouponInfo::getMerchantId就有问题了
        Map<Long, CouponInfo> map = couponInfoList.stream().collect(Collectors.toMap(CouponInfo::getId, Function.identity()));
        //  这里重复的处理方式就是用后者覆盖前者
        Map<Integer, CouponInfo> map2 = couponInfoList.stream().collect(Collectors.toMap(CouponInfo::getMerchantId, Function.identity(), (c1, c2)->c2));
        Map<Integer, CouponInfo> map3 = couponInfoList.stream().collect(Collectors.toMap(CouponInfo::getMerchantId, Function.identity(),
                (c1, c2)->{if (c1.getId() > c2.getId()) {
                    return c2;
                }else {
                    return c1;
                }
        }));
        System.out.println(map);
        System.out.println(map2);
        System.out.println(map3);
    }

    /**
     * 分组  groupingBy
     */
    @Test
    public void testGroupBy() {
        Map<Integer, List<CouponInfo>> map = couponInfoList.stream().collect(Collectors.groupingBy(CouponInfo::getMerchantId));
        Map<Integer, Long> map2 = couponInfoList.stream().collect(Collectors.groupingBy(CouponInfo::getMerchantId, Collectors.counting()));
        Map<Integer, Set<String>> map3 = couponInfoList.stream().collect(Collectors.groupingBy(CouponInfo::getMerchantId, Collectors.mapping(CouponInfo::getCouponName, Collectors.toSet())));
        System.out.println(map);
        System.out.println(map2);
        System.out.println(map3);
    }

    /**
     * 数值统计
     */
    @Test
    public void testSum() {
        IntSummaryStatistics summaryStatistics = intList.stream().mapToInt(x->x).summaryStatistics();
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getSum());
    }

}