// This is a solution for Q.347(Top K Frequent Elements) 
// We use a map to store information about the frequency of each element in the array and then use a heap to retrieve the k most frequent elements

import java.util.*;


public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

    }
    public static int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);     
        }
        Comparator<Integer> comp = (a, b) -> {
            return Integer.compare(map.get(a), map.get(b)); // 
        };
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(comp);
        for(int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }
      
        int[] result = new int[heap.size()];
        int i = 0;
        while (!heap.isEmpty()) {
            result[i] = heap.remove();
            i++;
        }
        return result;
        // let n be the number of elements in the array
        // Time Complexity: O(nlogk) - the first forloop takes O(n) time. The second forloop takes O(nlogk) because adding to the heap takes O(logk) since the size of the heap is restricted to be k. And the while loop takes O(klogk).
        // Space Complexity: O(n) - the hashmap takes O(n). The heap takes O(k) and the result array is not counted as auxiliary space since it is the output


    }    

}

