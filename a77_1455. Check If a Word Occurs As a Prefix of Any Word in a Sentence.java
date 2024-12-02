class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
       int ans =-1;
       int n = searchWord.length();

            String arr[] = sentence.split(" ");
            for(int i=0;i<arr.length;i++){
                if(arr[i].length()>=n){
                    String temp = arr[i].substring(0,n);
                    System.out.println(temp);
                    if(temp.equals(searchWord)){
                        return i+1;
                    }
                }

            }
        
      
        return ans;
        
    }
}
