package leecode.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 给定一个二叉树，返回它的 前序 遍历。
 */
public class BinaryTreePreorderTraversal2 {

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
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root != null){
                list.add(root.val);
                preorderTraversal(root.left);
                preorderTraversal(root.right);
            }
            return list;
        }
    }
}
