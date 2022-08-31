package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class QuickSortTest {

    @Test
    void sort() {
        int[] arr = new int[]{};
//        Assertions.assertArrayEquals(new int[]{}, QuickSort.sort(arr));
//        arr = new int[]{1};
//        Assertions.assertArrayEquals(new int[]{1}, QuickSort.sort(arr));
//        arr = new int[]{1, 6, -1};
//        Assertions.assertArrayEquals(new int[]{-1, 1, 6}, QuickSort.sort(arr));
//        arr = new int[]{2,8,5,1,0,3};
//        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 5, 8}, QuickSort.sort(arr));
        arr = new int[]{5,5,5,5};
        Assertions.assertArrayEquals(new int[]{5, 5, 5, 5}, QuickSort.sort(arr));

//      arr = new int[]{4,4,5,1,2,4,4};
    }

    @Test
    void sort2() {
        int[] arr = new int[]{};
//        Assertions.assertArrayEquals(new int[]{}, QuickSort.sort2(arr));
//        arr = new int[]{1};
//        Assertions.assertArrayEquals(new int[]{1}, QuickSort.sort2(arr));
//        arr = new int[]{1, 6, -1};
//        Assertions.assertArrayEquals(new int[]{-1, 1, 6}, QuickSort.sort2(arr));
        arr = new int[]{2,8,5,1,0,3};
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 5, 8}, QuickSort.sort2(arr));
        arr = new int[]{5,5,5,5};
        Assertions.assertArrayEquals(new int[]{5, 5, 5, 5}, QuickSort.sort2(arr));
        arr = new int[]{4,4,5,1,2,4,4};
        Assertions.assertArrayEquals(new int[]{1, 2, 4, 4, 4, 4, 5}, QuickSort.sort2(arr));
    }
}