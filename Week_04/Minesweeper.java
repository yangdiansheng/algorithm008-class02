package leecode.week04;

/**
 * 529. 扫雷游戏
 让我们一起来玩扫雷游戏！

 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。

 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：

 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 */
public class Minesweeper {
    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            int m = board.length;
            int n = board[0].length;
            int row = click[0];
            int col = click[1];
            if(board[row][col] == 'M') board[row][col] = 'X';
            else {
                int count = 0;
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){
                        if(i == 0 && j == 0) continue;
                        int r = row + i;
                        int c = col + j;
                        if(r < 0 || c < 0 || r >= m || c >= n) continue;
                        if(board[r][c] == 'M' || board[r][c] == 'X') count++;
                    }
                }
                if(count > 0) board[row][col] = (char)(count + '0');
                else {
                    board[row][col] = 'B';
                    for(int i = -1; i < 2; i++){
                        for(int j = -1; j < 2; j++){
                            if(i == 0 && j == 0) continue;
                            int r = row + i;
                            int c = col + j;
                            if(r < 0 || c < 0 || r >= m || c >= n) continue;
                            if(board[r][c] == 'E') updateBoard(board,new int[]{r,c});
                        }
                    }
                }

            }
            return board;
        }
    }
}
