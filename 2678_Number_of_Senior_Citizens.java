class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (int i = 0; i < details.length; i++) {
            String ageString = details[i].substring(details[i].length() - 4, details[i].length() - 2);
            int age = Integer.parseInt(ageString);
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}
