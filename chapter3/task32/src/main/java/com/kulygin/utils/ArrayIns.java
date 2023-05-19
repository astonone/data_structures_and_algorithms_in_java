package com.kulygin.utils;

public class ArrayIns {

    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }

    public long median() {
        insertionSort();

        final boolean isOdd = nElems % 2 != 0;

        if (isOdd) {
            return a[nElems / 2];
        } else {
            return (a[nElems / 2] + a[nElems / 2 - 1]) / 2;
        }
    }
}
