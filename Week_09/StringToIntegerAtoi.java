package leecode.week09;

public class StringToIntegerAtoi {
    class Solution {
        public int myAtoi(String str) {
            char[] chars = str.toCharArray();
            int n = str.length();
            int idx = 0;
            while(idx < n && chars[idx] == ' ') idx++;
            if(idx == n) return 0;
            boolean negtive = false;
            if(chars[idx] == '-'){
                negtive = true;
                idx++;
            }else if(chars[idx] == '+'){
                negtive = false;
                idx++;
            }else if(!Character.isDigit(chars[idx])){
                return 0;
            }
            int res = 0;
            while(idx < n && Character.isDigit(chars[idx])){
                int digit = chars[idx] - '0';
                if(res > (Integer.MAX_VALUE - digit)/10) return negtive? Integer.MIN_VALUE:Integer.MAX_VALUE;
                res = res * 10 + digit;
                idx++;
            }
            return negtive? -res:res;
        }
    }
}
