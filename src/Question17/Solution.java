package Question17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));

    }
    public static List<String> letterCombinations(String digits) {
        if(null == digits || digits.isEmpty() || "".equals(digits)){
            return new ArrayList<String>();
        }
        String[] strArr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List <String> list = new ArrayList<>();
        list.add("");
        for(int i = 0 ; i < digits.length(); i ++){
            int size = list.size();
            for(int j = 0; j < size; j ++){
               String s = list.remove(0);
               for(int  k = 0 ; k < strArr[Character.digit(digits.charAt(i), 10)].length() ; k ++){
                   list.add(s+strArr[Character.digit(digits.charAt(i), 10)].charAt(k));
               }
            }
        }
        return list;
    }
}
