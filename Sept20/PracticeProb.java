package Sept20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(TreeNode left, TreeNode right, int data) {
        this.data = data;
        left = null;
        right = null;
    }

    // creating a treenode
    public TreeNode createTree(TreeNode root, int data) {
        TreeNode node = new TreeNode(data);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left == null) {
                cur.left = node;
                return root;
            } else {
                q.add(cur.left);
            }
            if (cur.right == null) {
                cur.right = node;
                return root;
            } else {
                q.add(cur.right);
            }
        }
        return root;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){return new ArrayList<>();}
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int curlev =0;
        while (!q.isEmpty()) {
            int len = q.size();
            ArrayList<Integer> nodes = new ArrayList<>();
            nodes.add(new ArrayList<>());
            for (int i = 0; i < len; i++) {
                nodes.add()
            }
        }
    }
}

public class PracticeProb {
    public static void main(String[] args) {

    }
}
