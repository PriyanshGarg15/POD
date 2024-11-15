class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while (r > 0 && arr[r] >= arr[r - 1]) {
            r--;
        }

        int shortest = r; 

        while (l < r) {
            while (r < n && arr[l] > arr[r]) {
                r++;
            }

            shortest = Math.min(shortest, r - l - 1); 

            l++;
            if (arr[l] < arr[l - 1]) {
                break;
            }
        }
        return shortest;
    }
}
