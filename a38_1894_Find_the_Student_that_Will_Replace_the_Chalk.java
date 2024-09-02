class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;
        for (int c : chalk) {
            totalChalk += c;
        }
        k %= totalChalk;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        // This point should never be reached due to constraints but we will take as we had to return    something !
        return -1;
    }
}
