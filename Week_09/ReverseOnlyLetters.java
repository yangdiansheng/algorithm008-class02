package leecode.week09;

public class ReverseOnlyLetters {
    class Solution {
        public String reverseOnlyLetters(String S) {
            char[] chars = S.toCharArray();
            int l = 0;
            int r = chars.length - 1;
            while(l < r){
                while((l < r) && !isLetter(chars[l])){
                    l++;
                }
                while((l < r) &&  !isLetter(chars[r])){
                    r--;
                }
                if(l < r){
                    char c = chars[l];
                    chars[l] = chars[r];
                    chars[r] = c;
                }
                l++;
                r--;
            }
            return String.valueOf(chars);
        }

        public boolean isLetter(char c){
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
    }
}
