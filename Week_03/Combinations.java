package weekday03;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            helper(1,n,k,new ArrayList<>());
            return list;
        }

        public void helper(int first,int n, int k,List<Integer> tmp){
            if(tmp.size() == k){
                list.add(new ArrayList<>(tmp));
                return;
            }
            for(int i = first; i <= n; i++){
                tmp.add(i);
                helper(i + 1,n,k,tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
