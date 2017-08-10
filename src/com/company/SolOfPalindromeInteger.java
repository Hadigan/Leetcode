package com.company;

/**
 * Created by hadigan on 2017/8/10.
 */
public class SolOfPalindromeInteger {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int i = (int) Math.log10(x) + 1;
        int j = 1;
        while(i > j) {
            if (whatNumber(x, i) != whatNumber(x, j)) {
                return false;
            }
            i--; j++;
        }
        return true;
    }
    public int whatNumber(int a, int b) {
        while(--b > 0)  a = a / 10;
        return (a % 10);
    }
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        long result = 0;
        long origin = x;
        while(x != 0) {
            result = result*10 + x%10;
            x = x / 10;
        }
        return result == origin;
    }
}