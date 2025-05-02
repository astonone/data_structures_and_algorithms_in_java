package com.kulygin.utils;

public class Queue {
    private final int maxSize;
    private final long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return  nItems == maxSize;
    }

    public int size() {
        return nItems;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        if (size() == 1) {
            System.out.println(peekFront());
            return;
        }
        int tempFront = front;
        int tempNItems = nItems;
        while (tempNItems != 0) {
            long temp = queArray[tempFront++];
            if (tempFront == maxSize) {
                tempFront = 0;
            }
            tempNItems--;
            System.out.println(temp);
        }
    }
}
