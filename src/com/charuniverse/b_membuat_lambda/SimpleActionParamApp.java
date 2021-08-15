package com.charuniverse.b_membuat_lambda;

public class SimpleActionParamApp {
    public static void main(String[] args) {
        SimpleActionParam simpleActionParam1 = (String name) -> {
            return "Hello, " + name;
        };

        SimpleActionParam simpleActionParam2 = (name) -> {
            return "Hello, " + name;
        };

        SimpleActionParam simpleActionParam3 = (String name) -> "Hello, " + name;

        SimpleActionParam simpleActionParam4 = (name) -> "Hello, " + name;

        SimpleActionParam simpleActionParam5 = name -> "Hello, " + name;

        SimpleActionParam simpleActionParam6 = param -> "Hello, " + param;
    }
}