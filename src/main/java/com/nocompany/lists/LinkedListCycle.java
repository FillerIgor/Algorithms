package com.nocompany.lists;

import com.nocompany.lists.data.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
Input: head = [3,2,0,-4], pos = 1
[3,2,0,-4,2]
Output: true
*/
public class LinkedListCycle {

    public static void main(String[] args) {

        ListNode listN1 = new ListNode(3);
        listN1.next = new ListNode(2);
        listN1.next.next = new ListNode(0);
        listN1.next.next.next = new ListNode(-4);
        //todo important input
        //link a node and create fictional cycle
        listN1.next.next.next.next = listN1.next;

//        boolean result = hasCycleHashSet(listN1);
        boolean result = hasCycleFloydsCycleFindingAlgorithm(listN1);

        System.out.println("Result: " + result);

    }

    public static boolean hasCycleHashSet(ListNode head) {
        Set<ListNode> uniqueValues = new HashSet<>();
        while (head != null) {
            if (!uniqueValues.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycleFloydsCycleFindingAlgorithm(ListNode head) {

        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next==null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
