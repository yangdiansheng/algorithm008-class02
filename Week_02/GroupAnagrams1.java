package leecode.week02;

import java.util.*;

/**
 * 49. 字母异位词分组
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams1 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if(strs.length == 0) return new ArrayList<>();
            Map<String,List> ans = new HashMap<>();
            for(String s:strs){
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String key = String.valueOf(ca);
                if(!ans.containsKey(key)) ans.put(key, new ArrayList<>());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
}
