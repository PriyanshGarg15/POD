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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) 
        {
            int size = nodeQueue.size();
            TreeNode rightmostNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = nodeQueue.poll();
                rightmostNode = currentNode;

                if (currentNode.left != null) {
                    nodeQueue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right);
                }
            }
            rightView.add(rightmostNode.val);
        }

        return rightView;
    }
}
