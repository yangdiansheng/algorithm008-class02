package leecode.week04;

/**
 * 45. 跳跃游戏 II
 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            int jump = 0;
            int curEnd =0;
            int curFarthest = 0;
            for(int i = 0; i < nums.length - 1; i++){
                curFarthest = Math.max(curFarthest, i+nums[i]);
                if(i == curEnd){
                    jump++;
                    curEnd = curFarthest;
                }
            }
            return jump;
        }
    }
}
