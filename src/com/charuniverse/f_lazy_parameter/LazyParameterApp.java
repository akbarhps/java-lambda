package com.charuniverse.f_lazy_parameter;

import java.util.function.Supplier;

public class LazyParameterApp {
    public static void main(String[] args) {
        // lambda
        testScoreLambda(50, () -> getName());

        // method reference
        testScoreLambda(90, LazyParameterApp::getName);
    }

    public static void testScoreLambda(int score, Supplier<String> name) {
        if (score > 80) {
            System.out.println("Selamat " + name.get() + ", Anda Lulus");
        } else {
            System.out.println("Coba Lagi Tahun Depan");
        }
    }

    public static String getName() {
        System.out.println("function getName() dipanggil");
        return "Akbar";
    }
}