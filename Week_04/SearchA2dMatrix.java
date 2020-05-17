package leecode.week04;

/**
 * 74. 搜索二维矩阵
 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

 每行中的整数从左到右按升序排列。
 每行的第一个整数大于前一行的最后一个整数。
 */
public class SearchA2dMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int row = matrix.length;
            int col = matrix[0].length;
            int left = 0;
            int right = row* col -1;
            int mid = 0;
            while(left < right){
                mid = left + (right - left)/2;
                if(matrix[mid/col][mid%col] < target) left = mid + 1;
                else right = mid;
            }
            if(matrix[left/col][left%col] != target) return false;
            return true;
        }
    }
}
