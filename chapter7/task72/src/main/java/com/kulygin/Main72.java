package com.kulygin;

public class Main72 {
    public static void main(String[] args) {
        int maxSize = 10;
        ArrayIns arr = new ArrayIns(maxSize);
        for (int j = 0; j < maxSize; j++) {
            long n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.quickSort();
        arr.display();
        arr.printStatistics();
    }
}

class ArrayIns {
    private long[] theArray;
    private int nElems;
    private int comparisons;
    private int copies;

    public ArrayIns(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }

    public void quickSort() {
        comparisons = 0;
        copies = 0;
        recQuickSort(0, nElems - 1);
    }

    public void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(left, right);
        else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public long medianOf3(int left, int right) {
        int center = (left + right) / 2;
        if (theArray[left] > theArray[center])
            swap(left, center);
        if (theArray[left] > theArray[right])
            swap(left, right);
        if (theArray[center] > theArray[right])
            swap(center, right);
        comparisons += 3;

        swap(center, right - 1);
        return theArray[right - 1];
    }

    public void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
        copies += 3;
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            while (theArray[++leftPtr] < pivot) {
                comparisons++;
            }
            comparisons++;
            while (theArray[--rightPtr] > pivot) {
                comparisons++;
            }
            comparisons++;
            if (leftPtr >= rightPtr) {
                break;
            } else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    public void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (theArray[left] > theArray[right]) {
                comparisons++;
                swap(left, right);
            }
            return;
        } else {
            if (theArray[left] > theArray[right - 1])
                swap(left, right - 1);
            if (theArray[left] > theArray[right])
                swap(left, right);
            if (theArray[right - 1] > theArray[right])
                swap(right - 1, right);
            comparisons += 3;
        }
    }

    public void printStatistics() {
        System.out.println("Comparisons: " + comparisons + ", copies: " + copies);
    }
}
