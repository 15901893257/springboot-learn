package com.dql.learn;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;

import com.dql.learn.service.MyTestService;
import com.google.common.base.CaseFormat;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/6/10
 */
public class ServiceTest extends TestBase {

    @Autowired
    private MyTestService myTestService;

    @Test
    public void test01() {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        String className = "com.kuaishou.ad.crm.report.service.MyTestService";
        String simpleClassName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, className
                .split("\\.")[className.split("\\.").length - 1]);
        MyTestService myTestService = applicationContext.getBean(simpleClassName, MyTestService.class);

        System.out.println(myTestService);
    }

    @Test
    public void test02() {
        myTestService.f();
    }
}
