import java.util.Arrays;

/**
 * Created by jiaqi on 2019/6/1 8:39 PM
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class P16_3SumClosest {

    // 写得是一坨屎 O(n^3)， 居然过了……
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int diff = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (diff > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
                        diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        sum = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return sum;
    }

    // 改进，复杂度O(n^2)
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 3) return 0;
        int sum = nums[0] + nums[1] + nums[2];
        int start, end, diff = Integer.MAX_VALUE, tmp;
        for (int i = 0; i < nums.length - 2; i++) {
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                tmp = nums[i] + nums[start] + nums[end] - target;
                if (tmp == 0) return nums[i] + nums[start] + nums[end];
                if (diff > Math.abs(tmp)) {
                    diff = Math.abs(tmp);
                    sum = nums[i] + nums[start] + nums[end];
                }
                if (tmp < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        P16_3SumClosest closest = new P16_3SumClosest();
        int[] nums = {-1, -1, 1, 1, 3};
        int target = 1;
        int res = closest.threeSumClosest2(nums, target);
        System.out.println(res);

    }
}
