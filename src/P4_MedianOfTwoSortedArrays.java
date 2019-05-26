/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */


public class P4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{1, 2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0, index = 0;
        if (m == 0) {
            if (n == 1) return nums2[0];
            return n % 2 == 1 ? nums2[n / 2] : 1.0 * (nums2[n / 2 - 1] + nums2[n / 2]) / 2;
        }
        if (n == 0) {
            if (m == 1) return nums1[0];
            return m % 2 == 1 ? nums1[m / 2] : 1.0 * (nums1[m / 2 - 1] + nums1[m / 2]) / 2;
        }
        int[] arr = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[index++] = nums1[i++];
            } else {
                arr[index++] = nums2[j++];
            }
        }
        while (i < m) {
            arr[index++] = nums1[i++];
        }
        while (j < n) {
            arr[index++] = nums2[j++];
        }
        if ((m + n) % 2 == 1) {
            return arr[(n + m) / 2];
        }
        return 1.0 * (arr[(m + n) / 2] + arr[(m + n) / 2 - 1]) / 2;
    }
}
