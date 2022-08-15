package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.warpreaktor.util.Generator;

import java.util.Arrays;

class InsertionSortTest {

    //Общий массив для проведения теста на производительность.
    int[] arr = Generator.genIntegerArray(100000, true);

    @Test
    void insertionSort() {
        int[] arr = new int[]{};
        Assertions.assertArrayEquals(new int[]{}, InsertionSort.sortInteger(arr));

        arr = new int[]{3,2,5,1};
        Assertions.assertArrayEquals(new int[]{1,2,3,5}, InsertionSort.sortInteger(arr));

        arr = new int[]{3,42,-3,5,1,0};
        Assertions.assertArrayEquals(new int[]{-3,0,1,3,5,42}, InsertionSort.sortInteger(arr));

        arr = new int[]{-1,0,5,-7,3,8,2,956};
        Assertions.assertArrayEquals(new int[]{-7,-1,0,2,3,5,8,956},InsertionSort.sortInteger(arr));

    }

    @Disabled
    @Test
    void InsertionSortBigData() {
        int[] arra = Arrays.copyOf(arr, arr.length);
        InsertionSort.sortInteger(arra);
    }

    @Test
    void bubbleSortMin() {
        int[] arr = new int[]{};
        Assertions.assertArrayEquals(new int[]{}, BubbleSort.sortInteger(arr));

        arr = new int[]{3,2,5,1};
        Assertions.assertArrayEquals(new int[]{1,2,3,5}, BubbleSort.sortInteger(arr));

        arr = new int[]{10,5,7,3,8,2};
        Assertions.assertArrayEquals(new int[]{2,3,5,7,8,10},BubbleSort.sortInteger(arr));

        arr = new int[]{-1,0,5,-7,3,8,2,956};
        Assertions.assertArrayEquals(new int[]{-7,-1,0,2,3,5,8,956},BubbleSort.sortInteger(arr));
    }

    @Disabled
    @Test
    void BubbleSortBigData() {
        int[] arra = Arrays.copyOf(arr, arr.length);
        BubbleSort.sortInteger(arra);

    }
}