package com.dql.learn.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/7/5
 */
public class ListTest2 implements Comparator<ListTest2> {
    @Test
    public void test01() {
        List<Long> list = Lists.newArrayList(2L, 5L, 3L, 10L, 3L, 2L, 29L, 18L);
        Collections.sort(list, (o1, o2) -> o2 - o1 > 0L ? -1 : 1);
//        Collections.sort(list, (o1, o2) -> 1);
        System.out.println(list);
    }

    @Test
    public void test02() {
        List<Integer> list = Lists.newArrayList(2, 6, 5, 29, 18);
        Collections.sort(list, (o1, o2) -> o2 - o1);
        System.out.println(list);
    }


    @Override
    public int compare(ListTest2 o1, ListTest2 o2) {
        return 0;
    }
}
