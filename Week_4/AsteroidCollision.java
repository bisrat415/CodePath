// This is Q.735(Asteroid Collision) from leetcode
// This solution uses a stack with a double loop to solve the problem

import java.util.*;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean flag = true;
            // (stack.peek() > 0 && asteroids[i] < 0) - this condition is implying that the
            // only case when the asteroids will collide is when the asteroid on the
            // left-hand side is moving towards the right, and the asteroid on the right
            // side is moving towards the left
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                int stackNum = stack.peek();
                // If the top asteroid in the stack is greater than abs(asteroids[i]), we don't
                // add asteroids[i] in the stack and we break from the while loop
                if (stackNum > Math.abs(asteroids[i])) {
                    flag = false;
                    break;
                    // If the top asteroid in the stack is less than abs(asteroids[i]), we pop it
                    // from the stack, and continue with the next asteroid in the stack
                } else if (stackNum < Math.abs(asteroids[i])) {
                    stack.pop();
                    // If the absolute values are equal, pop from the stack and don't add
                    // asteroid[i] in the stack. And also break from the while loop
                } else {
                    stack.pop();
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stack.push(asteroids[i]);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
        // Time Complexity: O(n) - Each asteroid can be added and removed from the stack
        // only once. Therefore, each asteroid can be processed only twice, first when
        // we iterate over it (add it to the stack or not) and then again while popping
        // it from the stack.
        // Space Complexity: O(n) in the worst case (all of the asteroids have the same
        // sign or all the positives are found to the right of all the negatives, or
        // shortly, when there is no collision) because we will be adding all the
        // asteroids in the stack
    }
}
