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

    public void bubbleSort() {
        int outUp, outDown = nElems - 1;
        int in;
        boolean isDirectionChanged = false;

        for (outUp = nElems - 1; outUp > 0; outUp--) {
            if (!isDirectionChanged) {
                for (in = (nElems - 1) - outDown; in < outDown; in++) {
                    if (a[in] > a[in + 1]) {
                        swap(in, in + 1);
                    }
                }
                isDirectionChanged = true;
                outDown--;
            } else {
                for (in = outDown; in > (nElems - 1) - outDown - 1; in--) {
                    if (a[in] < a[in - 1]) {
                        swap(in, in - 1);
                    }
                }
                isDirectionChanged = false;
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
