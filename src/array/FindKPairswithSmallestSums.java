package array;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by shuxuannie on 7/25/16.
 */
public class FindKPairswithSmallestSums {

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList<>();
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) {
            return res;
        }

        // index pair
        PriorityQueue<int[]> minQ = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] pair1, int[] pair2) {
                return (nums1[pair1[0]]+nums2[pair1[1]])-(nums1[pair2[0]]+nums2[pair2[1]]);
            }

        });


        minQ.offer(new int[]{0, 0});

        while (k>0 && !minQ.isEmpty()) {
            int[] pair=minQ.poll();
            int i = pair[0];
            int j = pair[1];
            res.add(new int[]{nums1[i], nums2[j]});
            k--;

            if(j+1<nums2.length) {
                minQ.offer(new int[]{i, j+1});
            }

            if(j==0 && i+1<nums1.length){
                minQ.offer(new int[] {i+1, 0});
            }

        }


        return res;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 9;

        System.out.println(FindKPairswithSmallestSums.kSmallestPairs(nums1, nums2, k));
    }


}
