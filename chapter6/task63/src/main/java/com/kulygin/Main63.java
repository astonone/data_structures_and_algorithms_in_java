package com.kulygin;

public class Main63 {

    public static void main(String[] args) {
        System.out.println(power(2,2)); // 4
        System.out.println(power(2,5)); // 32
        System.out.println(power(2,10)); // 1024
        System.out.println(power(4,2)); // 16
        System.out.println(power(3,3)); // 27
    }

    public static int power(int base, int exponent) {
        if (exponent == 0)
            return 1;
        return base * power(base, exponent - 1);
    }
}
