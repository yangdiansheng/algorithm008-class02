package leecode.week07;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    class Solution {
        char[][] _board = null;
        List<String> _result = new ArrayList<>();
        Trie root = new Trie();
        public List<String> findWords(char[][] board, String[] words) {
            for(String word:words) root.insert(word);
            this._board = board;
            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[row].length; col ++){
                    StringBuilder sb = new StringBuilder();
                    boolean[][] is_visit = new boolean[board.length][board[0].length];
                    backTracing(row,col,sb,is_visit);
                }
            }
            return _result;
        }

        private void backTracing(int row,int col,StringBuilder sb,boolean[][] is_visit){
            if(row > _board.length - 1 || row < 0 || col < 0 || col > _board[0].length - 1) return;
            if(is_visit[row][col]) return;
            sb.append(_board[row][col]);
            is_visit[row][col] = true;

            if(root.search(sb.toString())){
                if(!_result.contains(sb.toString())){
                    _result.add(sb.toString());
                }
            }

            if(root.startsWith(sb.toString())){
                backTracing(row + 1,col,sb,is_visit);
                backTracing(row - 1,col,sb,is_visit);
                backTracing(row,col +1,sb,is_visit);
                backTracing(row,col - 1,sb,is_visit);
            }
            sb.deleteCharAt(sb.length() -1);
            is_visit[row][col] = false;
            return;
        }
    }

    class Trie{
        private boolean isEnd = false;
        private Trie[] next =  new Trie[26];

        public Trie(){}

        public void insert(String word){
            if(word == null || word.length() == 0) return;
            Trie cur = this;
            char[] words = word.toCharArray();
            for(int i = 0; i < words.length; i++){
                int n = words[i] - 'a';
                if(cur.next[n] == null) cur.next[n] = new Trie();
                cur = cur.next[n];
            }
            cur.isEnd =  true;
        }

        public boolean search(String word){
            Trie node  = searcPrefix(word);
            return node != null && node.isEnd;
        }

        private Trie searcPrefix(String word){
            Trie node = this;
            char[] words = word.toCharArray();
            for(int i = 0; i < words.length; i++){
                node = node.next[words[i] - 'a'];
                if(node == null) return null;
            }
            return node;
        }

        public boolean startsWith(String prefix){
            Trie node = searcPrefix(prefix);
            return node != null;
        }
    }
}
