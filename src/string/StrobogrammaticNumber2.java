package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuxuannie on 7/8/16.
 *
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Find all strobogrammatic numbers that are of length = n.

 For example,
 Given n = 2, return ["11","69","88","96"].

 Hint:

 Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.

 n = ?
 0 : none
 1 : 0, 1, 8
 2 : 11, 88, 69, 96
 3 : 101, 111, 181, 609, 619, 689, 808, 818, 888, 906, 916, 986
 4 : 1001, 1111, 1881, 1691, 1961

 */
public class StrobogrammaticNumber2 {

    public static List<String> findStrobogrammatic(int n) {
        ArrayList<String> result = new ArrayList<>();
        find(n, n, result);
        return result;
    }

    public static void find(int m, int n, ArrayList<String> result) {
        if (m == 0) {
            result.add("");
            return;
        }

        if (m == 1) {
            result.add("1");
            result.add("0");
            result.add("8");
            return;
        }


        find(m-2, n, result);
        int size = result.size();
        for (int i = 0; i < size; i++) {
            String s = result.get(i);
            if (m != n) {
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("8" + s + "8");
            result.add("6" + s + "9");
            result.add("9" + s + "6");
        }

        for (int i = 0; i < size; i++) {
            result.remove(0);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        StrobogrammaticNumber2.findStrobogrammatic(n);
    }
}
