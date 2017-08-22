package com.company;

public class SolOfCountBattleShips {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0;j < board[0].length; j++) {
                if (board[i][j] == '.') {}
                else if (i == 0 && j == 0)  result++;
                else if (i == 0 && j > 0) {
                    if (board[0][j-1] == '.') result++;
                }
                else if (j == 0 && i > 0) {
                    if (board[i-1][0] == '.') result++;
                }
                else if (board[i-1][j] == '.' && board[i][j-1] == '.')  result++;
            }
        return result;
    }
}
