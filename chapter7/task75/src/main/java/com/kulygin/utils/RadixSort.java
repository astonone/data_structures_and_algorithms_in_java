package com.kulygin.utils;

public class RadixSort {
    private long[] theArray;
    private int nElems;

    public RadixSort(int max) {
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

    private int getDigitInPos(long value, int pos) {
        long divisor = (long) Math.pow(10, pos);
        return (int) ((value / divisor) % 10);
    }

    public void radixSort(int maxSizeOfNumber) {
        Queue[] buckets = new Queue[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Queue(theArray.length);
        }

        for (int digit = 0; digit < maxSizeOfNumber; digit++) {


            for (int keyIdx = 0; keyIdx < theArray.length; keyIdx++) {
                long key = theArray[keyIdx];
                int currentKeyDigit = getDigitInPos(key, digit);
                buckets[currentKeyDigit].insert(key);
            }

            long[] partiallySortedArr = new long[nElems];
            int partiallySortedArrIdx = 0;

            for (int i = 0; i < buckets.length; i++) {
                Queue currentQueue = buckets[i];
                while (!currentQueue.isEmpty()) {
                    partiallySortedArr[partiallySortedArrIdx++] = currentQueue.remove();
                }
            }

            theArray = partiallySortedArr;
        }
    }
}
