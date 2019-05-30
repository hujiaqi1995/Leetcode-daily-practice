import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jiaqi on 2019/5/30 4:18 PM
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class P11_ContainerWithMostWater {
    // 复杂度 O(n^2)
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0, cur = 0, len, dis;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                len = Math.min(height[i], height[j]);
                dis = j - i;
                cur = len * dis;
                if (cur > max) max = cur;
            }
        }
        return max;
    }

    // 优化，复杂度为O(n)
    public int maxArea2(int[] height) {
        int n = height.length - 1, start = 0, end = n, max = 0, cur = 0;
        while (start < end) {
            // 短的那根调整，长的不用动！
            if (height[start] > height[end]) {
                cur = (end - start) * height[end--];
            } else {
                cur = (end - start) * height[start++];
            }
            if (cur > max) max = cur;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.valueOf(strings[i]);
        }
        P11_ContainerWithMostWater water = new P11_ContainerWithMostWater();
        int res = water.maxArea2(arr);
        System.out.println(res);

    }


}
