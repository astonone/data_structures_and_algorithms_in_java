package com.kulygin;

import com.kulygin.utils.HighArray;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Main23Test {

    @Test
    void shouldSortArray() {
        HighArray arrayForSort = new HighArray(100);
        arrayForSort.insert(77);
        arrayForSort.insert(99);
        arrayForSort.insert(44);
        arrayForSort.insert(55);
        arrayForSort.insert(22);
        arrayForSort.insert(88);
        arrayForSort.insert(11);
        arrayForSort.insert(0);
        arrayForSort.insert(66);
        arrayForSort.insert(33);

        HighArray expectedArray = new HighArray(100);
        expectedArray.insert(99);
        expectedArray.insert(88);
        expectedArray.insert(77);
        expectedArray.insert(66);
        expectedArray.insert(55);
        expectedArray.insert(44);
        expectedArray.insert(33);
        expectedArray.insert(22);
        expectedArray.insert(11);
        expectedArray.insert(0);

        final HighArray actualArray = Main23.primitiveSort(arrayForSort, 100);

        assertThat(actualArray).isEqualTo(expectedArray);
    }

    @Test
    void shouldSortArray_emptyArray() {
        HighArray arrayForSort = new HighArray(100);
        HighArray expectedArray = new HighArray(100);

        final HighArray actualArray = Main23.primitiveSort(arrayForSort, 100);

        assertThat(actualArray).isEqualTo(expectedArray);
    }
}