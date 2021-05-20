package com.dql.learn.common;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.dql.learn.entity.BeanModel;
import com.dql.learn.entity.Cat;
import com.dql.learn.entity.Dog;
import com.dql.learn.enums.TypeEnum;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/4/22
 */
public class BeanTest {

    @Test
    public void test01() {
        Cat cat = new Cat(23, "cat");
        Dog dog = new Dog();
        BeanUtils.copyProperties(cat, dog);
        System.out.println(dog);
    }

    @Test
    public void test02() {
        System.out.println(TypeEnum.MAN.getName());
        System.out.println(TypeEnum.MAN.name());
        System.out.println(TypeEnum.MAN.getCode());
        System.out.println(TypeEnum.getName(1));
    }

    @Test
    public void test03() {
        Integer a1 = new Integer(3);
        Integer a2 = new Integer(3);

        Integer b1 = new Integer(128);
        Integer b2 = new Integer(128);

        System.out.println(a1 == a2);
        System.out.println(b1 == b2);

        System.out.println(a1.equals(a2));
        System.out.println(b1.equals(b2));
    }

    @Test
    public void test04() {
        BeanModel model = new BeanModel();
        model.setAge(188);

        BeanModel model1 = new BeanModel();
        model1.setAge(188);

        System.out.println(model.getAge() == model1.getAge());
        System.out.println(model.getAge().equals(model1.getAge()));
    }
}
