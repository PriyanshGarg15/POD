class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates
        fun(candidates, target, new ArrayList<>(), 0, ans);
        return ans;
    }

    public void fun(int[] candidates, int target, List<Integer> ll, int idx, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                // Skip duplicates
                continue;
            }
            if(target>=candidates[i])
            {
                ll.add(candidates[i]);
                fun(candidates,target-candidates[i],ll,i+1,ans);
                ll.remove(ll.size()-1);
            }
        }
    }
}
