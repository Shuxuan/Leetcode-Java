package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuxuannie on 7/28/16.
 */
public class GeneralizedAbbreviation {

    public List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList<>();

        helper(word, 0, rst, new StringBuffer(), true);

        return rst;
    }

    public void helper(String word, int pos, List<String> rst, StringBuffer path, boolean useAbbr) {
        if(pos == word.length()) {
            rst.add(new String(path));
            return;
        }

        for (int i = pos; i < word.length(); i++) {
            // use abbr
            if (useAbbr) {
                path.append(i-pos+1);
                //helper(word,i+1 rst, path, false);
                helper(word, i+1, rst, path, false);
                path.deleteCharAt(path.length()-1);
            }
            // not use abbr
            path.append(word.substring(pos, i+1));
            helper(word, i+1, rst, path, true);
            path.delete(path.length()-i-pos - 2, path.length() - 1);

        }
    }

    public static void main(String[] args) {
        GeneralizedAbbreviation obj = new GeneralizedAbbreviation();
        String word = "word";
        obj.generateAbbreviations(word);
    }
}
