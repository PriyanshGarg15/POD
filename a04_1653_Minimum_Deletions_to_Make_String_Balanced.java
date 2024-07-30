class Solution {
    public int minimumDeletions(String str) {
        int c=0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!st.isEmpty() && st.peek()=='b' && ch=='a'){
                c++;
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
       return c; 
    }
}
