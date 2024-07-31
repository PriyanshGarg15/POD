class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        ArrayList<Character> ll = new ArrayList<>();
        for(int i=0;i<magazine.length();i++)
        {
            ll.add(magazine.charAt(i));
        }
        for(int i=0;i<ransomNote.length();i++)
        {
            if(!ll.contains(ransomNote.charAt(i)))
            {
                return false;
            }
            else
            {
                ll.remove((Character) ransomNote.charAt(i));
            }
        }
        return true;
   }
}