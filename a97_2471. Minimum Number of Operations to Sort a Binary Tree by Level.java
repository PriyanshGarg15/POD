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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.remove();
                list.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            ans+=minSwaps(list);
        }
        return ans;
    }

    public int minSwaps(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        Map<Integer, Integer> pos = new HashMap<>();
        for(int i=0; i<sorted.size(); i++) {
            pos.put(sorted.get(i), i);
        }
        int i=0, swaps=0;
        while(i<list.size()) {
            int index = pos.get(list.get(i));
            if(index==i) i+=1;
            else {
                int temp = list.get(i);
                list.set(i, list.get(index));
                list.set(index, temp);
                swaps+=1;
            }
        }
        return swaps;
    }
}
