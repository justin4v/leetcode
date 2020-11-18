import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (50.34%)
 * Likes:    4213
 * Dislikes: 112
 * Total Accepted:    418.1K
 * Total Submissions: 829.7K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,Integer> position = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length ==0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            position.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode buildTree(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd){
        if (preEnd < preStart && inEnd < inStart) {
            return null;
        }
        int rootIndexOfIn = position.get(preOrder[preStart]);
        TreeNode node = new TreeNode(preOrder[preStart]);
        if (rootIndexOfIn >= 0) {
            node.left = buildTree(preOrder, preStart+1,preStart+rootIndexOfIn-inStart, inOrder, inStart, rootIndexOfIn-1);
        }
        if (rootIndexOfIn >=0 && rootIndexOfIn <= inEnd) {
            node.right = buildTree(preOrder, preStart+rootIndexOfIn-inStart+1, preEnd, inOrder, rootIndexOfIn+1,inEnd);
        }
        return node;
    }

}
// @lc code=end

