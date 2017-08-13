package com.company;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SofOfIsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        if ((p.left == null) != (q.left == null)) return false;
        if (p.left != null) {
            if (this.isSameTree(p.left, q.left) == false)
                return false;
        }
        if ((p.right == null) != (q.right == null)) return false;
        if (p.right != null) {
            if (this.isSameTree(p.right, q.right) == false)
                return false;
        }
        return true;
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

}
