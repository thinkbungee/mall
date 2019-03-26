package com.supermarket;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0 created by chenyichang_fh on 2019/3/22 13:06
 */
public class TestStream {

    @Test
    public void testMap() throws NoSuchFieldException, IllegalAccessException {
        List<String> str = Arrays.asList("a", "b", "c", "d");
        List<String> collect = str.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);


        Integer a = 10;
        test(a);
        System.out.println(a);//让a不等于10  编写test方法
    }

    private void test(Integer a) throws NoSuchFieldException, IllegalAccessException {
        //编写方法  改变a的值
        Field f = a.getClass().getDeclaredField("value");
        f.setAccessible(true);
        f.set(a, 20);
    }

}
