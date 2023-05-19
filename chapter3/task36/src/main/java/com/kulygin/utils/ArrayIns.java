package com.kulygin.utils;

import java.util.Arrays;
import java.util.Objects;

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

    public void insertionSortWithNoDups() {
        if (nElems == 1) {
            return;
        }
        int currentDup = 0;

        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                if (a[in - 1] == temp && a[in - 1] != -1) {
                    temp = -1;
                    currentDup++;
                }
                a[in] = a[in - 1];
                --in;
            }

            a[in] = temp;
        }

        int currentPos = 0;
        for (int i = currentDup; i < nElems; i++) {
            swap(currentPos, i);
            a[i] = 0;
            currentPos++;
        }
        nElems -= currentDup;
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
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

    public void noDups() {
        if (nElems < 2) {
            return;
        }
        insertionSort();
        int in, out;
        long nextUniq = a[1], currentUniq = a[0];
        long lastUniq = a[nElems - 1];
        int currentUniqIndex = 1;
        for (out = 1; out < nElems; out++) {
            in = out;

            if (currentUniq == lastUniq) {
                a[out] = 0;
                if (out == 1) {
                    currentUniqIndex = 0;
                }
            } else {
                while (a[in] == currentUniq || a[in] < nextUniq) {
                    in++;
                }
                nextUniq = a[in];

                a[out] = nextUniq;
                currentUniq = nextUniq;
                currentUniqIndex = out;
            }
        }
        nElems = currentUniqIndex + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayIns)) return false;
        ArrayIns arrayIns = (ArrayIns) o;
        return nElems == arrayIns.nElems && Arrays.equals(a, arrayIns.a);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nElems);
        result = 31 * result + Arrays.hashCode(a);
        return result;
    }
}
