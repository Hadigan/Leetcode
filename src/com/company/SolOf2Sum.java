package com.company;

import java.util.HashMap;
import java.util.Map;

public class SolOf2Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<>();
        int[] result = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            if (tmpMap.containsKey(target - nums[i])) {
                result[0] = tmpMap.get(target - nums[i]);
                result[1] = i;
                break;
            }
            else {
                tmpMap.put(nums[i], i);
            }
        }
        return result;
    }
}
