package ru.otus;


import com.google.common.collect.Lists;

import java.util.ArrayList;

public class HelloOtus {
    public static void main(String... args) {
        ArrayList<Integer> numbers = Lists.newArrayList(0, 1, 2, 3, 4);
        numbers.forEach(System.out::println);
    }

}
