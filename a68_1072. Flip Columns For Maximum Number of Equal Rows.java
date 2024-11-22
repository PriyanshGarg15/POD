class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> relativeFreq = new HashMap<>();

        for (int[] row : matrix) {
            int first = row[0];
            StringBuilder curr = new StringBuilder();

            for (int ele : row) {
                if (ele == first)
                    curr.append('0');
                else
                    curr.append('1');
            }
            
            String key = curr.toString();
            relativeFreq.put(key, relativeFreq.getOrDefault(key, 0) + 1);
        }

        int maxFreq = 0;
        for (int freq : relativeFreq.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        return maxFreq;
    }
}
