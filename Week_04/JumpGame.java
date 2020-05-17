package leecode.week04;

/**
 * 55. 跳跃游戏
 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个位置。
 */
public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int rightMost = 0;
            for(int i = 0; i < n; i++){
                if(i <= rightMost){
                    rightMost = Math.max(rightMost,i + nums[i]);
                    if(rightMost >= n - 1) return true;
                }
            }
            return false;
        }
    }
}
