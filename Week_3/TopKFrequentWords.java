// This is a solution for Q.692(Top K Frequent Words) 
// We use a map to store information about the frequency of each string in the array and then use a heap to retrieve the k most frequent strings
import java.util.*;
public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));

    }
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // Create a comparator that compares the values in the map
        Comparator<String> comp = (a, b) -> {
            if (map.get(a) == map.get(b)) {
                return a.compareTo(b);
            }
            return Integer.compare(map.get(b), map.get(a)); // putting b as the first argument and b as the second makes sure that the heap we create through this comparator gives high priority for keys with higher values 
        };
        PriorityQueue<String> heap = new PriorityQueue<>(comp);
        for (String key : map.keySet()) {
            heap.add(key);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.remove());
        }

        return result;
        // Let n be the length of the array, words
        // Time Complexity: O(nlogn) - going through the whole array and putting it in a map with the frequency as the value takes O(n) time
        // And adding all the keys of the map into the heap takes O(nlogn) time so we take the dominant time (O(nlogn))
        // Space Complexity: O(n) - both the map and the heap contain all the elements of the array, words so they take O(n) space each in the worst case (if all strings are unique)
        // And we don't take results into account because it is the output
    }
}
