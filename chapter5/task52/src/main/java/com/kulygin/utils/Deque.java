package com.kulygin.utils;

public class Deque {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

    public void insertLeft(long j) {
        doublyLinkedList.insertFirst(j);
    }

    public void insertRight(long j) {
        doublyLinkedList.insertLast(j);
    }

    public long removeLeft() {
        if (doublyLinkedList.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return doublyLinkedList.deleteFirst().dData;
    }

    public long peekLeft() {
        if (doublyLinkedList.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return doublyLinkedList.getFirst().dData;
    }

    public long peekRight() {
        if (doublyLinkedList.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return doublyLinkedList.getLast().dData;
    }

    public long removeRight() {
        if (doublyLinkedList.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return doublyLinkedList.deleteLast().dData;
    }

    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }
}
