package ru.warpreaktor.leetcode;

import ru.warpreaktor.leetcode.problems.stack.ValidParentheses;
import ru.warpreaktor.leetcode.utils.LeetCodeGenerator;

import java.math.BigDecimal;

public class LeetcodeSolutions {

    public static void main(String[] args) {
        ValidParentheses.test();
    }

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * Accepted
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) continue;
            for (int j = i + 1; j <= nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal number1 = new BigDecimal(listNodeReader(l1));
        BigDecimal number2 = new BigDecimal(listNodeReader(l2));
        String result = String.valueOf(number1.add(number2));

        ListNode resultedListNode = new ListNode(Integer.valueOf(String.valueOf(result.charAt(result.length() - 1))), new ListNode());
        ListNode curNode = resultedListNode;

        for (int i = result.length() - 1; i >= 0; i--) {
            ListNode nextNode = i - 1 >= 0 ? new ListNode(Integer.valueOf(String.valueOf(result.charAt(i - 1)))) : null;
            curNode.next = nextNode;
            curNode = nextNode;
        }
        return resultedListNode;
    }

    private String listNodeReader(ListNode lN) {
        StringBuilder stringNumber = new StringBuilder();

        ListNode curValue = lN;
        while (curValue != null) {
            stringNumber.append(curValue.val);
            curValue = curValue.next;
        }
        return stringNumber.reverse().toString();
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        //Инициализируем head нашей цепочки найдя первый уникальный эемент в списке.
        ListNode nonDuplicateList = returnDistinct(head);
        if (nonDuplicateList == null) return null;

        ListNode distinctNode = nonDuplicateList;

        //Курсор на входящей цепочке
        ListNode nextNode = distinctNode.next;

        //Идём по цепочке пока следующий в цепочке элемент не будет равен null
        while (nextNode != null) {
            distinctNode.next = returnDistinct(distinctNode.next);
            //Двигаем курсор в нашей цепи
            distinctNode = distinctNode.next;
            //Передвигаем курсор по цепоке
            nextNode = distinctNode;
        }

        return nonDuplicateList;
    }

    //Возвращает ноду 1 если она не равна ноде 2
    private ListNode returnDistinct(ListNode n1) {
        if (n1 == null) return null;
        if (n1.next == null) return n1;

        if (n1.val != n1.next.val) {
            return n1;
        } else {
            ListNode ln = returnNextNotDuplicate(n1.next);
            return returnDistinct(ln);
        }
    }

    private ListNode returnNextNotDuplicate(ListNode duplicate) {
        if (duplicate == null || duplicate.next == null) return null;

        ListNode notDuplicate = duplicate.next;
        if (duplicate.val == notDuplicate.val) {
            notDuplicate = returnNextNotDuplicate(notDuplicate);
        }
        return notDuplicate;
    }

    private void addTwoNumbersTest() {
        ListNode ln1 = LeetCodeGenerator.generateListNode(new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
        ListNode ln2 = LeetCodeGenerator.generateListNode(new int[]{6,6,4});

        ListNode result = addTwoNumbers(ln1, ln2);
        while (result != null){
            System.out.print(result);
            result = result.next;
        }
    }

    private void testListNode2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
//        ListNode l8 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
//        l7.next = l8;

        ListNode result = deleteDuplicates(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
