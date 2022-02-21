package com.kulygin;

import com.kulygin.utils.HighArray;

public class Main26 {

    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);
        arr.insert(77);
        arr.insert(77);
        arr.insert(77);
        arr.insert(99);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(11);
        arr.insert(11);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(66);
        arr.insert(33);
        arr.insert(33);

        arr.display();

        arr.noDups();
        System.out.println("Removed dups:");
        arr.display();
    }
}
