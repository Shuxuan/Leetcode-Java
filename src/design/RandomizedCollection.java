package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by shuxuannie on 8/18/16.
 */
public class RandomizedCollection {
    List<Integer> nums;
    HashMap<Integer, List<Integer>> locations;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        locations = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = false;
        if (!locations.containsKey(val)) {
            locations.put(val, new ArrayList<>());
            result = true;
        }
        locations.get(val).add(nums.size());
        nums.add(val);
        return result;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(locations.containsKey(val)) {
            int idx = locations.get(val).get(locations.get(val).size()-1);
            int last = nums.get(nums.size()-1);
            nums.add(idx, last);
            //update locations:
            List<Integer> list = locations.get(last);
            list.remove(list.size()-1);
            list.add(idx);
            nums.remove(nums.size()-1);
            locations.get(val).remove(locations.get(val).size()-1);
            if (locations.get(val).size() == 0) {
                locations.remove(val);
            }

            return true;
        }

        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int next = random.nextInt(nums.size());
        return nums.get(next);
    }

    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        obj.insert(0);
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(3);
        obj.remove(2);
        obj.remove(3);
        obj.remove(0);
        System.out.println(obj.getRandom());

    }
}