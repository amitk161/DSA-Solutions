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
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	    int result = 0;
        int sign = 1;
        int i = 0;
        
        if(str.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        
        while(i < str.length()){
            if(!(str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9)){
                return -1;
            }
            result = result * 10 + str.charAt(i) - '0';
            i++;
        }
        return result * sign;
    }
}
