import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (47.53%)
 * Likes:    5004
 * Dislikes: 119
 * Total Accepted:    753.8K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3] is not:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Follow up: Solve it both recursively and iteratively.
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
    
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left!=null && root.right != null) {
            nodes.add(root.left);
            nodes.add(root.right);
        }else{
            return false;
        }
        return isLevelSymmetric(nodes);
    }

    private boolean isLevelSymmetric(List<TreeNode> nodeList){
        List<TreeNode> localNodes = new ArrayList<>(2*nodeList.size());
        if (nodeList.isEmpty()) {
            return true;
        }
        if ((nodeList.size() % 2) != 0) {
            return false;
        }
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i) == null && nodeList.get(nodeList.size()-1-i) == null) {
                continue;
            }else{
                if (nodeList.get(i) == null || nodeList.get(nodeList.size()-1-i) == null) {
                    return false;
                }
            }
            if (i < nodeList.size()/2 && (nodeList.get(i).val != nodeList.get(nodeList.size()-1-i).val)) {
                return false;
            }
            if (nodeList.get(i).left != null){
                localNodes.add(nodeList.get(i).left); 
            }else{
                localNodes.add(null);
            }
            if (nodeList.get(i).right != null){
                localNodes.add(nodeList.get(i).right);
            }else{
                localNodes.add(null);
            }
        }
        return isLevelSymmetric(localNodes);
    }
}
// @lc code=end

