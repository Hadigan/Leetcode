package com.company;

/**
 * Created by hadigan on 2017/8/9.
 */
public class SolutionOfReverseInterger {
    public int reverse(int x) {
        int positiveOrNegative = (x >= 0) ? 1 : -1;
        long result = 0;
        x = x * positiveOrNegative;

        for (int i = 0;i < 11;i++) {
            result = result * 10;
            result = result + (x % 10);
            x = x / 10;
            if (x == 0) {
                break;
            }
        }
        result  = result * positiveOrNegative;
        result = (result > 0x7fffffff) ? 0 : result;
        result = (result < 0x80000000) ? 0 : result;
        return (int)result;
    }
}
