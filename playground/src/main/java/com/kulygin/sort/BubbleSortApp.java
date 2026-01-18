package com.kulygin.sort;

public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr = new ArrayBub(maxSize);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();
        arr.bubbleSort();
        arr.display();
    }
}

class ArrayBub {
    private long[] a;
    private int nElems;
    private int comparisons;
    private int copies;

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
        for (out = nElems - 1; out > 1; out--)
            for (in = 0; in < out; in++)
                if (a[in] > a[in + 1]) {
                    comparisons++;
                    swap(in, in + 1);
                }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
        copies += 3;
    }
}
