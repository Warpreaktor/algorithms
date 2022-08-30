package ru.warpreaktor.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxConsecutiveElementsTest {

    @Test
    void maxConsecutiveElements() {
        String str = "аабвгддд";
        Assertions.assertEquals(3, MaxConsecutiveElements.maxConsecutiveElements(str));

        str = "аffffабвгддд";
        Assertions.assertEquals(4, MaxConsecutiveElements.maxConsecutiveElements(str));

        str = "а;'ljlklflабв4дуд";
        Assertions.assertEquals(1, MaxConsecutiveElements.maxConsecutiveElements(str));
    }

    @Test
    void testMaxConsecutiveElements() {
        int[] arr = new int[]{};
        Assertions.assertEquals(0, MaxConsecutiveElements.maxConsecutiveElements(arr));
        arr = new int[]{1};
        Assertions.assertEquals(1, MaxConsecutiveElements.maxConsecutiveElements(arr));
        arr = new int[]{2,2};
        Assertions.assertEquals(2, MaxConsecutiveElements.maxConsecutiveElements(arr));
        arr = new int[]{1,2,3};
        Assertions.assertEquals(1, MaxConsecutiveElements.maxConsecutiveElements(arr));
        arr = new int[]{2,2,3,4,5,5,5,2,2};
        Assertions.assertEquals(3, MaxConsecutiveElements.maxConsecutiveElements(arr));
        arr = new int[]{4,4,4,4};
        Assertions.assertEquals(4, MaxConsecutiveElements.maxConsecutiveElements(arr));
        arr = new int[]{0,0,4,1,-4,4,4,0};
        Assertions.assertEquals(2, MaxConsecutiveElements.maxConsecutiveElements(arr));
    }
}