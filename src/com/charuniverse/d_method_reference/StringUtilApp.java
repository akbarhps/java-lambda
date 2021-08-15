package com.charuniverse.d_method_reference;

import java.util.function.Predicate;

public class StringUtilApp {
    public static void main(String[] args) {
        Predicate<String> predicate = StringUtilStatic::isLowerCase;
        System.out.println(predicate.test("Hello")); // false
        System.out.println(predicate.test("hello")); // true
    }
}