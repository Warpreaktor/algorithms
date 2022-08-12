package ru.warpreaktor.leetcode.utils;

import ru.warpreaktor.leetcode.ListNode;

public final class LeetCodeGenerator {

    public static ListNode generateListNode(int[] ln){
        if (ln.length < 1) return null;

        ListNode head = new ListNode(ln[0]);
        ListNode prevNode = head;
        for (int num : ln) {
            ListNode node = new ListNode(num);
            prevNode.next = node;
            prevNode = node;
        }
        return head;
    }
}
