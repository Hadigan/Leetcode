package com.company;

public class SolOfuniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];
        d[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) {
                    d[i][j] = j;
                    continue;
                }
                if (j == 0 && i > 0) {
                    d[i][j] = i;
                    continue;
                }
                if (i == 0 && j == 0) {
                    d[i][j] = 1;
                    continue;
                }
                d[i][j] = d[i-1][j] + d[i][j-1];
            }
        }
        return d[m-1][n-1];
    }
}
