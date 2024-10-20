class Solution {
    public int findContentChildren(int[] greed, int[] size) {
        int n = greed.length;
        int m = size.length;
        int l = 0, r = 0;
        Arrays.sort(greed);
        Arrays.sort(size);

        while(l < m && r < n){
            if(greed[r] <= size[l]){
                r++;
            }
            l++;
        }
        return r;
    }
}