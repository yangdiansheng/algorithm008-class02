package weekday03;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            boolean[] visited = new boolean[nums.length];
            helper(nums,visited,new ArrayList<>());
            return list;
        }

        public void helper(int[] nums,boolean[] visited,List<Integer> tmp){
            if(nums.length == tmp.size()){
                list.add(new ArrayList<>(tmp));
                return;
            }
            for(int i = 0; i < nums.length;i++){
                if(visited[i]) continue;
                else {
                    visited[i] = true;
                    tmp.add(nums[i]);
                    helper(nums,visited,tmp);
                    visited[i] = false;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
