class Solution {
    public int findTheLongestSubstring(String s) {
        Map<String, Integer> mp = new HashMap<>();
        int[] vowelCount = new int[5]; 
        String currentState = "00000"; 
        mp.put(currentState, -1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a')      vowelCount[0] = (vowelCount[0] + 1) % 2;
            else if (s.charAt(i) == 'e') vowelCount[1] = (vowelCount[1] + 1) % 2;
            else if (s.charAt(i) == 'i') vowelCount[2] = (vowelCount[2] + 1) % 2;
            else if (s.charAt(i) == 'o') vowelCount[3] = (vowelCount[3] + 1) % 2;
            else if (s.charAt(i) == 'u') vowelCount[4] = (vowelCount[4] + 1) % 2;
            currentState = "";
            for (int j = 0; j < 5; ++j) {
                currentState += vowelCount[j];
            }
            if (mp.containsKey(currentState)) {
                maxLength = Math.max(maxLength, i - mp.get(currentState));
            } else {
                mp.put(currentState, i);
            }
        }

        return maxLength;
    }
}
