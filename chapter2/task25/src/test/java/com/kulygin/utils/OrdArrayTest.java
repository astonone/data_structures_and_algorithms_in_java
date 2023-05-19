package com.kulygin.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrdArrayTest {

    @ParameterizedTest
    @MethodSource("provideArrays")
    public void shouldMergeArrays(OrdArray array1, OrdArray array2, OrdArray expectedArray) {
        assertEquals(expectedArray, array1.merge(array2, 200));
    }

    private static Stream<Arguments> provideArrays() {
        OrdArray array1 = new OrdArray(100);
        array1.insert(2);
        array1.insert(8);
        array1.insert(4);

        OrdArray array2 = new OrdArray(100);
        array2.insert(0);
        array2.insert(0);
        array2.insert(1);

        OrdArray expectedArrayFromArr1and2 = new OrdArray(200);
        expectedArrayFromArr1and2.insert(0);
        expectedArrayFromArr1and2.insert(0);
        expectedArrayFromArr1and2.insert(1);
        expectedArrayFromArr1and2.insert(2);
        expectedArrayFromArr1and2.insert(4);
        expectedArrayFromArr1and2.insert(8);

        OrdArray array3 = new OrdArray(100);
        array3.insert(2);
        array3.insert(8);

        OrdArray array4 = new OrdArray(100);
        array4.insert(0);
        array4.insert(0);
        array4.insert(1);

        OrdArray expectedArrayFromArr3and4 = new OrdArray(200);
        expectedArrayFromArr3and4.insert(0);
        expectedArrayFromArr3and4.insert(0);
        expectedArrayFromArr3and4.insert(1);
        expectedArrayFromArr3and4.insert(2);
        expectedArrayFromArr3and4.insert(8);

        OrdArray array5 = new OrdArray(100);
        array5.insert(2);
        array5.insert(8);
        array5.insert(4);

        OrdArray array6 = new OrdArray(100);
        array6.insert(1);

        OrdArray expectedArrayFromArr5and6 = new OrdArray(200);
        expectedArrayFromArr5and6.insert(1);
        expectedArrayFromArr5and6.insert(2);
        expectedArrayFromArr5and6.insert(4);
        expectedArrayFromArr5and6.insert(8);

        OrdArray array7 = new OrdArray(100);
        array7.insert(2);
        array7.insert(8);
        array7.insert(4);

        OrdArray array8 = new OrdArray(100);

        OrdArray expectedArrayFromArr7and8 = new OrdArray(200);
        expectedArrayFromArr7and8.insert(2);
        expectedArrayFromArr7and8.insert(4);
        expectedArrayFromArr7and8.insert(8);

        OrdArray array9 = new OrdArray(100);

        OrdArray array10 = new OrdArray(100);
        array10.insert(2);
        array10.insert(8);
        array10.insert(4);

        OrdArray expectedArrayFromArr9and10 = new OrdArray(200);
        expectedArrayFromArr9and10.insert(2);
        expectedArrayFromArr9and10.insert(4);
        expectedArrayFromArr9and10.insert(8);

        OrdArray array11 = new OrdArray(100);

        OrdArray array12 = new OrdArray(100);

        OrdArray expectedArrayFromArr11and12 = new OrdArray(200);

        return Stream.of(
                Arguments.of(array1, array2, expectedArrayFromArr1and2),
                Arguments.of(array3, array4, expectedArrayFromArr3and4),
                Arguments.of(array5, array6, expectedArrayFromArr5and6),
                Arguments.of(array7, array8, expectedArrayFromArr7and8),
                Arguments.of(array9, array10, expectedArrayFromArr9and10),
                Arguments.of(array11, array12, expectedArrayFromArr11and12));
    }

    @Test
    public void shouldMergeArrays_arraysNotEmptyAndHaveEqualSize() {
        OrdArray array1 = new OrdArray(100);
        array1.insert(22);
        array1.insert(11);
        array1.insert(55);

        OrdArray array2 = new OrdArray(100);
        array2.insert(44);
        array2.insert(11);
        array2.insert(55);
    }

}