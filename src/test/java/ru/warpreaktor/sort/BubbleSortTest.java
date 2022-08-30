package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        char[] arr = new char[]{'r', 'f', 't', 'b', 'h', 'j', 'a'};
        char[] result = new char[]{'a', 'b', 'f', 'h', 'j', 'r', 't'};
        Assertions.assertArrayEquals(result, BubbleSort.sort(arr));
    }
}