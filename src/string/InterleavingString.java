package string;

/**
 * Created by shuxuannie on 7/13/16.
 */
public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }

        if (s1.length() > 0 && s2.length() > 0 && s3.length() > 0 && s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1), s3.substring(1));
        } else if (s1.length() > 0 && s3.length() > 0 && s1.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1), s2, s3.substring(1));
        } else if (s2.length() > 0 && s3.length() > 0 && s2.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "b";
        String s3 = "a";
        System.out.println(InterleavingString.isInterleave(s1,s2,s3));
    }
}
