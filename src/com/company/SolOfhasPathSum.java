package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackVal = new Stack<>();
        Stack<List<Integer>> stackList = new Stack<>();
        int fatherSum = 0;
        TreeNode tmpNode;
        List<Integer> tmpList = new LinkedList<>();
        stackNode.push(root);
        stackVal.push(new Integer(0));
        stackList.push(new LinkedList<>());
        while (!stackNode.isEmpty()) {
            tmpNode = stackNode.pop();
            fatherSum = stackVal.pop();
            tmpList = stackList.pop();
            if (tmpNode.left == null && tmpNode.right == null) {
                if (fatherSum + tmpNode.val == sum) {
                    tmpList.add(tmpNode.val);
                    System.out.println(tmpNode.val);
                    System.out.println(fatherSum);
                    System.out.println(tmpList);
                    result.add(tmpList);
                }
            }
            else {
                tmpList.add(tmpNode.val);
                if (tmpNode.right != null) {
                    stackNode.push(tmpNode.right);
                    stackVal.push(fatherSum + tmpNode.val);
                    //List<Integer> tmpListRight = new LinkedList<>();
                    //tmpListRight.addAll(tmpList);
                    stackList.push(new LinkedList<>(tmpList));
                }
                if (tmpNode.left != null) {
                    stackNode.push(tmpNode.left);
                    stackVal.push(fatherSum + tmpNode.val);
                    //List<Integer> tmpListLeft = new LinkedList<>();
                    //tmpListLeft.addAll(tmpList);
                    stackList.push(new LinkedList<>(tmpList));
                }
            }
        }
        return result;
    }

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, res, path);
        return res;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
        if(root==null) return;
        path.add(root.val);

        if(root.left==null && root.right==null ){
            if(root.val==sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if(root.left!=null) {
            dfs(root.left,sum-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            dfs(root.right,sum-root.val,res,path);
            path.remove(path.size()-1);
        }

    }
    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                SUM+=cur.val;
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            }
            if(cur.left==null && cur.right==null && SUM==sum)
                res.add(new ArrayList<Integer>(path));

            pre = cur;
            stack.pop();
            path.remove(path.size()-1);
            SUM-=cur.val;
            cur = null;

        }
        return res;
    }

}
