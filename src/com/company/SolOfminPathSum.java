package com.company;

public class SolOfminPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++)
            grid[i][0] += grid[i-1][0];
        for (int j = 1; j < n; j++)
            grid[0][j] += grid[0][j-1];
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
    public int minPathSum2(int[][] grid) {
        if(grid.length == 1 & grid[0].length == 1)
            return grid[0][0];
        for (int i = 1; i < grid.length; i++)
            grid[i][0] += grid[i - 1][0];

        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        findPath(grid, 1);
        int res = grid[grid.length - 1][grid[0].length - 1];
        return res;
    }

    public void findPath(int[][] grid, int i) {
        if(i == grid.length) {
            return;
        }
        for (int j = 1; j < grid[i].length; j++) {
            grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
        }

        findPath(grid, i + 1);
    }
}
