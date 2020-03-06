package Question6;

/**
 * @Author: WZL
 * @Date: 2020/3/6 22:56
 */
public class Solution {
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s,3));
    }

    public static String convert(String s, int numRows) {
        //判断numRows为一行的情况以及s的长度小于3的时候
        if(numRows < 2 || null == s || s.length() < 3){
            return s;
        }

        //定义行的数组并初始化
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows ; i++){
           rows[i] = new StringBuilder();
        }

        String[] arr = s.split("");
        int index = 0;
        int flag = 1;
        for(String str : arr){
            rows[index].append(str);
            index += flag;
            if(index == numRows - 1 ){
                flag = -1;
            }else if(index == 0){
                flag = 1;
            }
        }

        StringBuilder returnStr = new StringBuilder();
        for(int i = 0 ; i < rows.length ; i ++){
            returnStr.append(rows[i]);
        }
        return returnStr.toString();
    }
}
