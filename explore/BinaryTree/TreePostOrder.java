import java.util.ArrayList;
import java.util.List;

/*
    递归方法 (recursion)   
    后序遍历: 
    first : deal with the left subtree
    second : deal with the right subtree
    last : deal with the current tree node
*/
public class TreePostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            result.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            result.addAll(postorderTraversal(root.right));
        }
        result.add(root.val);
        return result;
    }
}
