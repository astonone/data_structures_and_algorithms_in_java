package com.kulygin;

import com.kulygin.utils.JosephusFlaviusTaskSimulator;

public class Main {
    public static void main(String[] args) {
        JosephusFlaviusTaskSimulator simulator = new JosephusFlaviusTaskSimulator(7, 1, 3);
        simulator.simulate();
    }
}