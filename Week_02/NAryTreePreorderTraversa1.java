package leecode.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 给定一个 N 叉树，返回其节点值的前序遍历。

 */


public class NAryTreePreorderTraversa1 {

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
        public List<Integer> preorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node node = stack.pop();
                list.add(node.val);
                if(node.children != null) {
                    for(int i = node.children.size() - 1; i >= 0; i--){
                        stack.push(node.children.get(i));
                    }
                }
            }
            return list;
        }
    }
}
