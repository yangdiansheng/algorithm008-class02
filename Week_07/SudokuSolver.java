package leecode.week07;

public class SudokuSolver {
    class Solution {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];

        public void solveSudoku(char[][] board) {

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    int num = board[i][j] - '0';
                    if(1 <= num && num <= 9){
                        rowUsed[i][num] = true;
                        colUsed[j][num] = true;
                        boxUsed[i/3][j/3][num] = true;
                    }
                }
            }
            dfs(board,0,0);
        }

        private boolean dfs(char[][] board,int row,int col){
            if(col == board[0].length){
                col = 0;
                row++;
                if(row == board.length){
                    return true;
                }
            }
            if(board[row][col] == '.'){
                for(int num = 1;num <= 9; num++){
                    boolean canUsed = !(rowUsed[row][num] || colUsed[col][num]|| boxUsed[row/3][col/3][num]);
                    if(canUsed){
                        rowUsed[row][num] = true;
                        colUsed[col][num] = true;
                        boxUsed[row/3][col/3][num] = true;

                        board[row][col] = (char)('0' + num);
                        if(dfs(board,row,col + 1)) return true;

                        board[row][col] = '.';

                        rowUsed[row][num] = false;
                        colUsed[col][num] = false;
                        boxUsed[row/3][col/3][num] = false;
                    }
                }
            } else {
                return dfs(board,row,col+1);
            }
            return false;
        }
    }
}
