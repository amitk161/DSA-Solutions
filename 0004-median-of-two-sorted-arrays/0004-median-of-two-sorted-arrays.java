class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] finalArray = new int[m+n];
        
        int i=0, j=0, k=0;
        while(i < m && j < n){
            if(arr1[i] < arr2[j]){
                finalArray[k++] = arr1[i++];
            } else {
                finalArray[k++] = arr2[j++];
            }
        }
        
        if(i < m){
            while(i < m){
                finalArray[k++] = arr1[i++];
            }
        }
        
        if(j < n){
            while(j < n){
                finalArray[k++] = arr2[j++];
            }
        }
        
        n = n + m;
        if(n % 2 == 1)
            return finalArray[((n+1)/2) - 1];
        else
            return ((double) finalArray[(n/2) - 1] + finalArray[(n/2)]) / 2.0;
    }
}