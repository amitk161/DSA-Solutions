class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i=m;
        int j=0;

        while(i<arr1.length)

        {

            arr1[i]=arr2[j];

            i++;

            j++;

        }

        Arrays.sort(arr1);
    }
}