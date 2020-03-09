package Question10;

/**
 * @Author: WZL
 * @Date: 2020/3/9 23:50
 */
public class Solution {
    public static void main(String[] args) {
        String s = "";
        String p = null;
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {
        //EdgeCase:只有两个都为空才会match
       if(null == p || p.length() == 0){
           return null == s || s.length() == 0;
       }

       //要么第一个字符相等，要么p的第一个字符为'.'，才会首字符match
       boolean init = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

       //p的第二个字符为'*'的时候，需要判断s和p第二个字符之后的是否匹配或者首字符match，s第一个字符之后与p是否match
       if(p.length() > 1 && p.charAt(1) == '*'){
           return isMatch(s,p.substring(2)) || (init && isMatch(s.substring(1),p));
       }else{
           //剩余的就是看s和p第一个字符相等之后剩余的是否match
           return init && isMatch(s.substring(1),p.substring(1));
       }
    }
}
