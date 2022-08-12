package ru.warpreaktor.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {

    @Test
    void min() {
        Assertions.assertEquals(1, Arrays.min(new int[]{1,2,3}));
        Assertions.assertEquals(0, Arrays.min(new int[]{}));
        Assertions.assertEquals(-7, Arrays.min(new int[]{40, -7, 23, 4, 4, 0, 3}));
    }
}