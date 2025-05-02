package com.kulygin;

import com.kulygin.utils.Deque;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Deque deque = new Deque(5);
        deque.insertRight(10);
        deque.insertRight(20);
        deque.insertLeft(5);
        deque.insertLeft(2);
        System.out.println(deque.removeRight()); // 20
        System.out.println(deque.removeLeft());  // 2
    }
}