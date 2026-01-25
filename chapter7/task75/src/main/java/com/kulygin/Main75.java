package com.kulygin;

import com.kulygin.utils.RadixSort;

public class Main75 {
    public static void main(String[] args) {
        int maxSize = 16;
        RadixSort arr = new RadixSort(maxSize);
        for (int j = 0; j < maxSize; j++) {
            long n = (int) (java.lang.Math.random() * 999);
            arr.insert(n);
        }
        arr.display();

        arr.radixSort(3);
        arr.display();
    }
}

