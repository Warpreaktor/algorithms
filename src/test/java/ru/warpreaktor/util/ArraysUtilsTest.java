package ru.warpreaktor.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.sort.BubbleSort;
import ru.warpreaktor.sort.MergeSort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraysUtilsTest {

    @Test
    void min() {
        Assertions.assertEquals(1, ArraysUtils.min(new int[]{1,2,3}));
        Assertions.assertEquals(0, ArraysUtils.min(new int[]{}));
        Assertions.assertEquals(-7, ArraysUtils.min(new int[]{40, -7, 23, 4, 4, 0, 3}));
    }

    @Test
    void divideTwo() {
        int[] arr = new int[]{};
        Assertions.assertArrayEquals(new int[]{}, ArraysUtils.divideTwo(arr).get(0));

        arr = new int[]{5};
        Assertions.assertArrayEquals(new int[]{5}, ArraysUtils.divideTwo(arr).get(0));

        arr = new int[]{2,1};
        Assertions.assertArrayEquals(new int[]{2}, ArraysUtils.divideTwo(arr).get(0));
        Assertions.assertArrayEquals(new int[]{1}, ArraysUtils.divideTwo(arr).get(1));

        arr = new int[]{2,3,1};
        Assertions.assertArrayEquals(new int[]{2}, ArraysUtils.divideTwo(arr).get(0));
        Assertions.assertArrayEquals(new int[]{3,1}, ArraysUtils.divideTwo(arr).get(1));

        arr = new int[]{10,5,7,3,8,2};
        Assertions.assertArrayEquals(new int[]{10,5,7}, ArraysUtils.divideTwo(arr).get(0));
        Assertions.assertArrayEquals(new int[]{3,8,2}, ArraysUtils.divideTwo(arr).get(1));

        arr = new int[]{10,5,7,3,8,2,15};
        Assertions.assertArrayEquals(new int[]{10,5,7}, ArraysUtils.divideTwo(arr).get(0));
        Assertions.assertArrayEquals(new int[]{3,8,2,15}, ArraysUtils.divideTwo(arr).get(1));

    }
}