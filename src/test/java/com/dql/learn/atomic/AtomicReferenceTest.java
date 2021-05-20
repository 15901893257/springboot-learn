package com.dql.learn.atomic;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/4/25
 */
public class AtomicReferenceTest {

    @Test
    public void test01() {
        AtomicReference<String> name = new AtomicReference<>();
        System.out.println(name.get());
        String name1 = name.get();
        System.out.println(StringUtils.isEmpty(name1));
    }

    @Test
    public void test02() {
        AtomicReference<Pair<String, Long>> pairAtomicReference = new AtomicReference<>();
        Pair<String, Long> pair = pairAtomicReference.get();
        System.out.println(pair);
        System.out.println(Objects.nonNull(pair));
    }
}
