package dynamicprogramming;

/**
 * Created by shuxuannie on 7/11/16.
 */
public class PossibleRouteinChestTable {

    public static boolean isRoutable(char[][] chesstable) {
        if (chesstable == null || chesstable.length == 0 || chesstable[0].length == 0) {
            return false;
        }

        int m = chesstable.length;
        int n = chesstable[0].length;

        return helper(n-1, 1, chesstable);

    }

    public static boolean helper(int i, int j, char[][] chesstable) {
        if (i == 0 ) {
            return true;
        }

        if ( i < 0 || j > chesstable[0].length) {
            return false;
        }

        boolean up = false, upright = false, upleft = false;
        if (i > 0 && chesstable[i-1][j] == 'o') {
            up = helper(i-1, j, chesstable);
        }

        if (i > 0 && j > 0 && chesstable[i-1][j-1] == 'x') {
            upleft = helper(i-1, j, chesstable);
        }

        if (i > 0 && j < chesstable[0].length - 1 && chesstable[i-1][j+1] == 'x') {
            upright = helper(i-1, j+1, chesstable);
        }
        return up || upleft || upright;
    }

    public static void main(String[] args) {
        char[][] table = {{'x','x','o','o'},
                          {'x','o','x','o'},
                          {'o','x','o','x'},
                          {'o','o','o','o'}};

        System.out.println(PossibleRouteinChestTable.isRoutable(table));
    }
}
