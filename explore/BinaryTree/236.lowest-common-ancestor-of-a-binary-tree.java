import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (47.23%)
 * Likes:    4607
 * Dislikes: 187
 * Total Accepted:    545.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of
 * itself).”
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [2, 10^5].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
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
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Iterator the tree by in-order
    // get the path of each node
    // compare two path and get the result node
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> path2 = new Stack<>();
        if (root == null) {
            return null;
        }
        path1.push(root);
        path2.push(root);
        getNodePath(root, p, path1);
        getNodePath(root, q, path2);
        return getLCA(path1, path2);
    }   
    // find the path of goal node
    public boolean getNodePath(TreeNode currentNode,TreeNode goalNode, Stack<TreeNode> path){
        if (currentNode == null) {
            return false;
        }
        if (currentNode.val == goalNode.val) {
            return true;
        }
        if (currentNode.left != null) {
            path.push(currentNode.left);
            if(getNodePath(currentNode.left, goalNode, path)){
                return true;
            }
        }
        if (currentNode.right != null) {
            path.push(currentNode.right);
            if(getNodePath(currentNode.right, goalNode, path)){
                return true;
            }
        }
        if (currentNode.left == null && currentNode.right == null) {
            // 回退到上一层
            path.pop();
            return false;
        }
        // 回退到上一层
        path.pop();
        return false;
    }

    // 从前向后 最后一个相同的节点 就是最小共同祖先
    private TreeNode getLCA(List<TreeNode> path1,List<TreeNode> path2){
        TreeNode result = null;
        Integer size = path1.size() < path2.size() ? path1.size():path2.size();
        for (int i = 0; i < size; i++) {
            if (path1.get(i).val != path2.get(i).val) {
                break;
            }
            result = path1.get(i);
        }
        return result;
    }
}
// @lc code=end

