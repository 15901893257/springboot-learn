package com.dql.learn;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author dengquanliang
 * Created on 2020/12/8
 */
@SpringBootTest
public class TestBase {
    protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    @Test
    public void test() {
        System.out.println("hello world");
    }
}
