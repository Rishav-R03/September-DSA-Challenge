public class KthSmallestNum {
    public int kthSmall(TreeNode root, int k){
        List<Integer> arr = new ArrayList<>();
        dfs(root,arr);
        return arr.get(k-1);
    }
    public void dfs(TreeNode node,List<Integer> arr){
        if(node == null){
            return;
        }
        dfs(node.left,arr);
        arr.add(node.val);
        dfs(node.right);
    }
}
