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
    void mergeSort() {
        int[] arr = new int[]{8,10,5,7,2,3,8,2};
        MergeSort mergeSort5 = new MergeSort();
        Assertions.assertArrayEquals(new int[]{2,2,3,5,7,8,8,10},mergeSort5.mergeSort(arr));

        arr = new int[]{956,-1,0,5,-7,3,3,8,2,956};
        MergeSort mergeSort6 = new MergeSort();
        Assertions.assertArrayEquals(new int[]{-7,-1,0,2,3,3,5,8,956,956},mergeSort6.mergeSort(arr));
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
        mergeSort.mergeSortIfNotSorted(arr);
        System.out.println(mergeSort.totalOperations);
    }
}