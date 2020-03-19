package Question18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3,4};
        System.out.println(fourSum(nums,0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4 || nums.length == 4 && nums[0]+nums[1]+nums[2]+nums[3] != target){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        for(int i = 0 ;  i < nums.length ; i ++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1 ; j < nums.length  ; j ++){
                int left = j + 1;
                int right = nums.length - 1;
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                while(left <  right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        returnList.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left ++;
                        right --;
                        while(left > 1 && left < nums.length && nums[left] == nums[left - 1]) left ++;
                        while(right > left && nums[right] == nums[right + 1]) right --;
                    }else if(sum < target){
                        left ++;
                    }else{
                        right --;
                    }
                }
            }
        }

        return returnList;
    }
}
