package com.charuniverse.d_method_reference;

import java.util.function.Predicate;

public class StringUtilNonStaticApp {
    public boolean isLowerCase(String param) {
        for (char c : param.toCharArray()) {
            if (!Character.isLowerCase(c)) return false;
        }
        return true;
    }

    public void nonStaticPredicate() {
        Predicate<String> nonStaticPredicate = this::isLowerCase;
        System.out.println(nonStaticPredicate.test("Hello")); // false
        System.out.println(nonStaticPredicate.test("hello")); // true
    }

    public static void main(String[] args) {
        StringUtilNonStaticApp app = new StringUtilNonStaticApp();
        app.nonStaticPredicate();
    }
}
