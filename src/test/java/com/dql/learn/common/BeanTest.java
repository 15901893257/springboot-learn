package com.dql.learn.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.dql.learn.entity.BeanModel;
import com.dql.learn.entity.Cat;
import com.dql.learn.entity.Dog;
import com.dql.learn.entity.FieldView;
import com.dql.learn.enums.TypeEnum;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/4/22
 */
public class BeanTest {
    private static final long ONE_DAY = 24 * 60 * 60 * 1000L;

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

    @Test
    public void test05() {
        List<String> list = new ArrayList<>();
        for (Field field : FieldView.class.getDeclaredFields()) {
            field.setAccessible(true);
            list.add(field.getName());
        }
        System.out.println(list);
    }

    @Test
    public void test06() {
        List<String> list = Lists.newArrayList("1", "2");
        int a = 1;
        System.out.println(list.contains(String.valueOf(a)));
    }

    @Test
    public void test07() {
        Double a = new Double(0.8181175260602846D);
        double b = a * 100.00D;
        System.out.println(String.format("%.2f", b));
    }

    @Test
    public void test08() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTime());
    }

    @Test
    public void test09() {
        long time = 1624896000000L;
        System.out.println(new Date(time + ONE_DAY - 1));
    }
}
