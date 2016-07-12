package string;

import java.util.HashSet;

/**
 * Created by shuxuannie on 7/11/16.
 *
 * Add and Search Word - Data structure design  QuestionEditorial Solution  My Submissions
 Total Accepted: 28032
 Total Submissions: 138719
 Difficulty: Medium
 Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.

 */
public class AddAndSeaerchWord {

    // Adds a word into the data structure.
    HashSet<String> dict = new HashSet<String>();

    public void addWord(String word) {
        dict.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (dict.contains(word)) {
            return true;
        } else if (!word.contains(".")) {
            return false;
        }

        // handle "."
        for (int c = 'a'; c <= 'z'; c++) {
            int i = 0;
            while(word.charAt(i)!= '.') {
                i++;
            }
            StringBuilder sb = new StringBuilder(word);
            sb.setCharAt(i, (char)c);
            if (search(sb.toString())) {
                return true;
            }

        }

        return false;
    }
}
