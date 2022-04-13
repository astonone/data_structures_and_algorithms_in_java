package com.kulygin.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ArrayBubTest {
    @Test
    void shouldSortByBubbleSort_EvenArrSize() {
        int maxSize = 100;
        ArrayBub initialArray;
        initialArray = new ArrayBub(maxSize);

        initialArray.insert(77);
        initialArray.insert(99);
        initialArray.insert(44);
        initialArray.insert(55);
        initialArray.insert(22);
        initialArray.insert(88);
        initialArray.insert(11);
        initialArray.insert(00);
        initialArray.insert(66);
        initialArray.insert(33);

        ArrayBub expectedArray;
        expectedArray = new ArrayBub(maxSize);

        expectedArray.insert(00);
        expectedArray.insert(11);
        expectedArray.insert(22);
        expectedArray.insert(33);
        expectedArray.insert(44);
        expectedArray.insert(55);
        expectedArray.insert(66);
        expectedArray.insert(77);
        expectedArray.insert(88);
        expectedArray.insert(99);

        initialArray.oddEvenSort();

        assertThat(initialArray).isEqualTo(expectedArray);
    }

    @Test
    void shouldSortByBubbleSort_OddArrSize() {
        int maxSize = 100;
        ArrayBub initialArray;
        initialArray = new ArrayBub(maxSize);

        initialArray.insert(77);
        initialArray.insert(110);
        initialArray.insert(99);
        initialArray.insert(44);
        initialArray.insert(55);
        initialArray.insert(120);
        initialArray.insert(22);
        initialArray.insert(88);
        initialArray.insert(11);
        initialArray.insert(130);
        initialArray.insert(00);
        initialArray.insert(66);
        initialArray.insert(33);

        ArrayBub expectedArray;
        expectedArray = new ArrayBub(maxSize);

        expectedArray.insert(00);
        expectedArray.insert(11);
        expectedArray.insert(22);
        expectedArray.insert(33);
        expectedArray.insert(44);
        expectedArray.insert(55);
        expectedArray.insert(66);
        expectedArray.insert(77);
        expectedArray.insert(88);
        expectedArray.insert(99);
        expectedArray.insert(110);
        expectedArray.insert(120);
        expectedArray.insert(130);

        initialArray.oddEvenSort();

        assertThat(initialArray).isEqualTo(expectedArray);
    }

    @Test
    void shouldSortByBubbleSort_EvenArrSizeSmallArr() {
        int maxSize = 100;
        ArrayBub initialArray;
        initialArray = new ArrayBub(maxSize);

        initialArray.insert(77);
        initialArray.insert(99);

        ArrayBub expectedArray;
        expectedArray = new ArrayBub(maxSize);


        expectedArray.insert(77);
        expectedArray.insert(99);

        initialArray.oddEvenSort();

        assertThat(initialArray).isEqualTo(expectedArray);
    }

    @Test
    void shouldSortByBubbleSort_OddArrSizeSmallArr() {
        int maxSize = 100;
        ArrayBub initialArray;
        initialArray = new ArrayBub(maxSize);

        initialArray.insert(77);
        initialArray.insert(110);
        initialArray.insert(99);

        ArrayBub expectedArray;
        expectedArray = new ArrayBub(maxSize);


        expectedArray.insert(77);
        expectedArray.insert(99);
        expectedArray.insert(110);

        initialArray.oddEvenSort();

        assertThat(initialArray).isEqualTo(expectedArray);
    }
}