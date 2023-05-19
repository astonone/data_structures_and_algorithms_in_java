package com.kulygin;

import com.kulygin.utils.HighArray;

public class Main23 {

    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        HighArray sortedArray = primitiveSort(arr, maxSize);

        sortedArray.display();
    }

    /**
     * A method for sorting of array.
     *
     * @param arrayForSort array which will be sorted
     * @param maxArraySize max size of array
     */
    public static HighArray primitiveSort(HighArray arrayForSort, int maxArraySize) {
        HighArray sortedArray = new HighArray(maxArraySize);

        long maxEl = arrayForSort.removeMax();
        while (maxEl != -1) {
            sortedArray.insert(maxEl);
            maxEl = arrayForSort.removeMax();
        }

        return sortedArray;
    }
}
