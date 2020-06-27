package leecode.week07;

public class ValidSudoku {
    class Solution {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        public boolean isValidSudoku(char[][] board) {
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] != '.'){
                        int num = board[i][j] - '0';
                        if(rowUsed[i][num] ||colUsed[j][num] ||boxUsed[i/3][j/3][num]) return false;
                        else {
                            rowUsed[i][num] = true;
                            colUsed[j][num] = true;
                            boxUsed[i/3][j/3][num]= true;
                        }
                    }
                }
            }
            return true;
        }
    }
}
