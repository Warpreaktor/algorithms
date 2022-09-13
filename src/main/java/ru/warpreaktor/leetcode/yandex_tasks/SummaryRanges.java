package ru.warpreaktor.leetcode.yandex_tasks;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/summary-ranges
 *
 * You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x
 * is in one of the ranges but not in nums.
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 */
public class SummaryRanges {

    /**
     * Асимптотика - O(n)
     */
    public static ArrayList<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<>();
        if(nums.length == 0) return result;
        if(nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int i = 0;
        int j = 0;
        while(i < nums.length) {
            j++;
            while(j < nums.length && nums[j] - nums[j - 1] == 1) {
                j++;
            }
            if(nums[j-1] - nums[i] >= 1){
                String resStr = nums[i] + "->" + nums[j - 1];
                result.add(resStr);
            } else {
                String resStr = String.valueOf(nums[i]);
                result.add(resStr);
            }
            i = j;
        }
        return result;
    }
}
