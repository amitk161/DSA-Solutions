//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set = new HashSet<>();
        int len = wordList.length;
        for(int i=0; i<len; i++){
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int level = 0;
        
        while(!q.isEmpty()){
            ArrayList<String> vec = q.peek();
            q.poll();
            
            if(vec.size() > level){
                level++;
                for(String it: usedOnLevel){
                    set.remove(it);
                }
            }
            
            String word = vec.get(vec.size() - 1);
            if(word.equals(targetWord) == true){
                if(ans.size() == 0){
                    ans.add(vec);
                } else if(ans.get(0).size() == vec.size()){
                    ans.add(vec);
                } 
            }
            
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] replacedArray = word.toCharArray();
                    replacedArray[i] = ch;
                    String newWord = new String(replacedArray);
                    if(set.contains(newWord) == true){
                        vec.add(newWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(newWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }
        return ans;
    }
}