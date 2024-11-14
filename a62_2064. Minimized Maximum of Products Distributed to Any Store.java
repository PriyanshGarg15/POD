class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = 0;
        for (int q : quantities) high = Math.max(high, q);

        while (low < high) {
            int mid = low + (high - low) / 2;
            int requiredStores = 0;
            for (int q : quantities) {
                requiredStores += (q + mid - 1) / mid;
                // requiredStores += Math.ceil((double) q / mid);
            }
            if (requiredStores <= n) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
