import java.util.*;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] vec = new int[nums[n-1] - nums[0] + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = nums[j] - nums[i];
                vec[d]++;
            }
        }
        
        for (int d = 0; d < vec.length; d++) {
            k -= vec[d];
            if (k <= 0) {
                return d;
            }
        }
        
        return -1;
    }
}
