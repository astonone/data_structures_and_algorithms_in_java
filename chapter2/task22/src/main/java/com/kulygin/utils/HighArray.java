package com.kulygin.utils;

import java.util.Arrays;
import java.util.Objects;

public class HighArray {

    private long[] array;             // Link to the array
    private int nElems;               // Number of elements in array

    public HighArray(int max) {
        array = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (array[j] == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            return true;
        }
    }

    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (value == array[j]) {
                break;
            }
        }
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++) {
                array[k] = array[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println("");
    }

    public long removeMax() {
        if (nElems == 0) {
            return -1;
        }
        long max = array[0];
        for (int i = 0; i < nElems; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        delete(max);
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HighArray array1 = (HighArray) o;
        return nElems == array1.nElems && Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nElems);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
