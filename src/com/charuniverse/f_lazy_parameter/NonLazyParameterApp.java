package com.charuniverse.f_lazy_parameter;

public class NonLazyParameterApp {
    public static void main(String[] args) {
        testScoreNonLambda(90, "Akbar");
    }

    public static void testScoreNonLambda(int score, String name) {
        if (score > 80) {
            System.out.println("Selamat " + name + ", Anda Lulus");
        } else {
            System.out.println("Coba Lagi Tahun Depan");
        }
    }
}