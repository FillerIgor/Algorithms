package com.nocompany.lists;

import com.nocompany.lists.data.ListNode;

/*
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listN1 = new ListNode(2);
        listN1.next = new ListNode(4);
        listN1.next.next = new ListNode(3);

        ListNode listN2 = new ListNode(5);
        listN2.next = new ListNode(6);
        listN2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(listN1, listN2);

        System.out.println(result.toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tail = result;
        int extra = 0;

        while (l1 != null || l2 != null || extra != 0) {
            ListNode currentL1 = l1 == null ? new ListNode(0) : l1;
            ListNode currentL2 = l2 == null ? new ListNode(0) : l2;

            int sum = currentL1.val + currentL2.val + extra;
            extra = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            l1 = currentL1.next;
            l2 = currentL2.next;
        }

        return result.next;
    }
}
