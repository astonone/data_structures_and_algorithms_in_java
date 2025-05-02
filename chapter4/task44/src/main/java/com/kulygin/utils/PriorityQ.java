package com.kulygin.utils;

public class PriorityQ {
    private final int maxSize;
    private final long[] queArray;
    private int nItems;

    public PriorityQ(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queArray[nItems++] = item;
    }

    public long remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int minElIdx = 0;
        for (int i = 0; i < nItems; i++) {
            if (queArray[i] < queArray[minElIdx]) {
                minElIdx = i;
            }
        }
        long temp = queArray[minElIdx];
        for (int i = minElIdx; i < nItems - 1; i++) {
            queArray[i] = queArray[i + 1];
        }
        nItems--;
        return temp;
    }

    public long peekMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int minElIdx = 0;
        for (int i = 0; i < nItems; i++) {
            if (queArray[i] < queArray[minElIdx]) {
                minElIdx = i;
            }
        }
        return queArray[minElIdx];
    }

    public boolean isEmpty() {
        return (nItems==0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int tempNItems = nItems;
        long[] tempQueueArray = new long[nItems];
        System.arraycopy(queArray, 0, tempQueueArray, 0, nItems);
        while (tempNItems > 0) {
            int minElIdx = 0;
            for (int i = 0; i < tempNItems; i++) {
                if (tempQueueArray[i] < tempQueueArray[minElIdx]) {
                    minElIdx = i;
                }
            }
            long temp = tempQueueArray[minElIdx];
            for (int i = minElIdx; i < nItems - 1; i++) {
                tempQueueArray[i] = tempQueueArray[i + 1];
            }
            tempNItems--;
            System.out.println(temp);
        }
    }
}
