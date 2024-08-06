class Solution {
    public int minimumPushes(String word) {
        int[] frequencies = new int[26];
        char[] arr = word.toCharArray();
        for (char c :arr) {
            frequencies[c - 'a']++;
        }
        List<Integer> occ = new ArrayList<>();
        for (int freq : frequencies) {
            if (freq > 0) {
                occ.add(freq);
            }
        }
        Collections.sort(occ, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < occ.size(); i++) {
            if (i <= 7) {
                ans += occ.get(i) * 1;
            } else if (i > 7 && i <= 15) {
                ans += occ.get(i) * 2;
            } else if (i > 15 && i <= 23) {
                ans += occ.get(i) * 3;
            } else {
                ans += occ.get(i) * 4;
            }
        }
        return ans;
    }
}
