package com.kulygin.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrdArrayTest {

    @Test
    void size() {
        OrdArray arr = new OrdArray(100);
        arr.insert(77);
        arr.insert(99);

        assertThat(arr.size()).isEqualTo(2);
    }

    @Test
    void find() {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);
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

        final int actualIndex = arr.find(44);

        assertThat(actualIndex).isEqualTo(4);
    }

    @Test
    void insert() {
        int maxSize = 100;
        OrdArray actualArray = new OrdArray(maxSize);
        actualArray.insert(77);
        actualArray.insert(99);
        actualArray.insert(44);
        actualArray.insert(55);
        actualArray.insert(22);
        actualArray.insert(88);
        actualArray.insert(11);
        actualArray.insert(0);
        actualArray.insert(66);
        actualArray.insert(33);

        OrdArray expectedArray = new OrdArray(maxSize);
        expectedArray.insert(0);
        expectedArray.insert(11);
        expectedArray.insert(22);
        expectedArray.insert(33);
        expectedArray.insert(44);
        expectedArray.insert(55);
        expectedArray.insert(66);
        expectedArray.insert(77);
        expectedArray.insert(88);
        expectedArray.insert(99);

        assertThat(actualArray).isEqualTo(expectedArray);
    }

    @Test
    void delete() {
        int maxSize = 100;
        OrdArray actualArray = new OrdArray(maxSize);
        actualArray.insert(77);
        actualArray.insert(99);
        actualArray.insert(44);
        actualArray.insert(55);
        actualArray.insert(22);
        actualArray.insert(88);
        actualArray.insert(11);
        actualArray.insert(0);
        actualArray.insert(66);
        actualArray.insert(33);

        OrdArray expectedArray = new OrdArray(maxSize);
        expectedArray.insert(0);
        expectedArray.insert(11);
        expectedArray.insert(22);
        expectedArray.insert(33);
        expectedArray.insert(55);
        expectedArray.insert(66);
        expectedArray.insert(77);
        expectedArray.insert(88);
        expectedArray.insert(99);

        actualArray.delete(44);

        assertThat(actualArray).isEqualTo(expectedArray);
    }
}