package Question28;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        String haystack = "ll";
        String needle = "ll";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {

        if("".equals(needle) || needle.length() == 0){
            return 0;
        }

        if(haystack.length() < needle.length()){
            return -1;
        }

        int length = needle.length();
        int index = 0;
        while(index <= haystack.length() - length){
            if(haystack.substring(index,index+length).equals(needle)){
                return index;
            }else{
                index ++;
            }
        }

        return -1;
    }
}
