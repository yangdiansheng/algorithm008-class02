package leecode.week04;

/**
 * 153. 寻找旋转排序数组中的最小值
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 请找出其中最小的元素。

 你可以假设数组中不存在重复元素。
 */
public class FindMinimumInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while(l < r){
                int mid = l + (r - l)/2;
                if(nums[mid] < nums[r]) r = mid;
                else l = mid + 1;
            }
            return nums[l];
        }
    }
}
