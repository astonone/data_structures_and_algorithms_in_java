package com.kulygin;

public class Main71 {
    public static void main(String[] args) {
        int maxSize = 2;
        ArrayPar arr = new ArrayPar(maxSize);
        for (int j = 0; j < maxSize; j++) {
            long n = (int) (java.lang.Math.random() * 199);
            arr.insert(n);
        }
        arr.display();

        int size = arr.size();
        
        // Partition array
        int partDex = arr.partitionIt(0, size - 1);
        System.out.println(", Partition is at index " + partDex);
        arr.display();
    }
}

class ArrayPar {
    private long[] theArray;
    private int nElems;

    public ArrayPar(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public int size() {
        return nElems;
    }

    public void display() {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }

    public int partitionIt(int left, int right) {
        long pivot = theArray[right];
        System.out.print("Pivot is " + pivot);

        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (leftPtr < right && theArray[++leftPtr] < pivot)
                ; // (nop)
            while (rightPtr > left && theArray[--rightPtr] > pivot)
                ; // (nop)
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        if (theArray[leftPtr] > pivot) {
            swap(leftPtr, right);
        }
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
