package array;

import java.util.*;

/**
 * Created by shuxuannie on 7/18/16.
 */
public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        Set<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();

        set.add(beginWord);
        queue.offer(beginWord);
        wordList.add(endWord);
        int count = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                ArrayList<String> nextWords = getNextWords(curr, wordList);
                if (nextWords.size() == 0 ) {
                    return 0;
                }
                for (String nextWord: nextWords) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return count;
                    }
                    set.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }

        return 0;
    }

    public static ArrayList<String> getNextWords(String word, Set<String> wordList) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = replace(word, i, c);
                if (wordList.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }

    public static String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");

        System.out.println(WordLadder.ladderLength(beginWord,endWord,wordList));

    }

}
