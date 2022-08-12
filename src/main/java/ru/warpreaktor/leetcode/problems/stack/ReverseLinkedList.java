package ru.warpreaktor.leetcode.problems.stack;

import ru.warpreaktor.leetcode.ListNode;

import java.util.Iterator;
import java.util.LinkedList;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        // Если в списке всего один элемент то вернем его немедленно
        if(head == null || head.next == null)return head;

        // Первый указатель итерируется по данному списку
        // Необходимо сохранять состояние
        ListNode cursor = head;
        ListNode previousNode = null;
        LinkedList<ListNode> result = new LinkedList<>();

        //Итерируемся по оригинальному списку
        //У каждого элемента результирующего списка .next будет равно предыдущему значению оригинального списка
        while(cursor != null){
            result.addFirst(cursor);
            previousNode = cursor;
            cursor = cursor.next;
            previousNode.next = null;
        }
        Iterator iterator = result.iterator();
        ListNode ln = (ListNode)iterator.next();
        while (iterator.hasNext()) {
            ln.next = (ListNode)iterator.next();
            ln = ln.next;
        }
        return result.get(0);
    }
}
