//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	    int result = 0;
	    int i = 0;
	    int sign = 1;
	    
	    if(s.charAt(i) == '-'){
	        sign = -1;
	        i++;
	    }
	    
	    while(i < s.length()){
	        if(!(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9)){
	            return -1;
	        }
	        
	        result = result * 10 + s.charAt(i) - '0';
	        i++;
	    }
	    return result * sign;
    }
}
