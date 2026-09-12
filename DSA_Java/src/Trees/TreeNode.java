package Trees;

public class TreeNode {

    public int val;
    public static TreeNode root;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void preOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.print(node.val + "->");

        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + "->");
        inOrder(node.right);
    }

    public void postOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "->");
    }

    public static void main(String[] args) {

        TreeNode obj = new TreeNode();

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        root = one;

        System.out.println("Preorder:");
        obj.preOrder(root);
        System.out.println("null");

        System.out.println("Inorder:");
        obj.inOrder(root);
        System.out.println("null");

        System.out.println("Postorder:");
        obj.postOrder(root);
        System.out.println("null");
    }
}