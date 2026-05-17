class Solution {
    int n;
    public boolean canReach(int[] arr, int start) {
        n = arr.length;

        return dfs(arr,start);
    }
    public boolean dfs(int [] arr, int i){
        if(i<0 || i>n-1 || arr[i]<0) return false;

        if(arr[i]==0) return true;

        arr[i] *= -1;
        boolean a = dfs(arr,i+arr[i]);
        boolean b = dfs(arr,i-arr[i]);

        return a||b;
    }
}