package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.util.profiler.profiler.Profiling;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sortInteger() {
        int[] arr = new int[]{};
        Assertions.assertArrayEquals(new int[]{}, InsertionSort.sortInteger(arr));

        arr = new int[]{3,2,5,1};
        Assertions.assertArrayEquals(new int[]{1,2,3,5}, InsertionSort.sortInteger(arr));

        arr = new int[]{3,42,-3,5,1,0};
        Assertions.assertArrayEquals(new int[]{-3,0,1,3,5,42}, InsertionSort.sortInteger(arr));

    }
}