package com.charuniverse.g_lambda_optional;

import java.util.Optional;
import java.util.function.Function;

public class OptionalApp {
    public static void main(String[] args) {
        sayHello("Akbar");
        sayHello(null);
    }

    public static void sayHelloBetter(String name) {
        Optional.ofNullable(name)
                .map(String::toUpperCase)
                .ifPresent(param -> System.out.println("Hello, " + param));
    }

    public static void sayHello(String name) {
        Optional<String> optionalName = Optional.ofNullable(name);

        // anonymous class
        Optional<String> optionalUpperAnon = optionalName.map(new Function<String, String>() {
            @Override
            public String apply(String name) {
                return name.toUpperCase();
            }
        });

        // lambda
        Optional<String> optionalUpperLambda = optionalName.map(name1 -> name1.toUpperCase());

        // method reference
        Optional<String> optionalUpperMethodRef = optionalName.map(String::toUpperCase);

        optionalUpperMethodRef.ifPresent(nameUpper -> System.out.println("Hello, " + nameUpper));
    }
}