package com.charuniverse.a_pengenalan_lambda;

public class SimpleActionApp {
    public static void main(String[] args) {
        SimpleAction simpleAction1 = new SimpleAction() {
            @Override
            public String action() {
                return "Hello World!";
            }
        };
        System.out.println(simpleAction1.action());

        SimpleAction simpleAction2 = () -> "Hello World!";
        System.out.println(simpleAction2.action());
    }
}