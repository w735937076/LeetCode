package Question4;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * @Author: nick
 * @Date: 2020/3/4 22:17
 */
public class Solution {
    public static void main(String[] args) {
        int nums1[] = {1,4,7,10};
        int nums2[] = {3,4,5,7};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //nums1游标
        int index1 = 0;
        //nums2游标
        int index2 = 0;
        //存储两数组遍历的组成的新数组
        List<Integer> resultList = new ArrayList<Integer>();

        //判断是否为偶数
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;

        //中位数下标，如果是偶数，则为m与m-1对应的平均数，如果是奇数，则为m对应数
        int m = (nums1.length + nums2.length) / 2;

        double result = 0.0;

        while(index1 <= nums1.length || index2 <= nums2.length){

            if((index1 + index2) == (m + 1) && isEven){
                //偶数
                result = (double) (resultList.get(m) + resultList.get(m-1)) / 2;
                break;
            }else if((index1 + index2) == (m+1) && !isEven){
                //奇数
                result = resultList.get(m);
                break;
            }

            if(index1 < nums1.length && index2 < nums2.length && nums1[index1] <= nums2[index2]){
                resultList.add(nums1[index1]);
                index1++;
            }else if(index1 < nums1.length && index2 < nums2.length && nums1[index1] > nums2[index2]){
                resultList.add(nums2[index2]);
                index2++;
            }else if(index1 < nums1.length){
                resultList.add(nums1[index1]);
                index1++;
            }else {
                resultList.add(nums2[index2]);
                index2++;
            }
        }

        return result;
    }
}
