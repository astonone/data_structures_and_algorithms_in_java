package com.kulygin.sort;

public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ArrayBub arr = new ArrayBub(maxSize);
        for (int j = 0; j < maxSize; j++) {
            long n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        long startTime = System.currentTimeMillis();
        arr.bubbleSort();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        arr.display();
    }
}

class ArrayBub {
    private long[] a;
    private int nElems;
    private long comparisons;
    private long copies;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
        System.out.println("Comparisons: " + comparisons + ", copies: " + copies);
    }

    public void bubbleSort() {
        comparisons = 0;
        copies = 0;
        int out, in;
        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                comparisons++;
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
        copies += 3;
    }
}
