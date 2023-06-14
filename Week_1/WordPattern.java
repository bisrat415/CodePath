package Week_1;
package Week_1;
// The is a leetcode question
import java.util.*;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        String[] sArr = s.split(" ");
        if (pattern.length() != sArr.length) {
            return false;
        }
        for (int i = 0; i < sArr.length; i++) {
            char ch = pattern.charAt(i);
            String word = sArr[i];
            if (map1.containsKey(ch)) {
                if (!word.equals(map1.get(ch))) {
                    return false;
                }
            } else {
                map1.put(ch, word);
            }
            if (map2.containsKey(word)) {
                if (ch != map2.get(word)) {
                    return false;
                } 
            } else {
                map2.put(word, ch);
            }
        }
        return true;

        // Let n be the number of items in sArr or the number of characters in s assuming that they are equal
        // Time Complexity: O(n) because split is O(n) and the forloop goes through the array once (O(n)) and all the operations inside the forloop are contant time
        // Space Complexity: O(n) because of the hashmaps
        
    }

}