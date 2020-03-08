package Question9;

/**
 * @Author: WZL
 * @Date: 2020/3/8 23:11
 */
public class Solution {
    public static void main(String[] args) {
        int x = 12344321;
        System.out.println("isPalindrome == "+isPalindrome(x));
        System.out.println("isPalindrome2 == "+isPalindrome2(x));
    }

    public static boolean isPalindrome(int x){
        int s = x;
        if(x < 0){
            return false;
        }
        long result = 0;
        while(x > 0){
           result = result * 10 + x % 10;
           if(result > Integer.MAX_VALUE){
               return false;
           }
           x /= 10;
        }

        return s == (int)result;
    }

    public static boolean isPalindrome2(int x) {
        StringBuilder stringBuilder = new StringBuilder(x+"");
        if(stringBuilder.toString().equals(stringBuilder.reverse().toString())){
            return true;
        }
        return false;
    }
}
