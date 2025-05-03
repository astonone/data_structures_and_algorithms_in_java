package com.kulygin;

import com.kulygin.utils.Deque;

public class Main {
    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.insertLeft(33);
        deque.insertLeft(22);
        deque.insertLeft(11);
        deque.insertRight(44);
        deque.insertRight(55);
        deque.insertRight(66);
        deque.insertRight(77);
        deque.insertRight(88);
        deque.insertRight(99);

        System.out.println(deque.removeRight()); // 99
        System.out.println(deque.removeLeft()); // 11
    }
}