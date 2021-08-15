package com.charuniverse.c_java_util_function;

import java.util.function.Predicate;

public class PredicateApp {
    public static void main(String[] args) {
        Predicate<String> predicate = param -> param.isBlank();
        System.out.println(predicate.test("Hello World!")); // false
    }
}