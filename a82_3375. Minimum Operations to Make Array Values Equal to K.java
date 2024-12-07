class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
        }

        int o = 0;

        while (true) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num > k) {
                    max = Math.max(max, num);
                }
            }

            if (max == Integer.MIN_VALUE) {
                break;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max) {
                    nums[i] = k;
                }
            }

            o++;
        }

        return o;
        
    }
}
