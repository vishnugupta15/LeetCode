class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int mat2[][] = new int[n][n];

        for(int t = 0; t<4; t++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    mat2[i][j] = mat[n-j-1][i];
                    // System.out.print(mat2[i][j]);
                }
                // System.out.println();
            }

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    mat[i][j] = mat2[i][j];
                }
            }
            
            int flag = 0;
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(mat2[i][j] != target[i][j]){
                        flag = 1;
                        break;
                    }
                }
                if(flag==1) break;
            }

            if(flag==0) return true;
        }
        
        return false;
    }
}