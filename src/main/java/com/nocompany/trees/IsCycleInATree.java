package com.nocompany.trees;

import java.util.*;

public class IsCycleInATree {
    public static void main(String[] args) {
        List<String> input = List.of(
                "1",
                "1",
                "3",
                "1",
                "2",
                "3"
        );

        Iterator<String> iterator = input.iterator();
        Node root = new Node(Integer.valueOf(iterator.next()), null);
        Node temp = root;
        while (iterator.hasNext()) {
            temp.next = new Node(Integer.valueOf(iterator.next()), null);
            temp = temp.next;
        }
        boolean result = isCycle(root);
        String resultStr = result ? "1" : "0";
        System.out.println(resultStr);
    }

    static boolean isCycle(Node input) {
        Set<Node> dictionary = new HashSet<Node>();
        while (input != null) {
            if (!dictionary.add(input.next)) {
                return true;
            }
            input = input.next;
        }
        return false;
    }

    static class Node {
        public int val;
        public Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node listNode = (Node) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
