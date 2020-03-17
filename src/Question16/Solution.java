package Question16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,5,10,11};
        int target = 12;
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3 ){
            return 0;
        }

        Arrays.sort(nums);
        int index = 0;
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for(int num : nums){
            int left = index + 1;
            int right = nums.length - 1;
            if(index > 0 && num == nums[index-1]){
                index ++;
                continue;
            }
            while(left <  right){
                int sum = num + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    left ++;
                }else{
                    right --;
                }
                diff = Math.min(Math.abs(sum - target),diff);
                result = Math.abs(sum - target) <= diff ? sum : result;

            }
            index ++;
        }

        return result;
    }

}
