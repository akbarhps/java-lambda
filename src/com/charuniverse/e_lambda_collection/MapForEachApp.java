package com.charuniverse.e_lambda_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapForEachApp {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(Map.of(
                "firstName", "Akbar",
                "middleName", "Hasadi",
                "lastName", "Putra"
        ));

        // for each
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // anonymous class
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + " : " + value);
            }
        });

        // lambda
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}