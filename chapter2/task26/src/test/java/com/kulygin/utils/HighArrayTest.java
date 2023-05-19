package com.kulygin.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HighArrayTest {

    @Test
    void shouldRemoveDups() {
        int maxSize = 100;
        HighArray arrayForRemoving = new HighArray(maxSize);
        arrayForRemoving.insert(77);
        arrayForRemoving.insert(77);
        arrayForRemoving.insert(77);
        arrayForRemoving.insert(99);
        arrayForRemoving.insert(99);
        arrayForRemoving.insert(44);
        arrayForRemoving.insert(55);
        arrayForRemoving.insert(22);
        arrayForRemoving.insert(88);
        arrayForRemoving.insert(11);
        arrayForRemoving.insert(11);
        arrayForRemoving.insert(11);
        arrayForRemoving.insert(11);
        arrayForRemoving.insert(0);
        arrayForRemoving.insert(66);
        arrayForRemoving.insert(66);
        arrayForRemoving.insert(33);
        arrayForRemoving.insert(33);

        HighArray expectedArray = new HighArray(maxSize);
        expectedArray.insert(77);
        expectedArray.insert(99);
        expectedArray.insert(44);
        expectedArray.insert(55);
        expectedArray.insert(22);
        expectedArray.insert(88);
        expectedArray.insert(11);
        expectedArray.insert(0);
        expectedArray.insert(66);
        expectedArray.insert(33);

        final HighArray actualArray = arrayForRemoving.noDups();

        assertThat(actualArray).isEqualTo(expectedArray);
    }
}