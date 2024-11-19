class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        long currWindowSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int i = 0; // left pointer
        //iterate right pointer
        for (int j = 0; j < nums.length; j++) {
            while (set.contains(nums[j])) {
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            currWindowSum += nums[j];
            set.add(nums[j]);
            if (j - i + 1 == k) {
                result = Math.max(result, currWindowSum);
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }

        return result;
    }
}
