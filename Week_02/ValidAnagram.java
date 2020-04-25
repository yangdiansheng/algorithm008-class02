package leecode.week02;

/**
 * 242. 有效的字母异位词
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 */
public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] arr = new int[128];
            for(char c:s.toCharArray()) arr[c]++;
            for(char c:t.toCharArray()) arr[c]--;
            for(int n:arr){
                if(n != 0) return false;
            }
            return true;
        }
    }
}
