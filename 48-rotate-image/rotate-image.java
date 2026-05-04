class Solution {
    public void rotate(int[][] matrix) {
        // so the approach is to take the transpose of the matrix first and then reverse the rows of the matrix that will be our final result 
        
        //transpose
        for(int i = 0; i<matrix[0].length-1; i++){
            for(int j = i+1; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse the rows
        for(int i = 0; i<matrix[0].length; i++){
            int l=0;
            int r=matrix[0].length-1;

            while(l<r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}