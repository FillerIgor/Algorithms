package com.nocompany.trees;

import com.nocompany.trees.data.TreeNode;

import java.util.LinkedList;

public class SymmetricTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean result = isSymmetric(root);

        System.out.println("Result: " + result);
    }

    public static boolean isSymmetric(TreeNode root) {

        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode leftSub, TreeNode rightSub) {

        if (leftSub == null && rightSub == null) return true;
        if (leftSub == null || rightSub == null) return false;

        return leftSub.val == rightSub.val
                && isMirror(leftSub.left, rightSub.right)
                && isMirror(leftSub.right, rightSub.left);
    }

    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return false;

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode lSub = queue.removeLast();
            TreeNode rSub = queue.removeLast();

            if (lSub == null && rSub == null) continue;
            if (lSub == null || rSub == null) return false;
            if (lSub.val != rSub.val) return false;

            queue.add(lSub.left);
            queue.add(rSub.right);
            queue.add(lSub.right);
            queue.add(rSub.left);
        }

        return true;
    }
}
