package com.nocompany.lists;

import com.nocompany.lists.data.ListNode;

/*
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
*/
public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode listN1 = new ListNode(1);
        listN1.next = new ListNode(3);
        listN1.next.next = new ListNode(4);

        ListNode listN2 = new ListNode(1);
        listN2.next = new ListNode(2);
        listN2.next.next = new ListNode(4);

        //ListNode result = mergeTwoSortedListsWithAdditionalResultCollection(listN1, listN2);
//        ListNode result = mergeTwoSortedLists(listN1, listN2);
        ListNode result = mergeTwoListsIterativeApproach(listN1, listN2);

        System.out.println(result.toString());

    }

    public static ListNode mergeTwoSortedListsWithAdditionalResultCollection(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode result;
        if (list1.val < list2.val) {
            result = list1;
            list1 = list1.next;
        } else {
            result = list2;
            list2 = list2.next;
        }

        result.next = mergeTwoSortedListsWithAdditionalResultCollection(list1, list2);
        return result;
    }

    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {

        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        if(list1.val<list2.val){
            list1.next = mergeTwoSortedLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoSortedLists(list1, list2.next);
            return list2;
        }

    }

    public static ListNode mergeTwoListsIterativeApproach(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode result = new ListNode(-1);
        ListNode tail = result;

        while (list1 != null && list2 != null){
            if(list1.val<list2.val){
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        tail.next = list1 != null ? list1 : list2;

        return result.next;
    }
}
