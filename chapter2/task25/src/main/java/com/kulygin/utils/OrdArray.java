package com.kulygin.utils;

import java.util.Arrays;
import java.util.Objects;

public class OrdArray {

    private long[] array;
    private int nElems;

    public OrdArray(int max) {
        array = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public long get(int position) {
        return array[position];
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (array[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (array[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int j = findFirstGreaterThen(value);
        for (int k = nElems; k > j; k--) {
            array[k] = array[k - 1];
        }
        array[j] = value;
        nElems++;
    }

    /**
     * A method of finding index first element of array which greater than search key using binary search.
     *
     * @param searchKey key for which will be found index of first element greater than key
     */
    private int findFirstGreaterThen(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (array[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return lowerBound;
            } else {
                if (array[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
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

    public OrdArray merge(OrdArray arrayForMerge, int resultArrayMaxSize) {
        long[] resultArray = new long[resultArrayMaxSize];

        if (this.size() == 0) {
            for (int i = 0; i < arrayForMerge.size(); i++) {
                resultArray[i] = arrayForMerge.get(i);
            }
            array = resultArray;
            nElems = arrayForMerge.size();

            return this;
        }
        if (arrayForMerge.size() == 0) {
            for (int i = 0; i < this.size(); i++) {
                resultArray[i] = this.get(i);
            }

            array = resultArray;

            return this;
        }

        int sourceArrayIndex = 0;
        int arrayForMergeIndex = 0;
        int resultArrayIndex = 0;

        while (true) {
            if (sourceArrayIndex < this.size() && arrayForMergeIndex < arrayForMerge.size()) {
                if (this.get(sourceArrayIndex) < arrayForMerge.get(arrayForMergeIndex)) {
                    resultArray[resultArrayIndex] = this.get(sourceArrayIndex);
                    sourceArrayIndex++;
                } else {
                    resultArray[resultArrayIndex] = arrayForMerge.get(arrayForMergeIndex);
                    arrayForMergeIndex++;
                }
                resultArrayIndex++;
            } else if (sourceArrayIndex < this.size() && arrayForMergeIndex == arrayForMerge.size()) {
                resultArray[resultArrayIndex] = this.get(sourceArrayIndex);
                sourceArrayIndex++;
                resultArrayIndex++;
            } else if (sourceArrayIndex == this.size() && arrayForMergeIndex < arrayForMerge.size()) {
                resultArray[resultArrayIndex] = arrayForMerge.get(arrayForMergeIndex);
                arrayForMergeIndex++;
                resultArrayIndex++;
            } else {
                break;
            }
        }

        array = resultArray;
        nElems = resultArrayIndex;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdArray ordArray = (OrdArray) o;
        return nElems == ordArray.nElems && Arrays.equals(array, ordArray.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nElems);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
