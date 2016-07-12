package dynamicprogramming;

/**
 * Created by shuxuannie on 7/11/16.
 */
public class ScrambleString {

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        //s1:  s11, s12,
        //s2:  s21, s22
        // s11, s21 && s12 s22 || s11 s22 && s12 s21
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (k == 1) {
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j) ? true : false;
                        continue;
                    }

                    for (int m = 1; m < k; m++) {

                    }
                }
            }
        }


        return dp[0][0][n];
    }
}
