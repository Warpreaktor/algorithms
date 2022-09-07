package ru.warpreaktor.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeletingDuplicatesTest {

    @Test
    void deletingDuplicates() {
        int[] arr = new int[]{1,2,2,3,4,4,5};
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5}, DeletingDuplicates.deletingDuplicates(arr));

        arr = new int[]{1,2,2,2,2,2,2};
        Assertions.assertArrayEquals(new int[]{1,2}, DeletingDuplicates.deletingDuplicates(arr));

        arr = new int[]{1,1,1,1};
        Assertions.assertArrayEquals(new int[]{1}, DeletingDuplicates.deletingDuplicates(arr));
    }

    @Test
    void deletingDuplicates2() {
        int[] arr = new int[]{1,2,2,3,4,4,5};
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5}, DeletingDuplicates.deletingDuplicates2(arr));

        arr = new int[]{1,2,2,2,2,2,2};
        Assertions.assertArrayEquals(new int[]{1,2}, DeletingDuplicates.deletingDuplicates2(arr));

        arr = new int[]{1,1,1,1};
        Assertions.assertArrayEquals(new int[]{1}, DeletingDuplicates.deletingDuplicates2(arr));

        arr = new int[]{0,0,0};
        Assertions.assertArrayEquals(new int[]{0}, DeletingDuplicates.deletingDuplicates2(arr));
    }
}