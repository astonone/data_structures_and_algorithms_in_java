package com.kulygin.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HighArrayTest {

    @Test
    public void shouldRemoveMax() {
        HighArray actualArray = new HighArray(100);
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

        assertThat(actualArray.find(99)).isTrue();

        final long max = actualArray.removeMax();

        assertThat(max).isEqualTo(99);
        assertThat(actualArray.find(99)).isFalse();
    }

    @Test
    public void shouldRemoveMax_emptyArray() {
        HighArray actualArray = new HighArray(100);

        assertThat(actualArray.find(120)).isFalse();

        final long max = actualArray.removeMax();

        assertThat(max).isEqualTo(-1);
    }
}