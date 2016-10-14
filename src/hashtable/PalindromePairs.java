package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuxuannie on 7/18/16.
 *
 * 336. Palindrome Pairs  QuestionEditorial Solution  My Submissions
 Total Accepted: 8507
 Total Submissions: 40357
 Difficulty: Hard
 Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]


 */
public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> rst = new ArrayList<>();

        //保存单词和下标idx
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        //
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // 1)
            if (isPalindrome(word) && !word.equals("") && map.containsKey("")) {
                int idx = map.get("");

                List<Integer> ans = new ArrayList<>();
                ans.add(i);
                ans.add(idx);

                List<Integer> ans2 = new ArrayList<>();
                ans2.add(idx);
                ans2.add(i);

                rst.add(ans);
                rst.add(ans2);
            }

            //2)
            String reverse = reverse(word);
            if (map.containsKey(reverse)) {
                int ridx = map.get(reverse);
                if (i != ridx) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(ridx);
                    rst.add(ans);
                }
            }

            // 3)
            for (int idx = 1; idx <= word.length()-1; idx++) {
                String left = word.substring(0, idx);
                String right = word.substring(idx);
                String rleft = reverse(left);
                String rright = reverse(right);
                if (isPalindrome(left) && map.containsKey(rright)) {
                    int rridx = map.get(rright);
                    List<Integer> ans = new ArrayList<>();
                    ans.add(rridx);
                    ans.add(i);
                    rst.add(ans);
                }
                if (isPalindrome(right) && map.containsKey(rleft)) {
                    int rlidx = map.get(rleft);
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(rlidx);
                    rst.add(ans);
                }
            }
        }
        return rst;

    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }

        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        PalindromePairs obj = new PalindromePairs();
        List<List<Integer>> rst = obj.palindromePairs(words);
        for (List<Integer> list : rst) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
