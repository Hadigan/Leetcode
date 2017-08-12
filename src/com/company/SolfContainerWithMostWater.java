package com.company;

public class SolfContainerWithMostWater {
    public int maxArea(int[] height) {
        int containers = 0;
        int i = 0;
        int j = height.length - 1;
        int min = Math.min(height[i], height[j]);
        int max = Math.min(height[i], height[j]) * (j - i);
        while(i < j) {
            if (height[i] < height[j]) {
                min = height[i];
                while (height[i] <= min && i < j ) i++;
                containers = Math.min(height[i], height[j]) * (j - i);
                max = (containers > max) ? containers : max;
            }
            else {
                min = height[j];
                while (height[j] <= min && j > i) j--;
                containers = Math.min(height[i], height[j]) * (j - i);
                max = (containers > max) ? containers : max;
            }
        }
        return max;
    }
    public int maxArea2(int[] height) {
        int max = 0;
        int containers = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                containers = Math.min(height[i], height[j]) * (j - i);
                if (containers > max) {
                    max = containers;
                }
            }
        }
        return 0;
    }
    public int maxArea3(int[] height) {
        int water = 0;
        int i = 0, j = height.length - 1;
        while(i < j) {
            int h = Math.min(height[i], height[j]);
            water = Math.max(water, h* (j-i));
            while(height[i] <= h && i<j) i++;
            while(height[j] <=h && i<j) j--;
        }
        return water;
    }
}
