import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiaqi on 2019/6/3 11:16 PM
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */
public class P18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-3; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int lo = i+1, hi = nums.length-1, sum = target - nums[i];
                List<List<Integer>> three_sum_result = threeSum(nums, lo, hi, sum);
                for(List<Integer> list : three_sum_result) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    for(Integer num : list) {
                        temp.add(num);
                    }
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private List<List<Integer>> threeSum(int[] num, int low, int high, int target) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = low; i < high-1; i++) {
            if (i == low || num[i] != num[i-1]) {
                int lo = i+1, hi = high, sum = target - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        P18_4Sum sum = new P18_4Sum();
        System.out.println(sum.fourSum(arr, 0));
    }
}
