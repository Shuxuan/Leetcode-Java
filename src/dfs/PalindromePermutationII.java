package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuxuannie on 7/28/16.
 */
public class PalindromePermutationII {

    HashMap<Character, Integer> map = new HashMap<>();
    char odd = '#';

    public List<String> generatePalindromes(String s) {
        List<String> rst = new ArrayList<String>();

        if(s == null || s.length() == 0 || !isPalindromes(s)) {
            return rst;
        }

        StringBuffer sb = new StringBuffer();
        if (odd != '#') {
            sb.append(odd);
        }
        dfs(map, rst, sb, s, 0);

        return rst;
    }

    public void dfs(HashMap<Character, Integer> map, List<String> rst, StringBuffer sb, String s, int pos) {
        if (sb.length() == s.length()) {
            rst.add(new String(sb));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) >= 2) {
                map.put(c, map.get(c) - 2);
                sb.insert(0, c);
                sb.append(c);
                dfs(map, rst, sb, s,pos+1);
                map.put(c, map.get(c) + 2);
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public boolean isPalindromes(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            //System.out.println(entry.getKey() + "/" + entry.getValue());
            if (entry.getValue() % 2 != 0) {
                count++;
                odd = entry.getKey();
            }
        }

        return count < 2;
    }

    public static void main(String[] args) {
        String s = "aabb";
        PalindromePermutationII obj = new PalindromePermutationII();
        obj.generatePalindromes(s);
    }
}
