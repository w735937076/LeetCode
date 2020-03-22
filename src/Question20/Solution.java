package Question20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        String s = "({}([]))";
        System.out.println("isValid == " + isValid(s));
        System.out.println("isValid2 == " + isValid2(s));
    }

    public static  boolean isValid(String s) {
        if(null == s || s.length() % 2 !=  0){
            return false;
        }

        while(s.indexOf("()") > -1 || s.indexOf("{}") > -1 || s.indexOf("[]") > -1){
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
        }

        return "".equals(s);
    }

    public static boolean isValid2(String s){
        if(null == s || s.length() % 2 !=  0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index) == '('){
                stack.push(')');
            }else if(s.charAt(index) == '['){
                stack.push(']');
            }else if(s.charAt(index) == '{'){
                stack.push('}');
            }else{
                if(stack.isEmpty() || s.charAt(index) != stack.pop()){
                    return false;
                }
            }
            index ++;
        }
        return stack.isEmpty();
    }
}
