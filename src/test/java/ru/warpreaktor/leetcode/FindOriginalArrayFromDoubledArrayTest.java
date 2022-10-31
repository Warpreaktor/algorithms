package ru.warpreaktor.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.util.CollectionUtils;
import ru.warpreaktor.util.Generator;

import java.util.Collections;

class FindOriginalArrayFromDoubledArrayTest {

    @Test
    void findOriginalArray() {
        int[] example = new int[]{1, 3, 4, 2, 6, 8};
        Assertions.assertArrayEquals(new int[]{4, 3, 1}, FindOriginalArrayFromDoubledArray.findOriginalArray(example));

        example = new int[]{6, 3, 0, 1};
        Assertions.assertArrayEquals(new int[]{}, FindOriginalArrayFromDoubledArray.findOriginalArray(example));

        example = new int[]{6, 3, 0, 0};
        Assertions.assertArrayEquals(new int[]{3, 0}, FindOriginalArrayFromDoubledArray.findOriginalArray(example));

        example = new int[]{0, 0, 0, 0};
        Assertions.assertArrayEquals(new int[]{0, 0}, FindOriginalArrayFromDoubledArray.findOriginalArray(example));

        example = new int[]{};
        Assertions.assertArrayEquals(new int[]{}, FindOriginalArrayFromDoubledArray.findOriginalArray(example));

        example = new int[]{4, 4, 16, 20, 8, 8, 2, 10};
        Assertions.assertArrayEquals(new int[]{10, 8, 4, 2}, FindOriginalArrayFromDoubledArray.findOriginalArray(example));

        example = new int[100000];
        for (int i = 0; i < 100000; i++) {
            example[i] = i;
        }
        Assertions.assertArrayEquals(new int[]{}, FindOriginalArrayFromDoubledArray.findOriginalArray(example));

        example = new int[200000];
        for (int i = 0; i < 200000 - 1; i++) {
            example[i + 1] = i * 2;
        }
        CollectionUtils.shuffleArray(example);
        Assertions.assertArrayEquals(new int[]{}, FindOriginalArrayFromDoubledArray.findOriginalArray(example));

    }

    @Test
    void findOriginalArray2() {
        int[] example = new int[]{1, 3, 4, 2, 6, 8};
        Assertions.assertArrayEquals(new int[]{1, 3, 4}, FindOriginalArrayFromDoubledArray.findOriginalArray2(example));

        example = new int[]{6, 3, 0, 1};
        Assertions.assertArrayEquals(new int[]{}, FindOriginalArrayFromDoubledArray.findOriginalArray2(example));

        example = new int[]{6, 3, 0, 0};
        Assertions.assertArrayEquals(new int[]{0, 3}, FindOriginalArrayFromDoubledArray.findOriginalArray2(example));

        example = new int[]{0, 0, 0, 0};
        Assertions.assertArrayEquals(new int[]{0, 0}, FindOriginalArrayFromDoubledArray.findOriginalArray2(example));

        example = new int[]{};
        Assertions.assertArrayEquals(new int[]{}, FindOriginalArrayFromDoubledArray.findOriginalArray2(example));

        example = new int[]{4, 4, 16, 20, 8, 8, 2, 10};
        Assertions.assertArrayEquals(new int[]{2, 4, 8, 10}, FindOriginalArrayFromDoubledArray.findOriginalArray2(example));

        example = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            example[i] = 10000000;
        }
        Assertions.assertArrayEquals(new int[]{}, FindOriginalArrayFromDoubledArray.findOriginalArray2(example));

        example = new int[200000];
        for (int i = 0; i < 200000 - 1; i++) {
            example[i + 1] = i * 2;
        }
        CollectionUtils.shuffleArray(example);
        Assertions.assertArrayEquals(new int[]{}, FindOriginalArrayFromDoubledArray.findOriginalArray2(example));

    }

    @Test
    void timeTest2() {
        int iterNum = 100;
        long[] result = new long[iterNum];
        double midTime = 0;
        for (int i = 0; i < iterNum; i++) {
            long start = System.currentTimeMillis();
            findOriginalArray();
            long end = System.currentTimeMillis();
            result[i] = end - start;
        }
        for (int i = 1; i < result.length; i++) {
            midTime += result[i];
        }
        midTime = midTime / iterNum;
        System.out.println(midTime);
    }

    @Test
    void timeTest3() {
        int iterNum = 100;
        long[] result = new long[iterNum];
        double midTime = 0;
        for (int i = 0; i < iterNum; i++) {
            long start = System.currentTimeMillis();
            findOriginalArray2();
            long end = System.currentTimeMillis();
            result[i] = end - start;
        }
        for (int i = 1; i < result.length; i++) {
            midTime += result[i];
        }
        midTime = midTime / iterNum;
        System.out.println(midTime);
    }
}

