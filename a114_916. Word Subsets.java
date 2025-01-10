
class Solution {
    void setMaxFreq(int[] freq_words2, int[] freq) {
        for (int i = 0; i < 26; ++i) {
            freq_words2[i] = Math.max(freq_words2[i], freq[i]);
        }
    }

    boolean isUniversal(int[] freq_word, int[] freq_words2) {
        for (int i = 0; i < 26; ++i) {
            if (freq_word[i] < freq_words2[i]) {
                return false;
            }
        }
        return true;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq_words2 = new int[26];
        for (String word : words2) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            setMaxFreq(freq_words2, freq);
        }

        List<String> universal_words = new ArrayList<>();
        for (String word : words1) {
            int[] freq_word = new int[26];
            for (char c : word.toCharArray()) {
                freq_word[c - 'a']++;
            }

            if (isUniversal(freq_word, freq_words2)) {
                universal_words.add(word);
            }
        }
        return universal_words;
    }
}
