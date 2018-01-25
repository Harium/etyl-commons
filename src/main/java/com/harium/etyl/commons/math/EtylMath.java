package com.harium.etyl.commons.math;

public class EtylMath {

    public static double diffMod(double a, double b) {
        double result = a - b;
        return mod(result);
    }

    public static double divMod(double a, double b) {
        double result = a / b;
        return mod(result);
    }

    public static double sqr(double a) {
        return a * a;
    }

    public static double mod(double a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int min(int a, int b, int c) {
        return min(a, min(b, c));
    }

}
