package com.kulygin.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighArrayTest {

    @ParameterizedTest
    @MethodSource("provideArraysAndExpectedMax")
    public void shouldReturnMaxValueFromArray(HighArray array, long expectedMax) {
        assertEquals(expectedMax, array.getMax());
    }

    private static Stream<Arguments> provideArraysAndExpectedMax() {
        HighArray array1 = new HighArray(100);
        array1.insert(2);
        array1.insert(8);
        array1.insert(4);
        array1.insert(1);

        HighArray array2 = new HighArray(100);
        array2.insert(0);
        array2.insert(0);
        array2.insert(1);
        array2.insert(0);
        array2.insert(0);

        HighArray array3 = new HighArray(100);
        array3.insert(10);

        HighArray array4 = new HighArray(100);

        return Stream.of(
                Arguments.of(array1, 8),
                Arguments.of(array2, 1),
                Arguments.of(array3, 10),
                Arguments.of(array4, -1));
    }
}