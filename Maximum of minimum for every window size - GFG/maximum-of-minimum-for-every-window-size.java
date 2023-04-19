//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends



class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        
        for(int i=0; i<n; i++){
            left[i] = -1;
            right[i] = n;
        }
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                left[i] = st.peek();
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            st.pop();
        }
        
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                right[i] = st.peek();
            }
            st.push(i);
        }
        
        int[] ans = new int[n+1];
        
        for(int i=0; i<n; i++){
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        
        for(int i=n-1; i>=1; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        
        int[] res = new int[n];
        for(int i=0; i<ans.length-1; i++){
            res[i] = ans[i+1];
        }
        return res;
    }
}