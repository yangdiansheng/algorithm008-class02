package leecode.week01;

import java.util.Stack;

public class TrappingRainWater2 {
    class Solution {
        public int trap(int[] height) {
            if(height.length < 3) return 0;
            Stack<Integer> stack = new Stack<>();
            int res =0;
            for(int i = 0; i < height.length; i++){
                while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                    int curIdx =  stack.pop();
                    //如果栈顶元素相等
                    while(!stack.isEmpty() && height[stack.peek()] == height[curIdx]) stack.pop();
                    if(!stack.isEmpty()){
                        int l = stack.peek();
                        int r = i;
                        int h = Math.min(height[r], height[l]) - height[curIdx];
                        res += (r - l - 1)*h;
                    }

                }
                stack.push(i);
            }
            return res;
        }
    }
}
