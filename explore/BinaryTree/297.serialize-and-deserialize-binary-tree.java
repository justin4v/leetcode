import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (48.69%)
 * Likes:    3691
 * Dislikes: 176
 * Total Accepted:    385.2K
 * Total Submissions: 787.2K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Clarification: The input/output format is the same as how LeetCode
 * serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [1,2]
 * Output: [1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -1000 <= Node.val <= 1000
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
public class Codec {

     // Encodes a tree to a single string.
     public String serialize(TreeNode root) {
        Queue<String> serializeVal = new LinkedList<>();
        serializeTree(root,serializeVal);
        return String.join(",", serializeVal);
    }

     // Decodes your encoded data to tree.
     public TreeNode deserialize(String data) {
        Queue<String> valueQueue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(valueQueue);
    }

    private TreeNode buildTree(Queue<String> valueList){
        TreeNode node = null;
        if (valueList == null || valueList.isEmpty()) {
            return node;
        }
        Integer data = null;
        String strData = valueList.poll();
        if (!strData.equals("null")) {
            data = Integer.valueOf(strData);
        }       
        // 注意理解这里：从最上层看，构建根节点以及其左右子树，就完成了树的构建
        if (data != null) {
            node = new TreeNode(data);
            node.left = buildTree(valueList);
            node.right = buildTree(valueList);
        }
        return node;
    }

    // 前序遍历
    private void serializeTree(TreeNode node,Queue<String> valQueue){
       if (node == null) {
            valQueue.offer(null);
            return;
       }
       valQueue.offer(String.valueOf(node.val));
       if (node.left == null && node.right == null) {
            valQueue.offer(null);
            valQueue.offer(null);
            return;
        }
        serializeTree(node.left,valQueue);
        serializeTree(node.right,valQueue);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

