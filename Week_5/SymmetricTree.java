// This is a solution for Q.101(Symmetric Tree) from leetcode
// It uses both recursive and iterative (using queue) approach
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
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        
    }
    public static boolean isSymmetric(TreeNode root) {
        // Solution #1 (Iterative Approach)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null) {
                continue;
            }
            if (first == null || second == null) {
                return false;
            }
            if (first.val != second.val) {
                return false;
            }
            queue.add(first.left);
            queue.add(second.right);
            queue.add(first.right);
            queue.add(second.left);
        }
        return true;
        // Let n be the total number of nodes in a tree
        // Time Complexity = O(n): Because we perform a level order traversal on the entire input tree once
        // Space Complexity = O(m), where m is the maximum number of nodes at any level in the binary tree. In the worst case, the queue will contain all the nodes at the lowest level of the tree, which can be up to half of the total number of nodes in a perfectly balanced tree. Therefore, the space complexity is O(m), where m <= n/2. In the average case, where the tree is not perfectly balanced, the space complexity would be lower than O(n).
    }

    public static boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }
    public static boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
        // Let n be the total number of nodes in a tree
        // Time Complexity = O(n): Because we traverse the entire input tree once
        // Space Complexity = O(logn): The number of recursive calls on the call stack is bound by the height of the tree.
        // In the worst case (a skewed tree), a binary tree can be linear and the height will be O(n). But in this solution, as soon as we encounter a skewed tree, we are returning false because a skewed tree can not be symmetric. 
        // Therefore, the maximum depth of the recursive call stack would be determined by the height of a symmetric binary tree, which is log(n).  
        // So, the space complexity would indeed be O(log n) because that's the maximum depth of recursion you would experience
    }

}
