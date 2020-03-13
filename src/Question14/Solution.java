package Question14;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Author: WZL
 * @Date: 2020/3/12 20:10
 */
public class Solution  {
    public static void main(String[] args) {
        String[] strs = {"flower","flag","flow"};
        System.out.println(longestCommonPrefix2(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String result = strs[0];
        int index = 0;
        for(String word : strs){
            if(index == 0){
                index = 1;
                continue;
            }
            index = 1;
            while(index <= result.length()){
                if(word.substring(0,index > word.length() ? word.length() : index).indexOf(result.substring(0,index)) > -1){
                   index ++;
                }else{
                    result = result.substring(0,index-1);
                    if(index <= 1){
                        return result;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String result = strs[0];
        for(String word : strs){
           while(word.indexOf(result) != 0){
               result = result.substring(0,result.length() - 1);
           }
        }
        return result;
    }
}
