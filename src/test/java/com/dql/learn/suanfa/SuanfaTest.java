package com.dql.learn.suanfa;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/6/7
 */
public class SuanfaTest {

    @Test
    public void test() {
        List<Map<String, String>> ans = buildCombinations1(
                Arrays.asList(
                        new AbstractMap.SimpleEntry<String, List<String>>("A", Arrays.asList("1", "2", "3")),
                        new AbstractMap.SimpleEntry<String, List<String>>("B", Arrays.asList("13", "22", "33"))
//                        new AbstractMap.SimpleEntry<String, List<String>>("C", Arrays.asList("123", "223", "323"))
//                        new AbstractMap.SimpleEntry<String, List<String>>("D", Arrays.asList("1353", "2453", "3353"))
                ),
                0,
                new ArrayList<>()

        );
        ans.forEach(e -> {
            System.out.println();
            e.forEach((k, v) -> {
                System.out.print("k: " + k + " v: " + v);
            });
        });
    }

    public List<Map<String, String>> buildCombinations1(List<Map.Entry<String, List<String>>> tagKvList, int index,
                                                        List<Map<String, String>> combinations) {
        if (index >= tagKvList.size()) {
//            System.out.println(combinations);
            return combinations;
        }
        List<Map<String, String>> copyList = new ArrayList<>();
        Map.Entry<String, List<String>> entry = tagKvList.get(index);
        if (index == 0) {
            for (int j = 0; j < entry.getValue().size(); j++) {
                Map<String, String> copyMap = new HashMap<>();
                copyMap.put(entry.getKey(), entry.getValue().get(j));
                copyList.add(copyMap);
            }
        } else {
            for (int i = 0; i < combinations.size(); i++) {
                Map<String, String> indexMap = combinations.get(i);
                for (int j = 0; j < entry.getValue().size(); j++) {
                    Map<String, String> copyMap = new HashMap<>();
                    indexMap.forEach((k, v) -> copyMap.put(k, v));
                    copyMap.put(entry.getKey(), entry.getValue().get(j));
                    copyList.add(copyMap);
                }
            }
        }
//        System.out.println(copyList);

        return buildCombinations1(tagKvList, index + 1, copyList);
    }
}
