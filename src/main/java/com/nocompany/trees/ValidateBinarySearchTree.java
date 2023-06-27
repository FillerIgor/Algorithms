package com.nocompany.trees;

import com.nocompany.trees.data.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        boolean result = validate(root, null, null);

        System.out.println("Result: " + result);

    }

    public static boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}
