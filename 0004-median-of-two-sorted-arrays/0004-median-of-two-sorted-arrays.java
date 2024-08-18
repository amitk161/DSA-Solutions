class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }

        while(i < n1){
            list.add(nums1[i++]);
        }

        while(j < n2){
            list.add(nums2[j++]);
        }

        int n = n1 + n2;
        if(n % 2 == 1)
            return (double) list.get(n/2);

        return ((double) (list.get(n / 2)) + (double) (list.get((n / 2) - 1))) / 2.0;
    }
}