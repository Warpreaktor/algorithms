package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.util.Generator;

import java.util.Arrays;

class QuickSortTest {

    @Test
    void emptyArrayQuickSort() {
        int[] arr = new int[]{};
        QuickSort quickSort = new QuickSort();
        Assertions.assertArrayEquals(new int[]{}, quickSort.sort(arr));
        System.out.println(quickSort.totalOperations);
    }

    @Test
    void oneElementQuickSort() {
        int[] arr = new int[]{1};
        QuickSort quickSort = new QuickSort();
        Assertions.assertArrayEquals(new int[]{1}, quickSort.sort(arr));
        System.out.println(quickSort.totalOperations);
    }

    @Test
    void negativeNumbersQuickSort() {
        int[] arr = new int[]{-4, -6, -1, -3, 0, 1, 2, -2};
        QuickSort quickSort = new QuickSort();
        Assertions.assertArrayEquals(new int[]{-6, -4, -3, -2, -1, 0, 1, 2}, quickSort.sort(arr));
        System.out.println(quickSort.totalOperations);
    }

    /**
     * n = 7
     */
    @Test
    void sort3() {
        int[] arr = new int[]{3, 1, 4, 7, 3, 6, 2};
        QuickSort quickSort = new QuickSort();
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 3, 4, 6, 7}, quickSort.sort(arr));
        System.out.println(quickSort.totalOperations);
    }

    @Test
    void sort4() {
        int[] arr = new int[]{5, 5, 5, 5};
        QuickSort quickSort = new QuickSort();
        Assertions.assertArrayEquals(new int[]{5, 5, 5, 5}, quickSort.sort(arr));
        System.out.println(quickSort.totalOperations);
    }

    /**
     * Быстрая сортировка работает быстрей сортировки слиянием несмотря на то,
     * что асимптотика у них одинаковая.
     * n = 60; n log n = 360
     * n = 120; n log n = 840
     */
    @Test
    void sort5() {
        int[] arr = Generator.genIntegerArray(120, true);
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        QuickSort quickSort = new QuickSort();
        Assertions.assertArrayEquals(sortedArr, quickSort.sort(arr));
        System.out.println(quickSort.totalOperations);
    }

    @Test
    void sort6() {
        int[] arr = new int[]{7, 3, 9, 1, 2, 2, 2, -5, 0, 0, 0, 4, 12, -4, 6, 9, 2};
        QuickSort quickSort = new QuickSort();
        Assertions.assertArrayEquals(new int[]{-5, -4, 0, 0, 0, 1, 2, 2, 2, 2, 3, 4, 6, 7, 9, 9, 12},
                quickSort.sort(arr));
        System.out.println(quickSort.totalOperations);
    }

    /**
     * quickSort test на большие входящие данные
     */
    @Test
    void sort7() {
        int[] arr = Generator.genIntegerArray(1000000, true);
        int[] result = Arrays.copyOf(arr, arr.length);

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);

        Arrays.sort(result);

        Assertions.assertArrayEquals(result, arr);
        System.out.println(quickSort.totalOperations);
    }
}