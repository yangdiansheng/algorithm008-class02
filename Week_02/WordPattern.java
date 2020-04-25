package leecode.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordPattern {
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] arr = str.split(" ");
            if(pattern.length() != arr.length){
                return false;
            }
            char[] chars = pattern.toCharArray();
            Map<Character,String> map = new HashMap<>();
            for(int i = 0; i < arr.length;i++){
                if(map.containsKey(chars[i])){
                    if(!map.get(chars[i]).equals(arr[i])){
                        return false;
                    }
                }else {
                    if(map.containsValue(arr[i])){
                        return false;
                    } else {
                        map.put(chars[i],arr[i]);
                    }
                }
            }
            return true;
        }
    }
}
