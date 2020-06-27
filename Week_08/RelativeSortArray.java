package leecode.week08;

public class RelativeSortArray {
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] count = new int[1001];
            for(int item:arr1) count[item]++;
            int position = 0;
            for(int item:arr2) {
                while(count[item]-- > 0){
                    arr1[position++] = item;
                }
            }
            for(int item = 0;item < count.length; item++){
                while(count[item]-- > 0){
                    arr1[position++] = item;
                }
            }
            return arr1;
        }
    }
}
