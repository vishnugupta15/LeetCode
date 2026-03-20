class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m-k+1][n-k+1];

        for(int i = 0; i<=m-k; i++){
            for(int j = 0; j<=n-k; j++){
                TreeSet <Integer> vals = new TreeSet<>();

                for(int p=i; p<=i+k-1; p++){
                    for(int q=j; q<=j+k-1; q++){
                        vals.add(grid[p][q]);
                    }
                }

                if(vals.size()==1)continue;

                int mindiff = Integer.MAX_VALUE;
                Integer prev = null;
                for(int val:vals){
                    if(prev!=null){
                        mindiff = Math.min(mindiff,val-prev);
                    }
                    prev = val;
                }
                result[i][j] = mindiff;
            }
        }
        return result;
    }
}