package com.charuniverse.e_lambda_collection;

import java.util.List;
import java.util.function.Consumer;

public class ListForEachApp {
    public static void main(String[] args) {
        List<String> names = List.of("Akbar", "Hasadi", "Putra", "Siregar");

        // for each
        for (var name : names) {
            System.out.println(name);
        }

        // anonymous class
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // lambda
        names.forEach(name -> System.out.println(name));

        // lambda method reference
        names.forEach(System.out::println);
    }
}