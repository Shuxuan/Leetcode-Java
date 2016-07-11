package array;

import java.util.HashMap;

/**
 * Created by shuxuannie on 7/11/16.
 *
 * Two Sum III - Data structure design
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 *
 For example,
 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false
 *
 */
public class TwoSumIII {

    private HashMap<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }

    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Integer i : map.keySet()) {
            if (map.containsKey(value - i)) {
                if (value - i != i) {
                    return true;
                } else if (map.get(i) >= 2) {
                    //关键点在于对重复数字的处理，用hashmap存储值，然后判断value-num == num的情况下，count是否>=2.
                    return true;
                }
            }
        }

        return false;
    }
}
