package com.dql.learn.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2021/3/18
 */
public class ListTest {
    @Test
    public void testRetain() {
        List<Long> list1 = Lists.newArrayList(1L, 2L, 3L, 4L);
        List<Long> list2 = Lists.newArrayList(1L, 4L, 5L);
        List<Long> list3 = (List<Long>) CollectionUtils.intersection(list1, list2);
        list1.retainAll(list2);
        System.out.println(list1);
        System.out.println(list3);
    }

    @Test
    public void test01() {
        Man man = new Man();
//        man.setList(Collections.emptyList());
        man.setList(Collections.EMPTY_LIST);
    }

    @Test
    public void test02() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        list = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list1);
    }

}

@Data
class Man {
    private List<Man> list;
}

