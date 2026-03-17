class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length; 
        int result = 0;

        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                if(matrix[i][j]!=0 & i>0){
                    matrix[i][j] += matrix[i-1][j];
                }
            }

            int[] currentRow = matrix[i].clone();
            Arrays.sort(currentRow);
            for(int j = 0; j<n; j++){
                int base = (n-j);
                int height = currentRow[j];

                result = Math.max(result, base*height);
            }
        }
        return result;
    }
}