// This is a question from leetcode

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class DeleteNode {
    public static void main(String[] args) {


    }

    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        temp.next = null;
    }
    // Time Complexity: O(1) because all the operations are constant time (don' t depend on the input size)
    // Space Complexity: O(1) because we only utilized constant extra space 
}
