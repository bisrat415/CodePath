// This is a solution for Q.110(Balanced Binary Tree) from leetcode

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BalancedTree {
    public static void main(String[] args) {
        
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

         return 1 + Math.max(height(root.left), height(root.right));
    }
    // Let n be the total number of nodes in the tree
    // Time complexity = O(nlog⁡n): see the explanation on the Editorial
    // My explanation: for every node, we are computing the height of that node. Computing the height of a node requires traversing all nodes under it (in a balanced tree this would be log N nodes, and in an unbalanced tree, it could be up to N nodes). But if the tree is completely skewed, the algorithm will return false on the first recursive call and we don't have to go any deep. So the worst case (traversing all the down) happens only when the tree is balanced in which case the height method takes O(logn) time. And we are calling that for each node. So the overall time complexity will be O(nlogn)
    // Space complexity = O(n) because the recursion call stack may contain all nodes if the tree is skewed
}
