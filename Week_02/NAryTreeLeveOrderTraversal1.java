package leecode.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

 例如，给定一个 3叉树 :
 */
public class NAryTreeLeveOrderTraversal1 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> list = new ArrayList<>();
            if(root == null) return list;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int count = queue.size();
                List<Integer> arr = new ArrayList<>();
                for(int i = 0; i < count; i++){
                    Node node = queue.poll();
                    arr.add(node.val);
                    if(node.children != null){
                        for(Node it:node.children) queue.offer(it);
                    }
                }
                list.add(arr);
            }
            return list;
        }
    }
}
