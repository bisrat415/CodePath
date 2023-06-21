// This is Q.167(Two Sum II - Input Array Is Sorted) from leetcode
// Notice that the array should be sorted for both solutions to work

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 13;
        System.out.println(Arrays.toString(twoSumIterative(numbers, target)));

    }
    // Solution #1 (Iterative)
    public static int[] twoSumIterative(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }

        }
        return result;
        // Let n be the length of the array
        // Time Complexity: O(n) because in the worst case, we are visiting each element in the array once and all the operations in the while loop are constant time
        // Space Complexity: O(1) because we are only utilizing constant extra space
    }

    

}
