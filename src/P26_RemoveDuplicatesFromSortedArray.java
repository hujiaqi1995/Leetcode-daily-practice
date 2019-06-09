

/**
 * Created by jiaqi on 2019/6/9 11:26 PM
 */
public class P26_RemoveDuplicatesFromSortedArray {


    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[last] != nums[i]) {
                nums[++last] = nums[i];
            }
        }
        return last+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(removeDuplicates(arr));
    }
}
