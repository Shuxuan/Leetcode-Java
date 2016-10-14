/**
 * Created by shuxuannie on 7/22/16.
 */
public class GuessNumberHigherOrLower {

    int val;

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int trend = guess(mid);
            if (trend == 0) {
                return mid;
            } else if (trend == 1) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (guess(left) == 0) {
            return left;
        }

        return right;
    }

    public int guess(int i) {
        if (i == val) {
            return 0;
        } else if (i > val) {
            return 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower obj = new GuessNumberHigherOrLower();
        obj.val = 6;
        System.out.println(obj.guessNumber(12));
    }
}
