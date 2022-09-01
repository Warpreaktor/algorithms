package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.util.Generator;

import java.util.Arrays;

class QuickSortTest {

    @Test
    void sort() {
        int[] arr = new int[]{};
        Assertions.assertArrayEquals(new int[]{}, QuickSort.sort(arr));
        arr = new int[]{1};
        Assertions.assertArrayEquals(new int[]{1}, QuickSort.sort(arr));
        arr = new int[]{1, 6, -1};
        Assertions.assertArrayEquals(new int[]{-1, 1, 6}, QuickSort.sort(arr));
        arr = new int[]{2,8,5,1,0,3};
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 5, 8}, QuickSort.sort(arr));
        arr = new int[]{5,5,5,5};
        Assertions.assertArrayEquals(new int[]{5, 5, 5, 5}, QuickSort.sort(arr));
        arr = new int[]{4, 4, 5, 1, 2, 4, 4};
        Assertions.assertArrayEquals(new int[]{1,2,4,4,4,4,5}, QuickSort.sort(arr));
        arr = new int[]{7, 3, 9, 1, 2, 2, 2, -5, 0, 0, 0, 4, 12, -4, 6, 9, 2};
        Assertions.assertArrayEquals(new int[]{-5, -4, 0, 0, 0, 1, 2, 2, 2, 2, 3, 4, 6, 7, 9, 9, 12}, QuickSort.sort(arr));
        arr = new int[]{6, 4, 9, 6, 0, 5, 7, 8, 6, 0};
        Assertions.assertArrayEquals(new int[]{0, 0, 4, 5, 6, 6, 6, 7, 8, 9}, QuickSort.sort(arr));

        //Тест на рандомные массивы. Эталоном для проверки будет встроенная джава сортировка.
        for (int i = 0; i < 3; i++) {
            arr = Generator.genIntegerArray(10000, true);
            int[] result = Arrays.copyOf(arr, arr.length);
            Arrays.sort(result);
            QuickSort.sort(arr);
            Assertions.assertArrayEquals(result, arr);
        }

    }
}