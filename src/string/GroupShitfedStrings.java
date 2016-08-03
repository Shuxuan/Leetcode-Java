package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuxuannie on 7/20/16.
 */
public class GroupShitfedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> d = new HashMap<>();
        for(int i = 0; i < strings.length; i++) {
            StringBuffer sb = new StringBuffer();
            for(int j = 1; j < strings[i].length(); j++) {

                sb.append(Integer.toString(((strings[i].charAt(j) - strings[i].charAt(j-1)) + 26)%26));
                sb.append(" ");
            }
            String shift = sb.toString();
            if(d.containsKey(shift)) {
                d.get(shift).add(strings[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(strings[i]);
                d.put(shift, l);
            }
        }

        for(String s : d.keySet()) {
            Collections.sort(d.get(s));
            result.add(d.get(s));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"az", "ba"};
        GroupShitfedStrings obj = new GroupShitfedStrings();
        obj.groupStrings(strings);
    }
}
