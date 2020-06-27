package leecode.week07;

public class ImplementTriePrefixTree {
    class Trie {
        private boolean isEnd;
        private Trie[] next;

        /** Initialize your data structure here. */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(word == null || word.length() == 0) return;
            Trie cur = this;
            char[] words = word.toCharArray();
            for(int i= 0; i < words.length; i++){
                int n = words[i] - 'a';
                if(cur.next[n] == null) cur.next[n] = new Trie();
                cur = cur.next[n];
            }
            cur.isEnd =true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        private Trie searchPrefix(String word){
            Trie node =this;
            char[] words = word.toCharArray();
            for(int i = 0; i < words.length; i++){
                node  = node.next[words[i] - 'a'];
                if(node == null) return null;
            }
            return node;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
