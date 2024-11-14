public class Solution {

  List<List<Integer>> threeSum(int[] arr) {

    if (arr == null || arr.length < 3) return new ArrayList<>();

    // Sort the elements
    Arrays.sort(arr);
    HashSet<List<Integer>> result = new HashSet<>();

    // Now fix the first element and find the other two elements
    for (int i = 0; i < arr.length - 2; i++)
    {
      // Find other two elements using Two Sum approach
      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) {
        int sum = arr[i] + arr[left] + arr[right];

        if (sum == 0) {
          // Add the set, and move to find other triplets
          List<Integer> triplet = new ArrayList<>();
          triplet.add(arr[i]);
          triplet.add(arr[left]); 
          triplet.add(arr[right]);
          result.add(triplet);
          //result.add(Arrays.asList(arr[i], arr[left], arr[right]));
          left++;
          right--;
        } 
        else if (sum < 0)
          left++;
        else
          right--;
      }
    }
    return new ArrayList<>(result);
  }

}
// import java.util.*;
// class Solution {
//     public List<List<Integer>> threeSum(int[] arr) {
//         Arrays.sort(arr); // Sort the array to easily skip duplicates
//         Set<List<Integer>> result = new HashSet<>(); // Store unique triplets
        
//         int n = arr.length;
        
//         for (int i = 0; i < n - 2; i++) {
//             for (int j = i + 1; j < n - 1; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     if (arr[i] + arr[j] + arr[k] == 0) {
//                         List<Integer> triplet = new ArrayList<>();
//                         triplet.add(arr[i]);
//                         triplet.add(arr[j]);
//                         triplet.add(arr[k]);
//                         result.add(triplet);
//                     }
//                 }
//             }
//         }
        
//         return new ArrayList<>(result);
//     }
// }
