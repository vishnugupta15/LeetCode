class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            if(matrix[0][i]=='1') arr[i] = 1;
            else arr[i] = 0;
        }
        int max = 0;
        max = Math.max(max,largestRectangleArea(arr));

        for(int i = 1; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j]=='0') arr[j] = 0;
                else arr[j] = arr[j]+1;
            }
            max = Math.max(max,largestRectangleArea(arr));
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = 0;

        for(int i = 0; i<=n; i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()] >= (i<n? heights[i]:0))){
                int height = heights[st.pop()];

                int width;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i-st.peek()-1;
                }

                max = Math.max(max,height*width);
            }
            st.push(i);
        }
        return max;
    }
}