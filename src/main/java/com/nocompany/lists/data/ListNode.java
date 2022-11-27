package com.nocompany.lists.data;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringValue = new StringBuilder(String.valueOf(val));
        ListNode tempNext = next;
        while (tempNext != null) {
            stringValue.append(" ").append(tempNext.val);
            tempNext = tempNext.next;
        }
        return stringValue.toString();
    }

}
