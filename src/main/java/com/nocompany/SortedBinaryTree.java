package com.nocompany;


import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.Random;

/**
 * Created by igorfiller on 09.09.17.
 */
public class SortedBinaryTree {
    public Node node;
    private int depth;

    public static class Node {
        private Node leftNode;
        private Node rightNode;
        public Integer value;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public SortedBinaryTree(Integer rootBound) {
        Random random = new Random();
        this.node = new Node(random.nextInt(rootBound));
    }

    public SortedBinaryTree(Node node) {
        this.node = node;
    }

    public void addElement(Node root, Node node) {
        if (node.value <= root.value) {
            if (root.leftNode != null) {
                addElement(root.leftNode, node);
            } else {
                root.leftNode = node;
            }
        } else {
            if (root.rightNode != null) {
                addElement(root.rightNode, node);
            } else {
                root.rightNode = node;
            }
        }
    }

    public void printSortedTreeValues(Node node) {
        if (node != null) {
            printValue(node);
            printSortedTreeValues(node.leftNode);
            printSortedTreeValues(node.rightNode);
        }
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            // compute the depth of each subtree
            int leftDepth = maxDepth(node.leftNode);
            int rightDepth = maxDepth(node.rightNode);
            // use the larger one
            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    private void printValue(Node node) {
        String indent = StringUtils.join(Collections.nCopies(this.depth, "\t"), "");
        System.out.println(indent + node.value);
        this.depth--;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }
}
