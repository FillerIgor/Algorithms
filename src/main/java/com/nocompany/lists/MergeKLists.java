package com.nocompany.lists;

import com.nocompany.lists.data.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;


/*
Your input
[[1,4,5],[1,3,4],[2,6]]
Output
[1,1,2,3,4,4,5,6]
Expected
[1,1,2,3,4,4,5,6]
* */
public class MergeKLists {

    public static void main(String[] args) {

        ListNode listN3 = new ListNode(1);
        listN3.next = new ListNode(4);
        listN3.next.next = new ListNode(5);

        ListNode listN2 = new ListNode(1);
        listN2.next = new ListNode(3);
        listN2.next.next = new ListNode(4);

        ListNode listN1 = new ListNode(2);
        listN1.next = new ListNode(6);
        ListNode[] listNodes = {listN1, listN2, listN3};

        ListNode result = mergeKLists(listNodes);

        System.out.println(result.toString());
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            tail.next = poll;
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}


