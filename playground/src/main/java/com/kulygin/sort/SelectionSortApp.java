package com.kulygin.sort;

public class SelectionSortApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ArraySel arr = new ArraySel(maxSize);
        for (int j = 0; j < maxSize; j++) {
            long n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        long startTime = System.currentTimeMillis();
        arr.selectionSort();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        arr.display();
    }
}

class ArraySel {
    private long[] a;
    private int nElems;
    private long comparisons;
    private long copies;

    public ArraySel(int max) {
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

    public void selectionSort() {
        comparisons = 0;
        copies = 0;
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                comparisons++;
                if (a[in] < a[min]) {
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
        copies += 3;
    }
}
