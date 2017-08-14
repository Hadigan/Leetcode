package com.company;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        System.out.println(Arrays.copyOfRange(a,0,1).length);
        return;
    }
}
