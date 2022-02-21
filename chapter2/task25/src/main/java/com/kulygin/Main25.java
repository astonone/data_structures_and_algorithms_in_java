package com.kulygin;

import com.kulygin.utils.OrdArray;

public class Main25 {

    public static void main(String[] args) {
        int maxSize = 100;

        OrdArray arr1 = new OrdArray(maxSize);
        addToArrayRandomElements(arr1, 5, 100, 0, 20);
        arr1.display();

        OrdArray arr2 = new OrdArray(maxSize);
        addToArrayRandomElements(arr2, 10, 100, 0, 20);
        arr2.display();

        arr1.merge(arr2, maxSize * 2);
        arr1.display();
    }

    /**
     * A method of adding selected amount of random numbers to array.
     *
     * @param array            destination array
     * @param amountOfElements number of random elements which will be added to destination array
     * @param arrMaxSize       max size of destination array
     * @param lowerBound       lower bound of random numbers range
     * @param upperBound       upper bound of random numbers range
     */
    public static void addToArrayRandomElements(OrdArray array, int amountOfElements,
                                                int arrMaxSize, int lowerBound, int upperBound) {
        int amountOfRandomElements = Math.min(arrMaxSize, amountOfElements);
        for (int i = 0; i < amountOfRandomElements; i++) {
            array.insert(rnd(lowerBound, upperBound));
        }
    }

    /**
     * A method of obtaining a pseudo-random long from min to max (including max);
     */
    public static long rnd(long min, long max) {
        max -= min;
        return (long) (Math.random() * ++max) + min;
    }

}
