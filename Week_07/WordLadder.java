package leecode.week07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(wordList == null || !wordList.contains(endWord)) return 0;
            boolean[] visited = new boolean[wordList.size()];
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            int depth = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                depth++;
                for(int i = 0; i < size; i++){
                    String poll = queue.poll();
                    for(int j = 0; j < wordList.size(); j++){
                        if(visited[j]) continue;
                        if(!canCover(poll,wordList.get(j))) continue;
                        if(wordList.get(j).equals(endWord)) return depth + 1;
                        visited[j] = true;
                        queue.add(wordList.get(j));
                    }
                }
            }
            return 0;
        }

        private boolean canCover(String poll,String s){
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                if(poll.charAt(i) != s.charAt(i)){
                    count++;
                    if(count > 1) return false;
                }
            }
            return count == 1;
        }
    }
}
