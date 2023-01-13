package com.nocompany.trees;

import com.nocompany.trees.data.TreeNode;

import java.util.LinkedList;

//p = [1,2,3], q = [1,2,3]
public class SameTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        TreeNode p = new TreeNode(1, new TreeNode(2), null);
//        TreeNode q = new TreeNode(1, null, new TreeNode(2));

        boolean result = isSameTreeIteration(p, q);

        System.out.println("Result: " + result);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameTreeIteration(TreeNode p, TreeNode q) {

        LinkedList<TreeNode> pList = new LinkedList<>();
        LinkedList<TreeNode> qList = new LinkedList<>();

        pList.add(p);
        qList.add(q);

        while (!pList.isEmpty()) {
            TreeNode pLast = pList.removeLast();
            TreeNode qLast = qList.removeLast();
            if (!isSame(pLast, qLast)) return false;

            if (pLast!=null) {
                if (!isSame(pLast.left, qLast.left)) {
                    return false;
                }
                if (pLast.left!=null){
                    pList.addLast(pLast.left);
                    qList.addLast(qLast.left);
                }

                if (!isSame(pLast.right, qLast.right)) {
                    return false;
                }
                if (pLast.right!=null) {
                    pList.addLast(pLast.right);
                    qList.addLast(qLast.right);
                }
            }
        }

        return true;
    }

    public static boolean isSame(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }
}
