package leecode.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class BinaryTreeInorderTraversal2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            helper(root);
            return list;
        }

        public void helper(TreeNode root){
            if(root != null){
                helper(root.left);
                list.add(root.val);
                helper(root.right);
            }
        }
    }
}
