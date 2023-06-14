// This is a question from leetcode

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RotateList {
    public static void main(String[] args) {
        
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        temp.next = head;
        int tailIndex = (length - (k % length)) - 1; // let's use zero-based indexing
        ListNode tail = head;
        for (int i = 0; i < tailIndex; i++) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
        // Time Complexity: O(n) - finding the length of the linked list takes O(n) and updating the tail takes O(n) in the worst case
        // Space Complexity: O(1) because we only used constant extra space
        
    }


}
