package weekday03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            if(nums == null || nums.length == 0) return list;
            boolean[] visited = new boolean[nums.length];
            Arrays.sort(nums);
            helper(nums,visited,new ArrayList<>());
            return list;
        }

        public void helper(int[] nums,boolean[] visited,List<Integer> tmp){
            if(nums.length == tmp.size()){
                list.add(new ArrayList<>(tmp));
                return;
            }
            for(int i = 0; i < nums.length; i++){
                if(visited[i]) continue;
                if(i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
                visited[i] = true;
                tmp.add(nums[i]);
                helper(nums,visited,tmp);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);

            }
        }
    }
}
