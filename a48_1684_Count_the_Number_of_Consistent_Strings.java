// brutte force way either i should say using hashset but we are focusing to do using bit magic !
// class Solution {
//     public int countConsistentStrings(String allowed, String[] words) {
//         HashSet<Character> allowedSet = new HashSet<>();
//         for (char ch : allowed.toCharArray()) {
//             allowedSet.add(ch);
//         }
//         int count = 0;
//         for (String word : words) {
//             boolean allCharAllowed = true;
//             for (char ch : word.toCharArray()) {
//                 if (!allowedSet.contains(ch)) {
//                     allCharAllowed = false;
//                     break;
//                 }
//             }
//             if (allCharAllowed) {
//                 count++;
//             }
//         }

//         return count;
//     }
// }
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (char ch : allowed.toCharArray()) {
            mask = mask | 1 << (ch - 'a');
        }
        int count = 0;
        for (String word : words) {
            boolean allCharAllowed = true;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (((mask >> (ch - 'a')) & 1) == 0) {
                    allCharAllowed = false;
                    break;
                }
            }
            if (allCharAllowed) {
                count++;
            }
        }

        return count;
    }
}
