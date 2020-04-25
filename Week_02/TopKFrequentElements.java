package leecode.week02;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class TopKFrequentElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int n:nums) map.put(n, map.getOrDefault(n,0)+1);
            PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
            for(Map.Entry<Integer,Integer> entry: map.entrySet()) maxHeap.add(entry);
            List<Integer> list = new ArrayList();
            while(list.size() < k){
                Map.Entry<Integer,Integer> entry = maxHeap.poll();
                list.add(entry.getKey());
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
