package com.company;

import java.util.Stack;

public class SolOfisValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> dfs = new Stack<>();
        TreeNode p = root;
        boolean isFirst = true;
        int last = Integer.MIN_VALUE;
        while (p != null || !dfs.empty()) {
            if (p != null) {
                dfs.push(p);
                p = p.left;
            }
            else {
                p = dfs.pop();
                if (!isFirst) {
                    if (last >= p.val) return false;
                }
                isFirst = false;
                last = p.val;
                p = p.right;
            }
        }
        return true;
    }
}
