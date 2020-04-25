package leecode.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 给定一个 N 叉树，返回其节点值的前序遍历。

 */


public class NAryTreePreorderTraversa2 {

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
        List<Integer> list = new ArrayList<>();
        public List<Integer> preorder(Node root) {
            helper(root);
            return list;
        }

        public void helper(Node root){
            if(root == null) return;
            list.add(root.val);
            for(Node node:root.children) helper(node);
        }
    }
}
