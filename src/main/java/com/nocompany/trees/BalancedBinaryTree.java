package com.nocompany.trees;

import com.nocompany.trees.data.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(17)));

        boolean result = isBalanced(root);

        System.out.println("Result: " + result);
    }

    public static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }
}
