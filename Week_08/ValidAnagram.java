package leecode.week08;

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
