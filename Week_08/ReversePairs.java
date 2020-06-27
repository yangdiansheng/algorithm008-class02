package leecode.week08;

public class ReversePairs {
    class Solution {
        public int reversePairs(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            return mergeSort(nums,0,nums.length - 1);
        }

        public int mergeSort(int[] nums,int left,int right){
            if(right <= left) return 0;
            int mid = (left + right) >> 1;
            int count = mergeSort(nums,left, mid) + mergeSort(nums,mid + 1,right);

            int[] cache = new int[right - left + 1];
            int i = left;
            int j = mid + 1;
            int k = 0;
            int tmp = left;
            while(j <= right){
                while(tmp <= mid && nums[tmp] <= 2*(long)nums[j]) tmp++;
                while(i <= mid && nums[i] < nums[j]) cache[k++] = nums[i++];
                cache[k++] = nums[j++];
                count += mid - tmp + 1;
            }
            while(i <= mid) cache[k++] = nums[i++];
            System.arraycopy(cache,0,nums,left,right - left + 1);
            return count;
        }
    }
}
