package Question1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WZL
 * @Date: 2020/3/2 22:20
 */
public class Solution {

    /*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
        示例:
        给定 nums = [2, 7, 11, 15], target = 9
        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]
    */
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 13;
        twoSum(nums,target);
        twoSum2(nums,target);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] returns = {0,1};
        if(nums.length > 0 ){
            outer:
            for(int i = 0 ; i < nums.length ; i++){
                for(int j = 0 ; j < nums.length ; j++){
                    if(nums[i]+nums[j] == target && i != j){
                        returns[0] = i;
                        returns[1] = j;
                        System.out.println("twoSum == "+returns[0]+","+returns[1]);
                        break outer;
                    }
                }
            }
        }
        return returns;
    }

    public static int[] twoSum2(int[] nums,int target ){
        int[] returns = {0,1};
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        if(nums.length > 0){
            for(int i = 0 ; i < nums.length ; i++){

                if(null != map.get(nums[i])){
                    returns[0] = i;
                    returns[1] = map.get(nums[i]);
                    System.out.println("twoSum2 == "+returns[0]+","+returns[1]);
                    break;
                }

                map.put(target - nums[i],i);

            }

        }

        return returns;
    }
}
