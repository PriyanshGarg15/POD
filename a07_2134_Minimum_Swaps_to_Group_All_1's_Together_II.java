class Solution {
    public int minSwaps(int[] nums) {
        int windowSize = 0;
        for(int num : nums){
            windowSize+=num;
        }
        int curZeros = 0;
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 0) {
                curZeros++;
            }
        }
        int minZeros = curZeros;
        int n = nums.length;
        int start = 1;
        int end = windowSize;
        while (start < n) {
            if (nums[start - 1] == 0) {
                curZeros--;
            }
            if (nums[end % n] == 0) {
                curZeros++;
            }
            minZeros = Math.min(minZeros, curZeros);
            start++;
            end++;
        }
        return minZeros;
    }
}
