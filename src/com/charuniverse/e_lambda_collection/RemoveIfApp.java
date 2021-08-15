package com.charuniverse.e_lambda_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfApp {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                List.of("Akbar", "Hasadi", "Putra", "Siregar")
        );

        // for each
        for (var name : names) {
            if (name.length() > 5) {
                names.remove(name);
            }
        }

        // anonymous class
        names.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 5;
            }
        });

        // lambda
        names.removeIf(name -> name.length() > 5);
    }
}