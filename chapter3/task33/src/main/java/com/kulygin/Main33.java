package com.kulygin;

import com.kulygin.utils.ArrayIns;

public class Main33 {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        arr.insert(9);
        arr.insert(7);
        arr.insert(9);
        arr.insert(3);
        arr.insert(6);
        arr.insert(1);
        arr.insert(1);
        arr.insert(1);
        arr.insert(2);
        arr.insert(2);

        arr.display();
        arr.insertionSort();
        arr.display();
        arr.noDups();
        arr.display();
    }
}
