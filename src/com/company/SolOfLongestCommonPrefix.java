package com.company;

public class SolOfLongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int min = 0x7fffffff;
        int maxLength = 0;
        for (int i = 0; i < strs.length; i++) {
            min = (strs[i].length() < min) ? strs[i].length() : min;
        }
        if (min == 0) return "";

        for (maxLength = 0; maxLength < min; maxLength++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(maxLength) != strs[0].charAt(maxLength)) {
                    return strs[0].substring(0, maxLength);
                }
            }
        }
        return strs[0].substring(0,maxLength);
    }
}
