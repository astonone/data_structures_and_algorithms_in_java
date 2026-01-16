package com.kulygin;

public class Main64 {
    static int[] weights = {11, 8, 7, 6, 5};

    public static void main(String[] args) {
        int targetWeight = 20;
        boolean result = knapsack(targetWeight, 0);
        System.out.println(result);
    }

    public static boolean knapsack(int targetWeight, int index) {
        if (targetWeight == 0) {
            return true;
        }
        if (targetWeight < 0 || index > weights.length - 1) {
            return false;
        }
        if (knapsack(targetWeight, index + 1)) {
            return true;
        } else if (knapsack(targetWeight - weights[index], index + 1)) {
            System.out.println(weights[index]);
            return true;
        } else  {
            return false;
        }
    }
}
