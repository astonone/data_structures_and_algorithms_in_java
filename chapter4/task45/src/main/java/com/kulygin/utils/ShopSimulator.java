package com.kulygin.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopSimulator {

    private final List<Customer> customers = new ArrayList<>();
    private final List<Queue<Customer>> queues = new ArrayList<>();
    private int lastUsedQueueIdx;

    public ShopSimulator(int amountOfCustomers, int amountOfQueues, int queueMaxSize) {
        if (queueMaxSize * amountOfQueues < amountOfCustomers) {
            throw new IllegalStateException("Amount of customers is too big to be placed in: " + amountOfQueues + " queues with maxSize: " + queueMaxSize);
        }

        for (int i = 0; i < amountOfCustomers; i++) {
            customers.add(new Customer());
        }
        for (int i = 0; i < amountOfQueues; i++) {
            queues.add(new Queue<>(queueMaxSize));
        }
        lastUsedQueueIdx = 0;
    }

    public void startSimulation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press Enter for simulate 1 min time spent (or q for exit)");

        splitCustomersToQueues();
        displayCurrentState();

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exit...");
                break;
            }

            System.out.println("Minute passed, modeling  event...");

            serviceCustomersInQueue();
            displayCurrentState();

            if (areQueuesEmpty()) {
                System.out.println("All customers were serviced, exit simulation...");
                break;
            }
        }

        scanner.close();
    }

    private void serviceCustomersInQueue() {
        for (int i = 0; i < queues.size(); i++) {
            Queue<Customer> currentQueue = queues.get(i);
            if (currentQueue.isEmpty()) {
                continue;
            }
            Customer customer = currentQueue.peekFront();
            customer.setRequiredAmountOfTimeForServicing(customer.getRequiredAmountOfTimeForServicing() - 1);

            if (customer.getRequiredAmountOfTimeForServicing() == 0) {
                currentQueue.remove();
                System.out.println(customer.getName() + " was serviced, this customer is leaving queue " + (i + 1));
            }
        }
    }

    private void splitCustomersToQueues() {
        customers.forEach(customer -> {
            Queue<Customer> currentQueue = queues.get(lastUsedQueueIdx);

            while (true) {
                if (!currentQueue.isFull()) {
                    currentQueue.insert(customer);
                    lastUsedQueueIdx++;
                    if (lastUsedQueueIdx > queues.size() - 1) {
                        lastUsedQueueIdx = 0;
                    }
                    break;
                } else {
                    lastUsedQueueIdx++;
                    currentQueue = queues.get(lastUsedQueueIdx);
                }
            }
        });
    }

    private void displayCurrentState() {
        System.out.println("Current queue's state:");
        for (int i = 0; i < queues.size(); i++) {
            System.out.println("Queue: " + (i + 1));
            queues.get(i).display();
            System.out.println();
        }
    }

    public boolean areQueuesEmpty() {
        for (Queue<Customer> queue : queues) {
            if (!queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
