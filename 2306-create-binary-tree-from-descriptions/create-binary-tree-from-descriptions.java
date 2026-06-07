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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> mp = new HashMap<>();
        Set<Integer> st = new HashSet<>();

        for(int[] arr: descriptions){
            int parent = arr[0];
            int child = arr[1];
            boolean isleft = arr[2]==1;

            mp.putIfAbsent(parent,new TreeNode(parent));
            mp.putIfAbsent(child,new TreeNode(child));

            if(isleft){
                mp.get(parent).left = mp.get(child);
            }
            else mp.get(parent).right = mp.get(child);

            st.add(child);
        }
        for(int[] arr: descriptions){
            int parent = arr[0];
            if(!st.contains(parent)){
                return mp.get(parent);
            }
        }
        return null;


    }
}