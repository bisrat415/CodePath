import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 This is a question from week 2's Hackerank
 Question: Each day, to enter their building, employees of an e-commerce company have to type a string of numbers
into a console using a 3 × 3 numeric keypad. Every day, the numbers on the keypad are mixed up.
Use the following rules to calculate the total amount of time it takes to type a string:
It takes 0 seconds to move their finger to the first key, and it takes 0 seconds to press the key where
their finger is located any number of times.
They can move their finger from one location to any adjacent key in one second. Adjacent keys
include those on a diagonal.
Moving to a non-adjacent key is done as a series of moves to adjacent keys.
Input from stdin will be processed as follows and passed to the function.
The first line contains a string s.
The next line contains a string keypad.
 */

/**
answer explanation: 
Step 1: calculate the distances between every pair of keys on a 3x3 keypad and store these distances in a hashmap. The 'distance' is the maximum of the row difference and column difference between the two keys.
Step 2: iterate over the sequence of keys to be entered. For each adjacent pair of keys in the sequence, find their distance in the hashmap and add this to a running total.
Step 3: The total calculated in step 2 is the "entry time" and is returned as the result.
 */

public class KeyBoard {
    public static void main(String[] args) {
        String keypad = "923857614";
        String s = "423692";
        System.out.println(entryTime(s, keypad));

    }
    public static int entryTime(String s, String keypad) {
        Map<String, Integer> dis = new HashMap<>(); // map to store distance between each pair of keys
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells.add(new int[]{i, j});

        for (int[] u : cells) {
            for (int[] v : cells) {
                char number1 = keypad.charAt(u[0] * 3 + u[1]);
                char number2 = keypad.charAt(v[0] * 3 + v[1]);
                String key = String.valueOf(number1) + String.valueOf(number2);
                dis.put(key, Math.max(Math.abs(u[0] - v[0]), Math.abs(u[1] - v[1]))); // distance between two cells
            }
        }

        int ans = 0;
        for (int i = 1; i < s.length(); i++) { // iterating over adjacent keys
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            String key = String.valueOf(curr) + String.valueOf(prev);
            ans += dis.get(key);
        }

        return ans;
    }
}
