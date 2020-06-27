package leecode.week09;

public class FirstUniqueCharacterInAString {
    class Solution {
        public int firstUniqChar(String s) {
            int[] letters = new int[128];
            for(char c:s.toCharArray()){
                letters[c]++;
            }
            for(int i = 0; i < s.length(); i++){
                if(letters[s.charAt(i)] == 1){
                    return i;
                }
            }
            return -1;
        }
    }
}
