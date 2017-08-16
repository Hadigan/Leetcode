package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SolOfbinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stackTreeNode = new Stack<>();
        Stack<String> stackString = new Stack<>();
        TreeNode tmpNode;
        stackTreeNode.push(root);
        stackString.push("");
        while (!stackTreeNode.isEmpty()) {
            tmpNode = stackTreeNode.pop();
            String fatherString = stackString.pop();
            if (tmpNode.left == null && tmpNode.right == null) {
                    result.add(String.valueOf(fatherString + tmpNode.val));
            }
            if (tmpNode.right != null) {
                stackTreeNode.push(tmpNode.right);
                stackString.push(fatherString + String.valueOf(tmpNode.val) + "->");
            }
            if (tmpNode.left != null) {
                stackTreeNode.push(tmpNode.left);
                stackString.push(fatherString + String.valueOf(tmpNode.val) + "->");
            }
        }
        return result;
    }
}

