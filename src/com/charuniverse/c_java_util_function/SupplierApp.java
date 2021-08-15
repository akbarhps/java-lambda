package com.charuniverse.c_java_util_function;

import java.util.function.Supplier;

public class SupplierApp {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello World!";
        System.out.println(supplier.get()); // Hello World!
    }
}