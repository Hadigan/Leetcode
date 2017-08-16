package com.company;

import java.util.Stack;

public class SolOfhasPathSum {
    public boolean hasPathSum2(TreeNode root, int sum) {

        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackVal = new Stack<>();
        int fatherSum = 0;
        TreeNode tmpTreeNode;
        stack.push(root);
        stackVal.push(new Integer(0));
        while (!stack.isEmpty()) {
            tmpTreeNode = stack.pop();
            fatherSum = stackVal.pop();
            if (tmpTreeNode.left == null && tmpTreeNode.right == null) {
                if (fatherSum + tmpTreeNode.val == sum) {
                    return true;
                }
            }
            else {
                if (tmpTreeNode.right != null) {
                    stack.push(tmpTreeNode.right);
                    stackVal.push(new Integer(fatherSum + tmpTreeNode.val));
                }
                if (tmpTreeNode.left != null) {
                    stack.push(tmpTreeNode.left);
                    stackVal.push(new Integer(fatherSum + tmpTreeNode.val));
                }
            }
        }
        return false;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }

}
