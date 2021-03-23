package com.dql.learn.function;

import java.util.function.Supplier;

import org.junit.Test;
import org.springframework.util.function.SingletonSupplier;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dengquanliang
 * Created on 2020/12/8
 */
@Slf4j
public class SupplierTest{

    @Test
    public void test01() {
        Supplier<String> supplier = String :: new;
        log.info("supplier: {}", supplier.get());
        Supplier<Emp> empSupplier = Emp::new;
        Supplier<Emp> empSupplier1 = Emp::new;
        empSupplier1.get();
        Emp emp = empSupplier.get();
        System.out.println(emp);
        emp.setName("deng");
        System.out.println(emp);
    }

    @Test
    public void test02() {
        Supplier<User> supplier = () -> new User();
        Supplier<User> supplier1 = () -> new User("deng", 12);
        System.out.println(supplier.get());
        System.out.println(supplier1.get());
    }

    @Data
    public static class Emp {
        private String name;
        public static int i = 0;
        public Emp() {
            System.out.println("hello: " + i++);
        }
    }
}
