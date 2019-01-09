import java.util.LinkedList;

public class Univalued_binary_tree_965 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static boolean isUnivalTree(TreeNode root) {

        int univalue = root.val;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);

        // retrieve nodes in tree by breath first search(bfs), using queue
        while(!list.isEmpty()){
            //get the bottom element in the queue
            TreeNode currNode = list.remove();

            //if value of current node is not the univalue, return false.
            if(currNode.val != univalue){
                return false;
            }

            //enqueue left and right if they are not null
            if(currNode.left != null){
                list.offer(currNode.left);
            }

            if(currNode.right != null){
                list.offer(currNode.right);
            }
        }

        return true;
    }

    public static void main(String[] args){
        TreeNode root1 = new Univalued_binary_tree_965(). new TreeNode(1);


        System.out.println(isUnivalTree(root1));
    }
}
