package com.company;

public class SolOfIntToRoman {
    static String[] strThousand = {"","M","MM","MMM"};
    static String[] strHundred = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    static String[] strTen =     {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    static String[] strOne =     {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    public String intToRoman(int num) {
        int thousand = num / 1000;
        int hundred = (num % 1000) / 100;
        int ten = (num % 100) / 10;
        int one = num %10 ;
        return strThousand[thousand] + strHundred[hundred] +strTen[ten] + strOne[one];
    }
}
