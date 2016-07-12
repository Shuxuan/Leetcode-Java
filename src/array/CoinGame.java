package array;

/**
 * Created by shuxuannie on 7/11/16.
 */
public class CoinGame {

    public static int play(int[] coins, int n) {
        int result = n;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (coin == 0) {
                result = result / 2;
                if (result == 0) {
                    return 0;
                }
            } else {
                result = result * 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] coins = {0,0,0,1,0};
        int n = 10;

        System.out.println(CoinGame.play(coins, n));
    }
}
