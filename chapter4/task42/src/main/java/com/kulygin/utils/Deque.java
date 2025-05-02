package com.kulygin.utils;

public class Deque {
    private final int maxSize;
    private final long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insertLeft(long j) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }
        if (--front < 0) {
            front = maxSize - 1;
        }
        queArray[front] = j;
        nItems++;
    }

    public void insertRight(long j) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }
        if (++rear == maxSize) {
            rear = 0;
        }
        queArray[rear] = j;
        nItems++;
    }

    public long removeLeft() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long removeRight() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        long temp = queArray[rear--];
        if (rear < 0) {
            rear = maxSize - 1;
        }
        nItems--;
        return temp;
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
}
