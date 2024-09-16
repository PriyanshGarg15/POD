class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();
        for (String time : timePoints) {
            String[] split = time.split(":");
            int hours = Integer.parseInt(split[0]);
            int minutes = Integer.parseInt(split[1]);
            minutesList.add(hours * 60 + minutes);
        }
        Collections.sort(minutesList);
        int minDifference = (24*60 - (minutesList.get(minutesList.size() - 1))) + minutesList.get(0);
        for (int i = 1; i < minutesList.size(); i++) {
            int diff = minutesList.get(i) - minutesList.get(i - 1);
            minDifference = Math.min(minDifference, diff);
        }
        
        return minDifference;
    }
}
