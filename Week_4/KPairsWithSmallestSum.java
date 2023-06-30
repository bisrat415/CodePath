// This is a solution for Q.373(Find K Pairs with Smallest Sums) from leetcode

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class KPairsWithSmallestSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        System.out.println(kSmallestPairs2(nums1, nums2, 3));

    }

    // Brute forced solution - Time Limit Exceeds
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                minHeap.add(Arrays.asList(nums1[i], nums2[j]));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (k > 0 && !minHeap.isEmpty()) {
            result.add(minHeap.remove());
            k--;
        }
        return result; 
        // Let n be the length of nums1 and m be the length of nums2
        // Time Complexity: O(n*m*log(n*m)) because of the double for loop and adding to the heap
        // Space Complexity: O(n*m) due to the elements from nums1 and nums2 added to the minHeap.
    }

    // Optimal Solution
    // For detailed explanation of the algorithm visit this link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/editorial/
    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        Set<List<Integer>> visited = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        minHeap.add(Arrays.asList((nums1[0] + nums2[0]), 0, 0));
        while (k > 0 && !minHeap.isEmpty()) {
            List<Integer> curr = minHeap.remove();
            int i = curr.get(1);
            int j = curr.get(2);
            result.add(Arrays.asList(nums1[i], nums2[j]));
            if (i + 1 < nums1.length && !visited.contains(Arrays.asList(i + 1, j))) {
                minHeap.add(Arrays.asList((nums1[i + 1] + nums2[j]), i + 1, j));
                visited.add(Arrays.asList(i + 1, j));
            }
            if (j + 1 < nums2.length && !visited.contains(Arrays.asList(i, j + 1))) {
                minHeap.add(Arrays.asList((nums1[i] + nums2[j + 1]), i, j + 1));
                visited.add(Arrays.asList(i, j + 1));
            }
            k--;
        }
        return result;
        // Let n be the length of nums1 and m be the length of nums2
        // Time Complexity: O(min(klogk, m*nlog(m*n))) - the loop is terminated either when k is less than zero or the heap is empty (we went through all the possible n*m pairs). So that is why we take the minimum
        //And the log comes from adding and removing from the heap
        // Space Complexity: O(min(k, m*n)) - the visited set and the heap can grow up to a size of O(min(k, m*n)) because at each iteration we are inserting at most two pairs and popping one pair
    }
}
