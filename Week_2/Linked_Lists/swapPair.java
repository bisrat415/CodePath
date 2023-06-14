// This is a question from leetcode

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class swapPair {
    public static void main(String[] args) {
        
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        head = p2;
        while (p1 != null && p1.next != null) {
            p1.next = p2.next;
            p2.next = p1;
            if (prev != null) {
                prev.next = p2;
            }
            prev = p1;
            p1 = p1.next;
            if (p1 != null) {
                p2 = p1.next;
            } 
        }
        return head;
        // Time Complexity: O(n) - the while loop processes two nodes at a time
        // And in each iteration of the while loop, it performs constant-time operations to swap the pair of nodes and update the pointers.
        // So the complexity is O(n / 2) which becomes O(n)
        // Space Complexity: O(1) because we only used constant extra space
    }

}
