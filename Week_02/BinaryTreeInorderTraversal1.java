package leecode.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class BinaryTreeInorderTraversal1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
            return list;
        }
    }
}
