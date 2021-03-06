package Question27;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,4,6,8,4,2};
        int val = 2;
        System.out.println(removeElement(nums,val));
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
           return 0;
        }

        int index = 0;
        for(int num : nums){
            if(num == val){
                continue;
            }else if(num == nums[index]){
                index ++;
            }else{
                nums[index ++] = num;
            }
        }

        return index;
    }
}
