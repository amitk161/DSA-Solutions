class Solution {
    public int myAtoi(String s) {
        long num = 0;
        char[] arr = s.toCharArray();
        
        if(arr.length == 0)
            return 0;
        
        int i = 0, sign = 1;
        char current = arr[i];
        
        while(current == ' '){
            i++;
            if(i == arr.length)
                return 0;
            current = arr[i];
        }
        
        if(current == '-'){
            sign = -1;
            i++;
        } else if(current == '+'){
            sign = +1;
            i++;
        }
        
        for(; i<arr.length; i++){
            current = arr[i];
            
            if(current < '0' || current > '9')
                break;
            else {
                num *= 10;
                num += current - '0';
            }
            
            if(sign * num <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else if(sign * num >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        
        num *= sign;
        return (int) num;
    }
}