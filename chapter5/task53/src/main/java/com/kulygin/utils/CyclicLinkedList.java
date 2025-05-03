package com.kulygin.utils;

public class CyclicLinkedList {
    private Link current;

    public CyclicLinkedList() {
        this.current = null;
    }

    public boolean isEmpty() {
        return current == null;
    }

    public void insert(long j) {
        Link newLink = new Link(j);
        if (isEmpty()) {
            current = newLink;
            current.next = current;
        } else {
            Link temp = current.next;
            current.next = newLink;
            newLink.next = temp;
        }
    }

    public long delete() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (current.next == current) {
            long valueToDelete = current.dData;
            current = null;
            return valueToDelete;
        }
        long valueToDelete = current.next.dData;
        Link temp = current.next.next;
        current.next = temp;
        return valueToDelete;
    }

    public Link search(long key) {
        Link curr = current;
        while (curr.dData != key) {
            curr = curr.next;
            if (curr == current) {
                break;
            }
        }
        return curr.dData == key ? curr : null;
    }

    public void display() {
        Link curr = current;
        do {
            System.out.print(curr.dData + " ");
            curr = curr.next;
        } while (curr != current);
        System.out.println();
    }

    public void step() {
        current = current.next;
    }
}
