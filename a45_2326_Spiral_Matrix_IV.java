/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        ListNode current = head;
        
        while (top <= bottom && left <= right) {
            // Traverse Right
            for (int j = left; j <= right; j++) {
                if (current != null) {
                    matrix[top][j] = current.val;
                    current = current.next;
                } else {
                    matrix[top][j] = -1;
                }
            }
            top++;
            
            // Traverse Down
            for (int i = top; i <= bottom; i++) {
                if (current != null) {
                    matrix[i][right] = current.val;
                    current = current.next;
                } else {
                    matrix[i][right] = -1;
                }
            }
            right--;
            
            if (top <= bottom) {
                // Traverse Left
                for (int j = right; j >= left; j--) {
                    if (current != null) {
                        matrix[bottom][j] = current.val;
                        current = current.next;
                    } else {
                        matrix[bottom][j] = -1;
                    }
                }
                bottom--;
            }
            
            if (left <= right) {
                // Traverse Up
                for (int i = bottom; i >= top; i--) {
                    if (current != null) {
                        matrix[i][left] = current.val;
                        current = current.next;
                    } else {
                        matrix[i][left] = -1;
                    }
                }
                left++;
            }
        }
        
        return matrix;
    }
}
