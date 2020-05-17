package leecode.week04;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 127. 单词接龙
 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

 每次转换只能改变一个字母。
 转换过程中的中间单词必须是字典中的单词。
 说明:

 如果不存在这样的转换序列，返回 0。
 所有单词具有相同的长度。
 所有单词只由小写字母组成。
 字典中不存在重复的单词。
 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
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
