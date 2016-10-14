package design;

/**
 * Created by shuxuannie on 8/4/16.
 */
public class TicTacToe {

    int[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int n = board.length;
        board[row][col] = player;

        //判断行
        for (int i = 0; i < n; i++) {
            int j = 1;
            for (j = 1; j < n; j++) {
                if (board[i][j] != board[i][j-1]) {
                    break;
                }
            }
            if (j == n-1) {
                return board[i][0];
            }
        }

        //判断列
        for (int j = 0; j < n; j++) {
            int i = 1;
            for (i = 1; i < n; i++) {
                if (board[i][j] != board[i-1][j]) {
                    break;
                }
            }

            if (i == n-1) {
                return board[0][j];
            }
        }

        //判断对角线
        for (int i = 1; i < n; i++) {
            if (board[i][i] != board[i-1][i-1]) {
                break;
            }
            if (i == n-1) {
                return board[0][0];
            }
        }

        for (int i = n-1; i > 0; i--) {
            if (board[i][n-1-i] != board[i-1][n-i]) {
                break;
            }
            if (i == 1) {
                return board[n-1][0];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int n = 3;
        TicTacToe obj = new TicTacToe(n);
        System.out.println(obj.move(0,0,1));
        System.out.println(obj.move(0,2,2));
        System.out.println(obj.move(2,2,1));
        System.out.println(obj.move(1,1,2));
        System.out.println(obj.move(2,0,1));
        System.out.println(obj.move(1,0,2));
        System.out.println(obj.move(2,1,1));
    }
}
