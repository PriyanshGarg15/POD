import java.util.ArrayList;
import java.util.List;

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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        fun(root, ll);
        return ll;
    }

    public static void fun(TreeNode root, List<Integer> ll) {
        if (root == null) {
            return;
        }
        
        ll.add(root.val);
        fun(root.left, ll);
        fun(root.right, ll);
    }
}
