class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }// parameterized constructor

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = null;
        this.right = null;
    }// parameterized constructor to override based on parameters
}

public class ValidBST {
    TreeNode root;

    public boolean isValid(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, Long l, Long r) {
        if (node == null) {
            return true;
        }
        if (!(l < node.data && node.data < r)) {
            return false;
        }
        return dfs(node.left, l, node.data) && dfs(node.right, node.data, r);
    }
    
}
