package Sept12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// import javax.swing.tree.TreeNode;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        q.offer(root);
        
        while (!q.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int n = q.size();
            for(int i =0;i<n;i++){
                TreeNode front = q.poll();
                row.add(front.val);
                if(front.left != null) q.offer(front.left);
                if(front.right != null) q.offer(front.right);
            }
            ans.add(row);
        }
        return ans;
    }
}
