package ru.warpreaktor.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class CollectionUtilsTest {

    @Test
    void min() {
        Assertions.assertEquals(1, CollectionUtils.min(new int[]{1, 2, 3}));
        Assertions.assertEquals(0, CollectionUtils.min(new int[]{}));
        Assertions.assertEquals(-7, CollectionUtils.min(new int[]{40, -7, 23, 4, 4, 0, 3}));
    }

    @Test
    void divideTwo() {
        int[] arr = new int[]{};
        Assertions.assertArrayEquals(new int[]{}, CollectionUtils.splitInHalf(arr).get(0));

        arr = new int[]{5};
        Assertions.assertArrayEquals(new int[]{5}, CollectionUtils.splitInHalf(arr).get(0));

        arr = new int[]{2, 1};
        Assertions.assertArrayEquals(new int[]{2}, CollectionUtils.splitInHalf(arr).get(0));
        Assertions.assertArrayEquals(new int[]{1}, CollectionUtils.splitInHalf(arr).get(1));

        arr = new int[]{2, 3, 1};
        Assertions.assertArrayEquals(new int[]{2}, CollectionUtils.splitInHalf(arr).get(0));
        Assertions.assertArrayEquals(new int[]{3, 1}, CollectionUtils.splitInHalf(arr).get(1));

        arr = new int[]{10, 5, 7, 3, 8, 2};
        Assertions.assertArrayEquals(new int[]{10, 5, 7}, CollectionUtils.splitInHalf(arr).get(0));
        Assertions.assertArrayEquals(new int[]{3, 8, 2}, CollectionUtils.splitInHalf(arr).get(1));

        arr = new int[]{10, 5, 7, 3, 8, 2, 15};
        Assertions.assertArrayEquals(new int[]{10, 5, 7}, CollectionUtils.splitInHalf(arr).get(0));
        Assertions.assertArrayEquals(new int[]{3, 8, 2, 15}, CollectionUtils.splitInHalf(arr).get(1));

    }

    @Test
    void reverse() {
        LinkedList<Integer> list = new LinkedList();
        LinkedList<Integer> assertion = new LinkedList<>();
        list.add(10);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(15);

        assertion.add(15);
        assertion.add(2);
        assertion.add(8);
        assertion.add(3);
        assertion.add(7);
        assertion.add(5);
        assertion.add(10);

        CollectionUtils.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(list.get(i), assertion.get(i));
        }
    }

    @Test
    void swap() {
        int[] arr = new int[]{1,2,3};
        CollectionUtils.swap(arr, 1,2);
        Assertions.assertArrayEquals(new int[]{1,3,2}, arr);
        CollectionUtils.swap(arr, 0,1);
        Assertions.assertArrayEquals(new int[]{3,1,2}, arr);
        CollectionUtils.swap(arr, 0,2);
        Assertions.assertArrayEquals(new int[]{2,1,3}, arr);
    }
}
