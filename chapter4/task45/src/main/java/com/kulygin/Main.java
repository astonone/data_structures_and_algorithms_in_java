package com.kulygin;

import com.kulygin.utils.ShopSimulator;

public class Main {
    public static void main(String[] args) {
        ShopSimulator shopSimulator = new ShopSimulator(5, 9, 1);
        shopSimulator.startSimulation();
    }
}