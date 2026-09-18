package Trees;

public class BinarySearchTree {

    static TreeNode root;

    public static void insert(int val){
        root = insertRecord(root,val);
    }

    public static TreeNode insertRecord(TreeNode node, int val){
        if(node == null){
            node = new TreeNode(val);
            return node;
        }

        if(val <= node.val){
            node.left = insertRecord(node.left, val);
        }else{
            node.right = insertRecord(node.right, val);
        }

        return node;
    }

    public static boolean search(TreeNode root, int val){
        if(root == null) return false;

        if(root.val == val){
            return true;
        }else if( val < root.val){
            return search(root.left, val);
        }else{
            return search(root.right, val);
        }

    }

    public static void main(String[] args){
        Integer[] arr = {
                50, 30, 70, 20, 40, 60, 80
        };

        root = TreeNode.buildTree(arr);

        System.out.println("Is the value in the tree :- " + search(root,50));
        System.out.println("Is the value in the tree :- " + search(root,150));
    }
}
