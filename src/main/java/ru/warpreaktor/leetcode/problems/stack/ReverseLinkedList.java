package ru.warpreaktor.leetcode.problems.stack;

import ru.warpreaktor.leetcode.ListNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
 * Memory Usage: 42.4 MB, less than 80.84% of Java online submissions for Reverse Linked List.
 * Алгоритм - Нам потребуется два указателя и пузырек для хранения информации о следующем элементе в оригинальном списке.
 * Пройдем по всем элементам оригинального листа изменяя у них поле next на объект который был до него.
 * Асимптотика - O(n)
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode cursor = null;
        ListNode nextNode = head;

        while(nextNode != null){
            ListNode bubble = nextNode.next;
            nextNode.next = cursor;
            cursor = nextNode;
            nextNode = bubble;
        }
        return cursor;
    }
}
