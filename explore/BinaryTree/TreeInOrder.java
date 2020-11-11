import java.util.ArrayList;
import java.util.List;

/*
    递归方法 (recursion)   
    中序遍历: 
    first : deal with the left subtree
    second : deal with the current tree node 
    last : deal with the right subtree
*/

public class TreeInOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(root.left != null){
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if(root.right != null){
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}