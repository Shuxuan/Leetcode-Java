package math;

/**
 * Created by shuxuannie on 7/19/16.
 */
public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int rst = mid * mid;
            if (rst == num) {
                return true;
            } else if ( rst < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start * start == num || end * end == num) {

            return true;
        }
        return false;
    }

    public static void main (String[] args) {
        int num = 808201;
        System.out.println(Math.sqrt(num));
        System.out.println(ValidPerfectSquare.isPerfectSquare(num));
    }
}
