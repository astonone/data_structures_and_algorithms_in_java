package com.kulygin;

public class Main61 {

    public static void main(String[] args) {
        System.out.println(mult(3,2)); // 6
        System.out.println(mult(4,4)); // 16
        System.out.println(mult(3,5)); // 15
    }

    public static int mult(int x, int y) {
        if (y == 1) {
            return x;
        }
        return x + mult(x, y - 1);
    }
}