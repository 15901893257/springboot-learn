package com.dql.learn.collection;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.naming.factory.BeanFactory;
import org.assertj.core.util.Lists;
import org.junit.Test;

import com.dql.learn.service.MyTestService;
import com.google.common.base.CaseFormat;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/6/9
 */
public class ListTest1 {

    @Test
    public void test01() {
        List<String> list = Lists.newArrayList("AcFun", "(公司）", "（hello）");
        String[] strings = list.toArray(new String[0]);
        testString(strings);
        for (String s : strings) {
            System.out.println(s);
        }
        List<String> list1 = list.stream().map(this::transform).collect(Collectors.toList());
//        System.out.println(list);
//        System.out.println(list1);
    }

    @Test
    public void test02() {
        String className = "com.kuaishou.ad.crm.report.service.MyTestService";
        String simpleClassName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, className
                .split("\\.")[className.split("\\.").length - 1]);
        System.out.println(simpleClassName);
    }

    @Test
    public void test03() {
        List<Long> l1 = Lists.newArrayList(1L, 2L, 3L);
        List<Long> l2 = Lists.newArrayList();
        l1.retainAll(Collections.singletonList(1L));
        l2.retainAll(Collections.singletonList(1L));
        System.out.println(l1);
        System.out.println(l2);
    }

    private String transform(String s) {
        String s1 = s.toLowerCase().replaceAll("（", "(").replaceAll("）", ")");
        return s1;
    }

    private void testString(String... strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }



}
