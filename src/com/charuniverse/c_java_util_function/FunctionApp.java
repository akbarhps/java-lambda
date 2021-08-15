package com.charuniverse.c_java_util_function;

import java.util.function.Function;

public class FunctionApp {
    public static void main(String[] args) {
        Function<String, Integer> function = value -> value.length();
        System.out.println(function.apply("Hello World!")); // 12
    }
}