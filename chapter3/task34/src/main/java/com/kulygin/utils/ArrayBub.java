package com.kulygin.utils;

import java.util.Arrays;
import java.util.Objects;

public class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
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

    public void oddEvenSort() {
        boolean isSwap = true;

        while (isSwap) {
            isSwap = false;

            for (int i = 0; i < nElems - 1; i+=2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    isSwap = true;
                }
            }

            for (int i = 1; i < nElems - 1; i+=2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    isSwap = true;
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayBub)) return false;
        ArrayBub arrayBub = (ArrayBub) o;
        return nElems == arrayBub.nElems && Arrays.equals(a, arrayBub.a);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nElems);
        result = 31 * result + Arrays.hashCode(a);
        return result;
    }
}
