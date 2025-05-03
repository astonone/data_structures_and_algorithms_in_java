package com.kulygin.utils;

public class JosephusFlaviusTaskSimulator {
    private final int peopleAmount;
    private final int startNumber;
    private final int stepSize;
    private final CyclicLinkedList circle;

    public JosephusFlaviusTaskSimulator(int peopleAmount, int startNumber, int stepSize) {
        this.peopleAmount = peopleAmount;
        this.startNumber = startNumber;
        this.stepSize = stepSize;
        circle = new CyclicLinkedList();
    }

    public void simulate() {
        initCircle();
        setupStartPosition();

        System.out.println("Starting count from " + startNumber + ", step " + stepSize);

        while (!circle.isEmpty()) {
            System.out.print("Current state:");
            circle.display();
            for (int i = 0; i < stepSize - 1; i++) {
                circle.step();
            }
            System.out.println("Number " + circle.delete() + " is leaving circle");
            if (!circle.isEmpty()) {
                circle.step();
            }
        }
    }

    private void initCircle() {
        for (int i = 0; i < peopleAmount; i++) {
            circle.insert(peopleAmount - i);
        }
        circle.step();
    }

    private void setupStartPosition() {
        long current = circle.getCurrent();
        while (current != startNumber) {
            circle.step();
            current = circle.getCurrent();
        }
    }
}
