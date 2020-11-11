import java.util.ArrayList;
import java.util.List;

/*
    递归方法 (recursion)   
    先序遍历: 
    first : deal with the current tree node 
    second : deal with the left subtree 
    last : deal with the right subtree
*/
public class TreePreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        if(root.left != null){
            result.addAll(preorderTraversal(root.left));
        }
        if(root.right != null){
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }
}
