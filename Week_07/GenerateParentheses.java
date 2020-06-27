package leecode.week07;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    class Solution {
        List<String> list = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            dfs(0,0,n,"");
            return list;
        }

        public void dfs(int left,int right,int n,String s){
            if(left == n && right == n){
                list.add(s);
                return;
            }
            if(left < n) dfs(left + 1,right,n,s + "(");
            if(right < left) dfs(left,right + 1,n, s + ")");
        }
    }
}
