package leecode.week08;

import java.util.*;

public class NQueensII {
    class Solution {
        private boolean[] col;
        private boolean[] dia1;
        private boolean[] dia2;
        private int cnt;

        public int totalNQueens(int n) {
            if (n == 0) return cnt;
            col = new boolean[n];
            dia1 = new boolean[2 * n - 1];
            dia2 = new boolean[2 * n - 1];
            dfs(n, 0);
            return cnt;
        }

        private void dfs(int n, int row) {
            if (row == n) {
                cnt++;
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!col[i] && !dia1[row + i] && !dia2[row - i + n - 1]) {
                    col[i] = true;
                    dia1[row + i] = true;
                    dia2[row - i + n - 1] = true;

                    dfs(n, row + 1);

                    col[i] = false;
                    dia1[row + i] = false;
                    dia2[row - i + n - 1] = false;
                }
            }
        }
    }
}
