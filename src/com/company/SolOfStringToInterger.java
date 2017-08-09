package com.company;

import javafx.geometry.Pos;

/**
 * Created by hadigan on 2017/8/9.
 */
public class SolOfStringToInterger {
    public int myAtoi(String str) {
        long result = 0;
        int PositiveOrNegative = 1;
        int index = 0;
        for ( ;index < str.length();index++) {
            if (str.charAt(index)!=' ') {
                break;
            }
        }
        if (str.length() == 0) {

        } else if (str.charAt(index) == '-') {
            PositiveOrNegative = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            PositiveOrNegative = 1;
            index++;
        }
        for ( ;index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            result = result * 10;
            result = result + str.charAt(index) - '0';
            if (result > Integer.MAX_VALUE) {
                break;
            }
        }
        result = result * PositiveOrNegative;
        result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : result;
        result = (result < Integer.MIN_VALUE) ? Integer.MIN_VALUE : result;
        return (int)result;
    }
}
