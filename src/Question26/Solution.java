package Question26;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,1,1,1,1,1,1,1};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
           return 0;
        }

        int index = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            while(i < nums.length - 1 && nums[i + 1] == nums[i]){
                i ++;
            }

            nums[index ++] = nums[i];
        }
        return index;
    }
}
