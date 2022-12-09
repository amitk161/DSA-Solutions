//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(String[] arr) {
        if(arr.length == 0)
            return "";
            
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                String o1 = a+b;
                String o2 = b+a;
                return o2.compareTo(o1);
            }
        });
        
        if(arr[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);
        }
        return sb.toString();
    }
}