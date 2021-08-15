package com.charuniverse.d_method_reference;

import java.util.Locale;
import java.util.function.Function;

public class StringUtilParameterApp {
    public static void main(String[] args) {
        // method yang dipanggil wajib tidak memiliki parameter

//        Function<String, String> functionUpperCase = s -> s.toUpperCase();
        Function<String, String> functionUpperCase = String::toUpperCase;
        System.out.println(functionUpperCase.apply("hello kecil")); // HELLO KECIL
    }
}