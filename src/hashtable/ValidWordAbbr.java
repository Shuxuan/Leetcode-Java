package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuxuannie on 7/18/16.
 */
public class ValidWordAbbr {

    Set<String> set_abb = new HashSet<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            set_abb.add(getAbb(word));
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbb(word);
        if (set_abb.contains(abbr)) {
            return false;
        }

        return true;
    }

    private String getAbb(String word) {
        if (word.length() <= 2) {
            return word;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(String.valueOf(word.length() - 2));
        sb.append(word.charAt(word.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] dict = {"hello"};
        String word = "hello";
        ValidWordAbbr obj = new ValidWordAbbr(dict);
        boolean rst = obj.isUnique("hello");

        System.out.println(rst);
    }
}


