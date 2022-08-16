package ru.warpreaktor.leetcode.problems.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.leetcode.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void reverseList() {
        ListNode ln1;
        ListNode ln2;
        ListNode ln3;
        ListNode ln4;
        ListNode ln5;
        ListNode result;

        ln3 = new ListNode(3, null);
        ln2 = new ListNode(2, ln3);
        ln1 = new ListNode(1, ln2);
        result = ReverseLinkedList.reverseList(ln1);
        for (int i = 3; i >= 1; i--) {
            Assertions.assertEquals(i, result.val);
            result = result.next;
        }

        ln2 = new ListNode(2, null);
        ln1 = new ListNode(1, ln2);
        result = ReverseLinkedList.reverseList(ln1);
        for (int i = 2; i >= 1; i--) {
            Assertions.assertEquals(i, result.val);
            result = result.next;
        }

        ln5 = new ListNode(5, null);
        ln4 = new ListNode(4, ln5);
        ln3 = new ListNode(3, ln4);
        ln2 = new ListNode(2, ln3);
        ln1 = new ListNode(1, ln2);
        result = ReverseLinkedList.reverseList(ln1);
        for (int i = 5; i >= 1; i--) {
            Assertions.assertEquals(i, result.val);
            result = result.next;
        }

    }
}