package ru.warpreaktor.leetcode.yandex_tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SummaryRangesTest {

    @Test
    void summaryRanges() {
        int[] arr = new int[]{};
        ArrayList<String> result = SummaryRanges.summaryRanges(arr);
        String[] assertions = new String[]{};
        Assertions.assertArrayEquals(assertions, result.toArray());

        arr = new int[]{0};
        result = SummaryRanges.summaryRanges(arr);
        assertions = new String[]{"0"};
        Assertions.assertArrayEquals(assertions, result.toArray());

        arr = new int[]{-1};
        result = SummaryRanges.summaryRanges(arr);
        assertions = new String[]{"-1"};
        Assertions.assertArrayEquals(assertions, result.toArray());

        arr = new int[]{0, 1};
        result = SummaryRanges.summaryRanges(arr);
        assertions = new String[]{"0->1"};
        Assertions.assertArrayEquals(assertions, result.toArray());

        arr = new int[]{0, 1, 2};
        result = SummaryRanges.summaryRanges(arr);
        assertions = new String[]{"0->2"};
        Assertions.assertArrayEquals(assertions, result.toArray());

        arr = new int[]{0, 1, 3};
        result = SummaryRanges.summaryRanges(arr);
        assertions = new String[]{"0->1", "3"};
        Assertions.assertArrayEquals(assertions, result.toArray());

        arr = new int[]{0, 1, 2, 4, 5, 7};
        result = SummaryRanges.summaryRanges(arr);
        assertions = new String[]{"0->2", "4->5", "7"};
        Assertions.assertArrayEquals(assertions, result.toArray());

        arr = new int[]{0, 2, 3, 4, 6, 8, 9};
        result = SummaryRanges.summaryRanges(arr);
        assertions = new String[]{"0", "2->4", "6", "8->9"};
        Assertions.assertArrayEquals(assertions, result.toArray());


    }
}