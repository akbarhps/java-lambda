package com.charuniverse.g_lambda_optional;

import java.util.Optional;

public class DataOptionalApp {
    public static void main(String[] args) {
        sayHello("Akbar");
        sayHello2(null);
    }

    public static void sayHello2(String name) {
        Optional.ofNullable(name)
                .map(String::toUpperCase)
                .ifPresentOrElse(
                        upperName -> System.out.println("Hello, " + name),
                        () -> System.out.println("Hello, THERE")
                );
    }

    public static void sayHello(String name) {
        String nameUpperCase = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("THERE");
        System.out.println("Hello, " + nameUpperCase);
    }
}