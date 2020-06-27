package leecode.week09;

public class ReverseWordsInAStringIII {
    class Solution {
        public String reverseWords(String s) {
            String[] ss = s.split(" ");
            StringBuilder builder = new StringBuilder();
            for(String it:ss){
                builder.append(reverseWord(it));
                builder.append(" ");
            }
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }

        private String reverseWord(String s){
            char[] chars = s.toCharArray();
            int left = 0;
            int right = s.length() - 1;
            while(left < right){
                exchange(chars,left,right);
                left++;
                right--;
            }
            return String.valueOf(chars);
        }

        private void exchange(char[] chars,int left,int right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
    }
}

