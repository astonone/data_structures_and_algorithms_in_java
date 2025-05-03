package com.kulygin;

import com.kulygin.utils.CyclicLinkedList;

public class Main {
    public static void main(String[] args) {
        CyclicLinkedList list = new CyclicLinkedList();
        list.insert(11);
        list.insert(22);
        list.insert(33);
        list.insert(44);

        System.out.println(list.delete());

        System.out.println(list.search(33));
        System.out.println(list.search(66));

        list.display();
        list.step();
        list.insert(55);
        list.display();
    }
}