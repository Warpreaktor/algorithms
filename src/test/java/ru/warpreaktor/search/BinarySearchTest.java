package ru.warpreaktor.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.util.Generator;

class BinarySearchTest {

    @Test
    void binarySearch() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int expected = 0; expected < arr.length; expected++) {
            Assertions.assertEquals(expected, BinarySearch.binarySearch(arr, expected + 1));
        }
    }

    @Test
    void binarySearch2() {
        int[] arr = Generator.genIntegerArray(1000, false);
        for (int expected = 0; expected < arr.length; expected++) {
            Assertions.assertEquals(expected, BinarySearch.binarySearch(arr, expected));
        }
    }

    @Test
    void binarySearch3() {
        int[] arr = Generator.genIntegerArray(1000000000, false);
        Assertions.assertEquals(1, BinarySearch.binarySearch(arr, 1));
    }

    @Test
    void binarySearch4() {
        int[] arr = Generator.genIntegerArray(2147483647, false);
        Assertions.assertEquals(1, BinarySearch.binarySearch(arr, 1));
    }

    @Test
    void grockaemBinarySearch1() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int expected = 0; expected < arr.length; expected++) {
            Assertions.assertEquals(expected, BinarySearch.grockaemBinarySearch(arr, expected + 1));
        }
    }

    @Test
    void grockaembinarySearch2() {
        int[] arr = Generator.genIntegerArray(1000, false);
        for (int expected = 0; expected < arr.length; expected++) {
            Assertions.assertEquals(expected, BinarySearch.grockaemBinarySearch(arr, expected));
        }
    }

    @Test
    void grockaembinarySearch3() {
        int[] arr = Generator.genIntegerArray(1000000000, false);
        Assertions.assertEquals(1, BinarySearch.grockaemBinarySearch(arr, 1));
    }

    @Test
    void recursiveBinarySearch1() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int expected = 0; expected < arr.length; expected++) {
            Assertions.assertEquals(expected, BinarySearch.recursiveBinarySearch(
                    arr, 0, arr.length - 1, expected + 1));
        }
    }

    @Test
    void recursiveBinarySearch2() {
        int[] arr = Generator.genIntegerArray(1000, false);
        for (int expected = 0; expected < arr.length; expected++) {
            Assertions.assertEquals(expected, BinarySearch.recursiveBinarySearch(
                    arr, 0, arr.length - 1, expected));
        }
    }

    @Test
    void recursiveBinarySearch3() {
        int[] arr = Generator.genIntegerArray(1000000000, false);
        Assertions.assertEquals(1, BinarySearch.recursiveBinarySearch(
                arr, 0, arr.length - 1, 1));
    }


}