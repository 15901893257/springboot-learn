package com.dql.learn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author dengquanliang
 * Created on 2020/12/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestBase {
    protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    @Test
    public void test() {
        System.out.println("hello world");
    }
}
