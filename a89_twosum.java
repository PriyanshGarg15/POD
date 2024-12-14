// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//          // Create a HashMap
//         Map<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < nums.length; i++) {

//             // Get the complement using the target value
//             int complement = target - nums[i];

//             // Search the hashmap for complement, if found, we got our pair
//             if (map.containsKey(complement)) 
//             {
//                 int[] ans = {map.get(complement), i};
//                 return ans;
//             }

//             // Put the element in hashmap for subsequent searches.
//             map.put(nums[i], i);
//         }
//         return null;
        
//     }
// }
// -----------------------------------------------------
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     int[] ans = {i, j};
//                     return ans;
//                 }
//             }
//         }
//         return null; // Return null if no solution is found
        
//     }
// }
// -------------------------------------------------------
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] sortedArray = Arrays.copyOf(nums, n); // Create a new array and copy elements
        Arrays.sort(sortedArray); // Sort the new array

        int[] ans = new int[2];

        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (sortedArray[i] + sortedArray[j] == target) {
                ans[0] = sortedArray[i];
                ans[1] = sortedArray[j];
                break;
            } else if (target < sortedArray[i] + sortedArray[j]) {
                j--;
            } else {
                i++;
            }
        }

        int[] indices = new int[2];
        boolean foundFirst = false;
        boolean foundSecond = false;

        for (int k = 0; k < n; k++) {
            if (!foundFirst && nums[k] == ans[0]) {
                indices[0] = k;
                foundFirst = true;
            } else if (!foundSecond && nums[k] == ans[1]) {
                indices[1] = k;
                foundSecond = true;
            }

            if (foundFirst && foundSecond) {
                break;
            }
        }

        return indices;
    }
}
