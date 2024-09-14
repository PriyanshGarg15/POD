class Solution {
    public int longestSubarray(int[] nums) {
        int mxm = 0;
        for (int i = 0; i < nums.length; i++) {
            mxm = Math.max(mxm, nums[i]);
        }
        int cnt = 0;
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mxm) {
                cnt++;
            } else {
                cnt = 0;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
