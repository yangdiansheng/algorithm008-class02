package leecode.week08;

public class ReverseBits {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res  = 0;
            int position = 32;
            while(position > 0){
                res <<= 1;
                res += n & 1;
                n >>= 1;
                position--;
            }
            return res;
        }
    }
}
