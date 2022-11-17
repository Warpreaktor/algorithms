package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.util.Generator;

import java.util.Arrays;

class MergeSortTest {

    @Test
    void mergeSort1() {
        int[] arr = new int[]{};
        MergeSort mergeSort = new MergeSort();
        Assertions.assertArrayEquals(new int[]{}, mergeSort.mergeSort(arr));
        System.out.println(mergeSort.totalOperations);
    }

    @Test
    void mergeSort2() {
        int[] arr = new int[]{2,1};
        MergeSort mergeSort = new MergeSort();
        Assertions.assertArrayEquals(new int[]{1,2}, mergeSort.mergeSort(arr));
        System.out.println(mergeSort.totalOperations);
    }

    @Test
    void negativeNumbersMergeSort() {
        int[] arr = new int[]{956,-1,0,5,-7,3,3,8,2,956};
        MergeSort mergeSort6 = new MergeSort();
        Assertions.assertArrayEquals(new int[]{-7,-1,0,2,3,3,5,8,956,956},mergeSort6.mergeSort(arr));
    }

    /**
     * n = 60; n log n = 360
     * n = 120; n log n = 840
     */
    @Test
    void sort5() {
        int[] arr = Generator.genIntegerArray(120, true);
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        MergeSort mergeSort = new MergeSort();

        Assertions.assertArrayEquals(sortedArr, mergeSort.mergeSort(arr));
        System.out.println(mergeSort.totalOperations);
    }

    @Test
    void mergeSortBigData() {
        int[] randArr = Generator.genIntegerArray(10000, true);

        int[] arr = Arrays.copyOf(randArr, randArr.length);
        Arrays.sort(arr);

        MergeSort mergeSort = new MergeSort();
        Assertions.assertArrayEquals(arr, mergeSort.mergeSort(arr));
        System.out.println(mergeSort.totalOperations);
    }

    @Test
    void mergeSortIfAlreadySorted1() {
        int[] arr = new int[]{2,3,5,7,8,10};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        System.out.println(mergeSort.totalOperations);
    }

    @Test
    void mergeSortIfAlreadySorted2() {
        int[] arr = new int[]{2,3,5,7,8,10};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSortOnlyNotSorted(arr);
        System.out.println(mergeSort.totalOperations);
    }
}