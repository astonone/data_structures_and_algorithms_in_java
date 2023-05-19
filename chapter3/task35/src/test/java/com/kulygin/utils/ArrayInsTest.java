package com.kulygin.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ArrayInsTest {

    @Test
    public void insertionSort() {
        int maxSize = 100;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        arr.insert(0);
        arr.insert(1);
        arr.insert(2);
        arr.insert(5);
        arr.insert(4);

        String result = arr.insertionSort();
        assertThat(result).isEqualTo("Copy amount: 13, Compare amount: 5");
    }
}