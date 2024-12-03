class Solution {
    public String addSpaces(String s, int[] spaces) {
        int m = s.length();
        int n = spaces.length;

        StringBuilder res = new StringBuilder();
        int first = 0;
        int second = 0;

        while (first < m) {
            if (second < n && first == spaces[second]) {
                res.append(' ');
                second++;
            }
            res.append(s.charAt(first));
            first++;
        }
        return res.toString();
    }
}
