package com.company;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

public class SolOfisSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        TreeNode left;
        TreeNode right;
        treeNodes.offer(root.left);
        treeNodes.offer(root.right);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while (size-- > 0) {
                left = treeNodes.poll();
                right = treeNodes.poll();
                if (left == null && right == null) {
                    continue;
                }
                else if (left == null || right == null) {
                    return false;
                }
                else if (left.val != right.val) {
                    return false;
                }
                else {
                    treeNodes.offer(left.left);
                    treeNodes.offer(right.right);
                    treeNodes.offer(left.right);
                    treeNodes.offer(right.left);
                }
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left);
    }

}
