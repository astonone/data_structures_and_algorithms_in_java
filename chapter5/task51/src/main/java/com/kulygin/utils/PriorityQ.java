package com.kulygin.utils;

public class PriorityQ {
    private final SortedLinkedList sortedLinkedList = new SortedLinkedList();

    public void insert(long item) {
        sortedLinkedList.insert(item);
    }

    public long remove() {
        return sortedLinkedList.remove().dData;
    }

    public long peekMin() {
        return sortedLinkedList.getFirst().dData;
    }

    public boolean isEmpty() {
        return sortedLinkedList.isEmpty();
    }

    public void display() {
        sortedLinkedList.displayList();
    }
}
