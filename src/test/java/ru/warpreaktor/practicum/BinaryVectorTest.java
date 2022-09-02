package ru.warpreaktor.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryVectorTest {

    @Test
    void findSequenceOfOne() {
        int[] arr = new int[]{0,1,0,0,1,0,1,1,1,0,1};
        Assertions.assertEquals(3, BinaryVector.findSequenceOfNumber(arr));

        arr = new int[]{0,1,1,1};
        Assertions.assertEquals(3, BinaryVector.findSequenceOfNumber(arr));

        arr = new int[]{0,1,0,1};
        Assertions.assertEquals(1, BinaryVector.findSequenceOfNumber(arr));

        arr = new int[]{0,0,0,0};
        Assertions.assertEquals(0, BinaryVector.findSequenceOfNumber(arr));

        arr = new int[]{1,1,1,1};
        Assertions.assertEquals(4, BinaryVector.findSequenceOfNumber(arr));
    }

    @Test
    void findSequenceOfNumber() {
        int[] arr = new int[]{0,1,0,0,1,0,1,1,1,0,1};
        Assertions.assertEquals(3, BinaryVector.findSequenceOfNumber2(arr));

        arr = new int[]{0,1,1,1};
        Assertions.assertEquals(3, BinaryVector.findSequenceOfNumber2(arr));

        arr = new int[]{0,1,0,1};
        Assertions.assertEquals(1, BinaryVector.findSequenceOfNumber2(arr));

        arr = new int[]{0,0,0,0};
        Assertions.assertEquals(0, BinaryVector.findSequenceOfNumber2(arr));

        arr = new int[]{1,1,1,1};
        Assertions.assertEquals(4, BinaryVector.findSequenceOfNumber2(arr));
    }

    @Test
    void maxSequence() {
        int[] arr = new int[]{0,1,0,0,1,0,1,1,1,0,1};
        Assertions.assertEquals(3, BinaryVector.maxSequence(arr));

        arr = new int[]{0,1,1,1};
        Assertions.assertEquals(3, BinaryVector.maxSequence(arr));

        arr = new int[]{0,1,0,1};
        Assertions.assertEquals(1, BinaryVector.maxSequence(arr));

        arr = new int[]{0,0,0,0};
        Assertions.assertEquals(4, BinaryVector.maxSequence(arr));

        arr = new int[]{1,1,1,1};
        Assertions.assertEquals(4, BinaryVector.maxSequence(arr));
    }
}