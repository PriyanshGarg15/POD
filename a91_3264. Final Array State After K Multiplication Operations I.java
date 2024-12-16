import java.util.*;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }
        while (k-- > 0) {
            int[] curr = minHeap.poll();
            curr[0] *= multiplier;
            nums[curr[1]] = curr[0];
            minHeap.offer(curr); 
        }
        return nums;
    }
}
