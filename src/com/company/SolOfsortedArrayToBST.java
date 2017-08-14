package com.company;

import java.util.Arrays;

public class SolOfsortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int medianIndex = nums.length / 2;
        TreeNode result = new TreeNode(nums[medianIndex]);
        result.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, medianIndex));
        result.right = sortedArrayToBST(Arrays.copyOfRange(nums, medianIndex + 1, nums.length));
        return result;
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return helper(0, nums.length - 1, nums);
    }

    private TreeNode helper(int start, int end, int[] nums) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(start, mid - 1, nums);
        root.right = helper(mid + 1, end, nums);
        return root;
    }
}
