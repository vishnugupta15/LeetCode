class Solution {
    public int[] sortByBits(int[] arr) {
        int swapped = 0;
        for(int i = 0; i<arr.length; i++){
            swapped = 0;
            for(int j = 0; j<arr.length-i-1; j++){
                if((Integer.bitCount(arr[j])) > (Integer.bitCount(arr[j+1]))){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = 1;
                }
                else if((Integer.bitCount(arr[j])) == (Integer.bitCount(arr[j+1])) && arr[j]>=arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = 1;
                }
            }
            if(swapped == 0) return arr;
        }
        return arr;
    }
}