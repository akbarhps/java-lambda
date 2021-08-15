package com.charuniverse.d_method_reference;

import java.util.function.Predicate;

public class StringUtilObjectApp {
    public boolean isLowerCase(String param) {
        for (char c : param.toCharArray()) {
            if (!Character.isLowerCase(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StringUtilObjectApp app = new StringUtilObjectApp();
        Predicate<String> nonStaticPredicate = app::isLowerCase;
        System.out.println(nonStaticPredicate.test("Hello")); // false
        System.out.println(nonStaticPredicate.test("hello")); // true
    }
}