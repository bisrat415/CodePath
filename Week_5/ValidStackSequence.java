// This is a solution for Q.946(Validate Stack Sequences)

import java.util.Stack;

public class ValidStackSequence {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));
         System.out.println(validateStackSequences2(pushed, popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        // Solution #1 
        int n = pushed.length;
        Stack<Integer> s = new Stack<>();
        int i = 0;
        int j = 0;
        s.push(pushed[i]);
        i++;
        while (i < n || j < n) {
            if (!s.isEmpty() && s.peek() == popped[j]) {
                s.pop();
                j++;
            } else {
                if (i < n) {
                    s.push(pushed[i]);
                    i++;
                } else {
                    j++;
                }
            }
        }
        return s.isEmpty();
        // Let n be the length of the arrays
        // Time Complexity: O(n) - we are visiting each element in both arrays once
        // Space Complexity: O(n) because of the stack
    }

    // Solution #2 (Greedy Method)
    // For each value, push it to the stack. Then, greedily pop values from the stack if they are the next values to pop.
    // At the end, we check if we have popped all the values successfully.
    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for (int num : pushed) {
            s.push(num);
            while(!s.isEmpty() && s.peek() == popped[j]) {
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
        // Let n be the length of the arrays
        // Time Complexity: O(n) - we are visiting each element in both arrays once
        // Space Complexity: O(n) because of the stack
    }
}
