package leecode.week09;

public class IsomorphicStrings {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            char[] char1 = s.toCharArray();
            char[] char2 = t.toCharArray();
            int len = s.length();
            for(int i = 0; i < len;i++){
                if(s.indexOf(char1[i]) != t.indexOf(char2[i])){
                    return false;
                }
            }
            return true;
        }
    }
}
