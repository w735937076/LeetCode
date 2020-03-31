package Question32;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: WZL
 * @Date: 2020/3/30 22:17
 */
public class Solution {
    public static void main(String[] args) {
        String s = "()(()())";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int begin = 0;
        int index = 0;
        int leftNum = 0;
        int rightNum = 0;
        int maxLength = 0;
        String maxStr = "";
        while(index < s.length()){
            if("(".equals(s.substring(index,index+1))){
                leftNum ++;
            }else if(")".equals(s.substring(index,index+1))){
                rightNum ++;
                if(leftNum == rightNum){
                    maxStr = s.substring(begin,index+1);
                }else if(leftNum < rightNum){
                    maxLength = maxLength > maxStr.length() ? maxLength : maxStr.length();
                    if(s.length() - index < maxLength) break;
                    rightNum = 0;
                    leftNum = 0;
                    begin = index + 1;
                }
            }

            index ++;
        }

        maxLength = maxLength > maxStr.length() ? maxLength : maxStr.length();
        if(maxLength > s.length() / 2){
           return maxLength;
        }

        leftNum = 0;
        rightNum = 0;
        index = s.length();
        begin = s.length();
        while(index > 0){
            if(")".equals(s.substring(index-1,index))){
                rightNum ++;
            }else if("(".equals(s.substring(index-1,index))){
                leftNum ++;
                if(leftNum == rightNum){
                    maxStr = s.substring(index-1,begin);
                }else if(leftNum > rightNum){
                    maxLength = maxLength > maxStr.length() ? maxLength : maxStr.length();
                    if(index < maxLength) break;
                    rightNum = 0;
                    leftNum = 0;
                    begin = index - 1;
                }
            }

            index --;
        }

        return maxLength > maxStr.length() ? maxLength : maxStr.length();
    }
}
