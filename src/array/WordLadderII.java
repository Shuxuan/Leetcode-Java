package array;

import java.util.*;

/**
 * Created by shuxuannie on 7/18/16.
 */
public class WordLadderII {

    //所有方案： dfs
    //所有最短的方案： 第一步最短时多少： bfs
    //                 第二步找到所有最短 dfs
    // 所以这道题是dfs和bfs的整合

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        HashMap<String,Integer> distance = new HashMap<>();
        HashMap<String, List<String>> map = new HashMap<>();

        wordList.add(endWord);

        // bfs --> distance, map
        bfs(beginWord, endWord, wordList, distance, map);
        // dfs --> get all answers based on shortest path from bfs
        dfs(endWord, beginWord, wordList, distance, map, new ArrayList<String>(), result);

        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordList, HashMap<String, Integer> distance, HashMap<String, List<String>> map) {

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        distance.put(beginWord, 1);

        for (String word : wordList) {
            map.put(word, new ArrayList<String>());
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> nextWords = getNextWords(word, wordList);
                for (String nextWord : nextWords) {
                    map.get(nextWord).add(word);
                    if(distance.containsKey(nextWord)) {
                        continue;
                    }
                    distance.put(nextWord, distance.get(word) + 1);

                    queue.offer(nextWord);
                }
            }
        }
    }

    private void dfs(String curr, String beginWord, Set<String> wordList, HashMap<String, Integer> distance, HashMap<String, List<String>> map, List<String> path, List<List<String>> result) {

        path.add(curr);

        if (curr.equals(beginWord)) {
            Collections.reverse(path);
            result.add(new ArrayList<String>(path));
            Collections.reverse(path);

        } else {
            for (String prev : map.get(curr)) {
                if (distance.get(curr) == distance.get(prev) + 1) {
                    dfs(prev, beginWord, wordList, distance, map, path, result);
                }
            }
        }

        path.remove(curr);
    }

    private List<String> getNextWords(String word, Set<String> wordList) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                String newWord = replace(word, i, c);
                if (wordList.contains(newWord)) {
                    list.add(newWord);
                }
            }
        }
        return list;
    }

    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordList = new HashSet<String>();



        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");

        WordLadderII obj = new WordLadderII();

        System.out.println(obj.findLadders(beginWord, endWord, wordList));

    }


}
