import java.util.HashMap;
import java.util.Map;

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
    Map<Integer,Integer> position = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 && postorder.length ==0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            position.put(inorder[i], i);
        }
       return buildTree(inorder,0,inorder.length-1, postorder,0,postorder.length-1);
    }

    // 和用list实现相比 优点是 1.使用数组 随机存取为O(1) 效率最高 
    // 2. 将值与索引保存在map 中，不需要遍历查找
    // 3.直接将 index传入 不需要再次获取
    private TreeNode buildTree(int[] inOrder,int inStart, int inEnd,int[] postOrder,int postStart,int postEnd){
        if (inEnd < inStart && postEnd < postStart) {
            return null;
        }
        // find the root index in inorder
        int rootIndexOfIn = position.get(postOrder[postEnd]);
        // find the root
        TreeNode node = new TreeNode(postOrder[postEnd]);
        // find the left and right tree
        // All the index compine should be complete
        // 相当于在 rootIndexOfIn 把数组分成两半
        if (rootIndexOfIn >= 0) {
            node.left = buildTree(inOrder,inStart,rootIndexOfIn-1,postOrder,postStart,postStart+(rootIndexOfIn-1-inStart));
        }
        if (rootIndexOfIn >= 0 && rootIndexOfIn <= inOrder.length-1) {
            node.right = buildTree(inOrder,rootIndexOfIn+1,inEnd,postOrder,postStart+rootIndexOfIn-inStart,postEnd-1);
        }
        return node;
    }
}
// @lc code=end

