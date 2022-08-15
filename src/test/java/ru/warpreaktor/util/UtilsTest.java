package ru.warpreaktor.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void swap() {
        int[] arr = new int[]{1,2,3};
        Assertions.assertArrayEquals(new int[]{1,3,2}, Utils.swap(arr, 1,2));
        Assertions.assertArrayEquals(new int[]{3,1,2}, Utils.swap(arr, 0,1));
        Assertions.assertArrayEquals(new int[]{2,1,3}, Utils.swap(arr, 0,2));
    }
}