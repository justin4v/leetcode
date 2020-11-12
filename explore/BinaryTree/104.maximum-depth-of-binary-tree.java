/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (66.84%)
 * Likes:    3114
 * Dislikes: 83
 * Total Accepted:    942K
 * Total Submissions: 1.4M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its depth = 3.
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
    public int maxDepth(TreeNode root) {
        return maxTreeDepth(root, 0);
    }
    public int maxTreeDepth(TreeNode root,int level){
        if (root == null) {
            return level;
        }
        if (root.left == null) {
            if (root.right == null) {
                return level+1;
            }else{
                return maxTreeDepth(root.right, level+1);
            }
        }else{
            if (root.right == null) {
                return maxTreeDepth(root.left, level+1);
            }else{
                int maximumLeft =  maxTreeDepth(root.left, level+1);
                int maximumRight = maxTreeDepth(root.right, level+1);
                return maximumLeft>maximumRight?maximumLeft:maximumRight;
            }
        }
    }
}
// @lc code=end

