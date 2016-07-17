package string;

/**
 * Created by shuxuannie on 7/13/16.
 *
 * 161. One Edit Distance  QuestionEditorial Solution  My Submissions
 Difficulty: Medium
 Given two strings S and T, determine if they are both one edit distance apart.

 */
public class OneEditDistance {

    public static boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];

        //dp[0][0] = 0;
        //dp[0][j] = j;
        //dp[i][0] = i
        //dp[i][j]
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //insert 'a' --> 'ae'
                    int insert = dp[i-1][j] + 1;

                    //delete 'ae' --> 'a'
                    int delete = dp[i][j-1] + 1;

                    //replace ae --> ac
                    int replace = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));

                }
            }
        }
        System.out.println(dp[m][n]);
        return dp[m][n] == 1;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "ba";
        OneEditDistance.isOneEditDistance(s, t);
    }
}
