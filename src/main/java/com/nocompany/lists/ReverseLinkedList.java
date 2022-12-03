package com.nocompany.lists;

import com.nocompany.lists.data.ListNode;

/*
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
*/
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listN1 = new ListNode(1);
        listN1.next = new ListNode(2);
        listN1.next.next = new ListNode(3);
        listN1.next.next.next = new ListNode(4);
        listN1.next.next.next.next = new ListNode(5);

        System.out.println(listN1.toString());

//        ListNode result = reverseList(listN1);
        ListNode result = recursiveReverseList(listN1);
        System.out.println(result.toString());
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode dummy = curr.next;
            curr.next = prev;
            prev = curr;
            curr = dummy;
        }


        return prev;
    }

    public static ListNode recursiveReverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode curr = recursiveReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }
}
