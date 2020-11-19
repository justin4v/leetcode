/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (40.21%)
 * Likes:    1916
 * Dislikes: 190
 * Total Accepted:    282.6K
 * Total Submissions: 700.8K
 * Testcase Example:  '[1,2,3,4,5,null,7]'
 *
 * Given a binary tree
 * 
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not
 * count as extra space for this problem.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should
 * populate each next pointer to point to its next right node, just like in
 * Figure B. The serialized output is in level order as connected by the next
 * pointers, with '#' signifying the end of each level.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the given tree is less than 6000.
 * -100 <= node.val <= 100
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // 子树之间的连接节点
    Node nextSubTree = new Node();
    // 下一个层级的开始节点
    Node nextLevelNode = new Node();
    public Node connect(Node root) {
        connectByLevel(root);
        return root;
    }
    // recursive by level
    public void connectByLevel(Node node){
        // 每次初始化为空
        nextLevelNode = null;
        nextSubTree = null;
        if (node == null || (node.left == null&&node.right == null&&node.next==null)) {
            return;
        }
        while(node != null){
            if (node.left == null&&node.right == null) {
                node = node.next;
                continue;
            }
            if (node.left != null) {
                if (nextLevelNode == null) {
                    // 更新下一层的开始节点
                    nextLevelNode = node.left;
                }
                if (nextSubTree != null) {
                    // 前一个节点的最后子树连接到本树
                    nextSubTree.next = node.left;
                    nextSubTree = node.left;
                }else{
                    nextSubTree = node.left;
                }
                if (node.right != null) {
                    node.left.next = node.right;
                    nextSubTree = node.right;
                }
            }else{
                if (node.right != null) {
                    if (nextLevelNode == null) {
                        // 更新下一层的开始节点
                        nextLevelNode = node.right;
                    }
                    if (nextSubTree != null) {
                        nextSubTree.next = node.right;
                        nextSubTree = node.right;
                    }else{
                        nextSubTree = node.right;
                    }
                }
            }
            node = node.next;
        }
       connectByLevel(nextLevelNode);
    }
}
// @lc code=end

