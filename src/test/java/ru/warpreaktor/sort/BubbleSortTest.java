package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

    // Наихудший случай
    @Test
    void sort1() {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] result = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertArrayEquals(result, BubbleSort.sort(arr));
    }

    //Наилучший случай
    @Test
    void sort2() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertArrayEquals(result, BubbleSort.sort(arr));
    }

    @Test
    void sort3() {
        int[] arr = new int[]{4, 5, 8, 2, 5, 9, 0, 1, 3, 3, 2, 8, 7, 4, 56};
        int[] result = new int[]{0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 7, 8, 8, 9, 56};
        Assertions.assertArrayEquals(result, BubbleSort.sort(arr));
    }

    @Test
    void sort4() {
        int[] arr = new int[]{'r', 'f', 't', 'b', 'h', 'j', 'a'};
        int[] result = new int[]{'a', 'b', 'f', 'h', 'j', 'r', 't'};
        Assertions.assertArrayEquals(result, BubbleSort.sort(arr));
    }
}