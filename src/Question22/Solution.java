package Question22;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        printList(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(list,"",0,0,n);
        return list;
    }

    public static void generate(List<String> list,String result,int leftNum,int rightNum,int n){

        if(leftNum > n || rightNum > n){
            return;
        }

        if(leftNum == n &&  rightNum == n){
            list.add(result);
        }

        if(leftNum < n){
            generate(list,result+"(",leftNum + 1,rightNum,n);
        }

        if(rightNum <  leftNum){
            generate(list,result+")",leftNum,rightNum + 1,n);
        }
    }

    public static void printList(List<String> list){
        if(null != list && list.size() > 0){
            int index = 1;
            for(String str : list){
                System.out.println("第"+ (index++) +"种组合："+str);
            }
        }
    }
}
