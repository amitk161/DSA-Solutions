class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, ans = 0, maxCount = 0;
    int[] count = new int[26]; // Array to count occurrences of characters
    int n = s.length();
    
    while (j < n) {
        count[s.charAt(j) - 'A']++; // Increment the count of the character at index j
        maxCount = Math.max(maxCount, count[s.charAt(j) - 'A']); // Update maxCount
        
        // Calculate the number of characters that need to be replaced
        int replacements = (j - i + 1) - maxCount;
        
        if (replacements > k) {
            count[s.charAt(i) - 'A']--; // Move the left pointer
            i++;
        }
        
        // Update the maximum length
        ans = Math.max(ans, j - i + 1);
        j++;
    }
    
    return ans;
    }
}