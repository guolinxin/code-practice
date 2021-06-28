package com.guo.practice.codepractice.problems.leetcode.topInterview;

public class BattleShip {
  public int countBattleships(char[][] board) {
    if (board == null || board.length == 0) return 0;
    int ships = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'X') {
          ships++;
          dfs(board, i, j);
        }
      }
    }
    return ships;
  }

  public void dfs(char board[][], int i, int j) {
    if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] == '.') return;
    else {
      board[i][j] = '.';

      dfs(board, i + 1, j);
      dfs(board, i - 1, j);
      dfs(board, i, j + 1);
      dfs(board, i, j - 1);
    }
  }
}
