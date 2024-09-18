class Solution {
    public static String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        for (int i = 0; i < numStrs.length - 1; i++) {
            for (int j = i + 1; j < numStrs.length; j++) {
                String order1 = numStrs[i] + numStrs[j];
                String order2 = numStrs[j] + numStrs[i];
                if (order1.compareTo(order2) < 0) {
                    String temp = numStrs[i];
                    numStrs[i] = numStrs[j];
                    numStrs[j] = temp;
                }
            }
        }
        if (numStrs[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String numStr : numStrs) {
            result.append(numStr);
        }

        return result.toString();
    }
}
