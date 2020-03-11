package Question11;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * @Author: Nick
 * @Date: 2020/3/10 19:41
 */
public class Solution {
    public static void main(String[] args) {
        int[] height  = {1,8,6,2,5,4,8,3,7};
        System.out.println("maxArea == "+maxArea(height));
        System.out.println("maxArea2 == "+maxArea2(height));
    }

    //暴力法
    public static int maxArea(int[] height) {
        if(height.length < 2){
            return 0;
        }
        int result = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < height.length ; i ++){
            for(int j = i+1 ; j < height.length ; j ++) {
                result = Math.max(result,(j - i) * Math.min(height[i],height[j]));
            }
        }
        return result;
    }

    //中心靠近
    public static int maxArea2(int[] height) {
        //EdgeCase
        if(height.length < 2){
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int result = 0;
        while(left < right){
            result = Math.max(result,(right - left) * Math.min(height[right],height[left]));
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return result;
    }
}
