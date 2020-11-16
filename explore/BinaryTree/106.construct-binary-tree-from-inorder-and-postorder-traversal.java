import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (48.44%)
 * Likes:    2186
 * Dislikes: 41
 * Total Accepted:    263.3K
 * Total Submissions: 543.4K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 && postorder.length ==0) {
            return null;
        }
        List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> post = Arrays.stream(postorder).boxed().collect(Collectors.toList());
        return buildTree(in, post);
    }
    
    private TreeNode buildTree(List<Integer> inOrder,List<Integer> postOrder){
        if (inOrder.isEmpty() && postOrder.isEmpty()) {
            return null;
        }
        // find the root index in inorder
        int rootIndexIn = inOrder.indexOf(postOrder.get(postOrder.size()-1));
        // find the root
        TreeNode node = new TreeNode(inOrder.get(rootIndexIn));
        // find the left and right tree
        if (rootIndexIn >= 0) {
            node.left = buildTree(inOrder.subList(0, rootIndexIn),postOrder.subList(0, rootIndexIn));
        }
        if (rootIndexIn >= 0 && rootIndexIn < inOrder.size()-1) {
            node.right = buildTree(inOrder.subList(rootIndexIn+1,inOrder.size()),postOrder.subList(rootIndexIn,postOrder.size()-1));
        }
        return node;
    }
}
// @lc code=end

