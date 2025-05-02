package com.kulygin.utils;

public class Customer {
    private final String name;
    private int requiredAmountOfTimeForServicing;

    public Customer() {
        this.name = NameGenerator.getRandomName();
        requiredAmountOfTimeForServicing = rnd(1,5);
    }

    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public String getName() {
        return name;
    }

    public int getRequiredAmountOfTimeForServicing() {
        return requiredAmountOfTimeForServicing;
    }

    public void setRequiredAmountOfTimeForServicing(int requiredAmountOfTimeForServicing) {
        this.requiredAmountOfTimeForServicing = requiredAmountOfTimeForServicing;
    }

    @Override
    public String toString() {
        return "{'" + name + '\'' + ", timeLeft=" + requiredAmountOfTimeForServicing + '}';
    }
}
