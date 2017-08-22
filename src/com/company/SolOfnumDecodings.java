package com.company;

public class SolOfnumDecodings {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int[] d = new int[s.length()];
        if (s.charAt(1) == '0') {
            if (s.charAt(0)-'0' > 2) {
                return 0;
            }
            else {
                d[0] = 1;
                d[1] = 1;
            }
        }
        else {
            if (s.charAt(0)-'0' <= 2 && s.charAt(1)-'0' <= 6) {
                d[0] = 1;
                d[1] = 2;
            }
            else {
                d[0] = 1;
                d[1] = 1;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1)-'0' > 2 || s.charAt(i-1)-'0' == 0) {
                    return 0;
                }
                else {
                    d[i] = d[i-2];
                }
            }
            else if (s.charAt(i-1) == '0') {
                d[i] = d[i-1];
            }
            else if (s.charAt(i-1) - '0' == 2 && s.charAt(i) - '0' <= 6 || s.charAt(i-1) - '0' == 1) {
                d[i] = d[i-1] + d[i-2];
            }
            else {
                d[i] = d[i-1];
            }
        }
        return d[s.length()-1];
    }
}
