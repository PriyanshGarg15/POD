class Solution {
    public int getLucky(String s, int k) {
        StringBuilder l = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int p = s.charAt(i) - 'a' + 1;
            l.append(p);
        }

        String ans = l.toString();
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum = 0;

            for (int j = 0; j < ans.length(); j++) {
                sum += ans.charAt(j) - '0' ;
            }

            ans = Integer.toString(sum);
        }

        return sum;
    }
}
