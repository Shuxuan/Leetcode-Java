package array;

/**
 * Created by shuxuannie on 7/18/16.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        //corner case
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(pos)) {
            return false;
        }

        board[i][j] = '#';
        boolean rst = dfs(board, word, i-1, j, pos+1) || dfs(board, word, i+1, j, pos+1) || dfs(board, word, i, j-1, pos+1) || dfs(board, word, i, j+1, pos + 1);
        board[i][j] = word.charAt(pos);

        return rst;
    }
}
