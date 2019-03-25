package com.supermarket;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0 created by chenyichang_fh on 2019/3/22 13:06
 */
public class TestStream {

    @Test
    public void testMap() {
        List<String> str = Arrays.asList("a", "b", "c", "d");
        List<String> collect = str.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
    }
}
