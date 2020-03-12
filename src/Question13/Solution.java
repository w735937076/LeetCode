package Question13;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WZL
 * @Date: 2020/3/12 18:03
 */
public class Solution {
    public static void main(String[] args) {
        //String s = "MCMXCIV";
        String s = "MCMXCV";
        System.out.println(romanToInt(s));
    }
    
    
    public static int romanToInt(String s) {
        //EdgeCase
        if("".equals(s) || s.length() == 0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int index = 0;
        int result = 0;
        while(index < s.length() - 1){
            if(map.get(s.charAt(index)) < map.get(s.charAt(index + 1))){
                result += - map.get(s.charAt(index)) + map.get(s.charAt(index + 1));
                index = index + 2;
            }else{
                result += map.get(s.charAt(index));
                index ++;
            }
        }
        if(index == s.length() - 1){
            result += map.get(s.charAt(s.length() - 1));
        }

        return result;
    }
}
