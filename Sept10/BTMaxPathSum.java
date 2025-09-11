package Sept10;

public class BTMaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int sumRoot = getSum(root);
        return Math.max(sumRoot, maxSum);
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, getSum(root.left));
        int rightSum = Math.max(0, getSum(root.right));
        maxSum = Math.max(leftSum + rightSum + root.val, maxSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}
