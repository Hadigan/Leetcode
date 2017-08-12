package com.company;

public class SolOfRomanToInt {
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M': result += 1000; break;
                case 'D': result += 500; break;
                case 'C': {
                    result += 100;
                    if (i < s.length()-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) result -= 200;
                    break;
                }
                case 'L': result += 50; break;
                case 'X': {
                    result += 10;
                    if (i < s.length()-1 && (s.charAt(i+1) == 'C' || s.charAt(i+1) == 'L')) result -= 20;
                    break;
                }
                case 'V': result += 5; break;
                case 'I': {
                    result += 1;
                    if (i < s.length()-1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) result -= 2;
                    break;
                }
                default: break;
            }
        }
        return result;
    }
}
