package com.company;

public class SolOfuniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];
        d[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    d[i][j] = 1;
                    continue;
                }
                d[i][j] = d[i-1][j] + d[i][j-1];
            }
        }
        return d[m-1][n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0].length == 0) return 0;
        int[][] d = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    d[i][j] = 0;
                }
                else if (i == 0 && j > 0) {
                    d[i][j] = d[i][j - 1];
                }
                else if (i > 0 && j == 0) {
                    d[i][j] = d[i - 1][j];
                }
                else if (i == 0 && j == 0) {
                    d[i][j] = 1;
                }
                else {
                    d[i][j] = d[i - 1][j] + d[i][j - 1];
                }

            }
        }
        return d[d.length-1][d[0].length-1];
    }
}
