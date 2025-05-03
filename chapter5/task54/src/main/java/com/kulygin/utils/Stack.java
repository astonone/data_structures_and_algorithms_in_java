package com.kulygin.utils;

public class Stack {
    private final CyclicLinkedList cyclicLinkedList;

    public Stack() {
        cyclicLinkedList = new CyclicLinkedList();
    }

    public void push(long j) {
        cyclicLinkedList.insert(j);
    }

    public long pop() {
        try {
            return cyclicLinkedList.delete();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public long peek() {
        return cyclicLinkedList.getFirst();
    }

    public boolean isEmpty() {
        return cyclicLinkedList.isEmpty();
    }
}
