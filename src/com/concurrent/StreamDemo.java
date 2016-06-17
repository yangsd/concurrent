package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 流编程
 * 表示数据移动，移动过程中可能会对数据进行处理
 * 不同于IO流，表示流对象
 * 操作分为中间操作和终端操作
 * 中间操作会产生一个新流
 * 终端操作会消费流
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("abc");
        ls.add("def");
        ls.add("ddd");
        ls.add("eee");
        ls.add("def");
        ls.add("cba");
        ls.add("hello");

//        Optional<String> max = ls.stream().max(String::compareTo);
//        System.out.println(max.get());

        ls.stream().sorted().forEach(e -> System.out.println(e));

        System.out.println(ls.stream().distinct().count());
    }

}
