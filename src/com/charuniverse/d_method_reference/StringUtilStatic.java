package com.charuniverse.d_method_reference;

public class StringUtilStatic {
    public static boolean isLowerCase(String param) {
        for (char c : param.toCharArray()) {
            if (!Character.isLowerCase(c)) return false;
        }
        return true;
    }
}