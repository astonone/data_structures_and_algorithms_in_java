package com.kulygin.utils;

public class Stack {
    private final Deque deque;

    public Stack(int s) {
        deque = new Deque(s);
    }

    public void push(long j) {
        try {
            deque.insertLeft(j);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Stack is full");
        }
    }

    public long pop() {
        try {
            return deque.removeLeft();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public long peek() {
        return deque.peekLeft();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }
}
