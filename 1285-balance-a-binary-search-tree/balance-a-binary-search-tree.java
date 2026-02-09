/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root,nums);
        return buildBalancedBST(nums, 0, nums.size() - 1);
    }
    public void inorder(TreeNode root, List<Integer> nums){
        if(root==null) return;
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
    public TreeNode buildBalancedBST(List<Integer> nums, int start, int end){
        if(start>end) return null;
        int mid = (start + end)/2;

        TreeNode root = new TreeNode(nums.get(mid));

        root.left = buildBalancedBST(nums,start,mid-1);
        root.right = buildBalancedBST(nums,mid+1,end);

        return root;

    }
}