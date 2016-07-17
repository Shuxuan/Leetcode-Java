package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuxuannie on 7/13/16.
 */
public class GroupShiftedStrings {

    /*
题解：
给的例子太不具说明性了。应该举这个例子：

["eqdf", "qcpr"]。

((‘q’ - 'e') + 26) % 26 = 12, ((‘d’ - 'q') + 26) % 26 = 13, ((‘f’ - 'd') + 26) % 26 = 2

((‘c’ - 'q') + 26) % 26 = 12, ((‘p’ - 'c') + 26) % 26 = 13, ((‘r’ - 'p') + 26) % 26 = 2

所以"eqdf"和"qcpr"是一组shifted strings。
*/
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> d = new HashMap<>();
        for(int i = 0; i < strings.length; i++) {
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < strings[i].length(); j++) {
                sb.append(Integer.toString(((strings[i].charAt(j) - strings[i].charAt(0)) + 26) % 26));
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
        int a = ('q' - 'e' + 26) ;
        int b = ('c' - 'q' + 26) ;

        System.out.println(a);
        System.out.println(b);

    }
}
