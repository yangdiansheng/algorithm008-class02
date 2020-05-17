package leecode.week04;

import java.util.*;

/**
 * 126. 单词接龙 II
 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

 每次转换只能改变一个字母。
 转换过程中的中间单词必须是字典中的单词。
 说明:

 如果不存在这样的转换序列，返回一个空列表。
 所有单词具有相同的长度。
 所有单词只由小写字母组成。
 字典中不存在重复的单词。
 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class WordLadderII {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            Set<String> distSet = new HashSet<>(wordList);
            if(!distSet.contains(endWord)) return res;
            Set<String> visited = new HashSet<>();
            Queue<List<String>> queue = new LinkedList<>();
            List<String> list = new ArrayList<>(Arrays.asList(beginWord));
            queue.add(list);
            visited.add(beginWord);
            boolean flag = false;
            while(!queue.isEmpty() && !flag){
                int size = queue.size();
                Set<String> subVisited = new HashSet<>();
                for(int i = 0; i < size; i++){
                    List<String> path = queue.poll();
                    String word = path.get(path.size() - 1);
                    char[] chars = word.toCharArray();
                    for(int j = 0; j < chars.length; j++){
                        char temp = chars[j];
                        for(char ch = 'a'; ch <= 'z'; ch++){
                            chars[j] = ch;
                            if(temp == ch) continue;
                            String str = new String(chars);
                            if(distSet.contains(str) && !visited.contains(str)){
                                List<String> pathList = new ArrayList<>(path);
                                pathList.add(str);
                                if(str.endsWith(endWord)){
                                    flag = true;
                                    res.add(pathList);
                                }
                                queue.add(pathList);
                                subVisited.add(str);
                            }
                        }
                        chars[j] = temp;
                    }
                }
                visited.addAll(subVisited);
            }
            return res;
        }
    }
}
