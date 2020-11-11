import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 递归：
 * 每次处理的是一层节点
 * 每层节点用队列保存
 * 当前层次节点（队列中）的左右子节点组成下一层节点
 */
public class TreeLevelOrder {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root ) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        nodeQueue.offer(root);
        levelOrderTravese(nodeQueue);        
        return result;
    }

    public void levelOrderTravese(Queue<TreeNode> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Queue<TreeNode> localNodeQueue = new LinkedList<>(queue);
        queue.clear();
        List<Integer> localLevel = new ArrayList<>();
        TreeNode curNode = localNodeQueue.poll();
        while (curNode != null) {
            localLevel.add(curNode.val);
            // assemble next level node-queue
            if (curNode.left!=null) {
                queue.offer(curNode.left);
            }
            if (curNode.right!=null) {
                queue.offer(curNode.right);
            }
            curNode = localNodeQueue.poll();
        }
        result.add(localLevel);
        // deal with next level
        levelOrderTravese(queue);
    }
}
