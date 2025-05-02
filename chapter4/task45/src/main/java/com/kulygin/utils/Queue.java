package com.kulygin.utils;

public class Queue<T> {
    private final int maxSize;
    private final T[] queArray;
    private int front;
    private int rear;
    private int nItems;

    @SuppressWarnings("unchecked")
    public Queue(int s) {
        maxSize = s;
        queArray = (T[]) new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = item;
        nItems++;
    }

    public T remove() {
        T temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public T peekFront() {
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
            T temp = queArray[tempFront++];
            if (tempFront == maxSize) {
                tempFront = 0;
            }
            tempNItems--;
            System.out.print(temp + " ");
        }
    }
}
