package com.kulygin.stack_queue;

public class DequeApp {
    public static void main(String[] args) {
        Deque theDeque = new Deque(5);
        theDeque.insertRight(10);
        theDeque.insertRight(20);
        theDeque.insertRight(30);
        theDeque.insertLeft(40);
        theDeque.insertLeft(50);

        while (!theDeque.isEmpty()) {
            long n = theDeque.removeLeft();
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}

class Deque {
    private int maxSize;
    private long[] dequeArray;
    private int left;
    private int right;
    private int nItems;

    public Deque(int s) {
        maxSize = s;
        dequeArray = new long[maxSize];
        left = 0;
        right = -1;
        nItems = 0;
    }

    public void insertRight(long j) {
        if (right == maxSize - 1)
            right = -1;
        dequeArray[++right] = j;
        nItems++;
    }

    public void insertLeft(long j) {
        if (left == 0)
            left = maxSize;
        dequeArray[--left] = j;
        nItems++;
    }

    public long removeLeft() {
        long temp = dequeArray[left++];
        if (left == maxSize)
            left = 0;
        nItems--;
        return temp;
    }

    public long removeRight() {
        long temp = dequeArray[right--];
        if (right == -1)
            right = maxSize - 1;
        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }
}
