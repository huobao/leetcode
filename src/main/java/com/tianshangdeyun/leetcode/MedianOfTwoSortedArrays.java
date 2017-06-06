package com.tianshangdeyun.leetcode;

/**
 * <p>查找第k小的值，可以是用分治法。每次去除k/2个更小的值。</p>
 * 创建日期 2017/6/4
 *
 * @author tianshangdeyun(wangbo@eefung.com)
 * @since 1.0.1
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Size = nums1 == null ? 0 : nums1.length;
        int num2Size = nums2 == null ? 0 : nums2.length;
        int totalSize = num2Size + num1Size;
        if (totalSize % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, totalSize / 2) + findKth(nums1, 0, nums2, 0, totalSize / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, 0, nums2, 0, totalSize / 2 + 1);
        }
    }

    public int findKth(int[] nums1, int nums1Index, int nums2[], int nums2Index, int kth) {
        int nums1Size = nums1 == null ? 0 : nums1.length - nums1Index;
        int nums2Size = nums2 == null ? 0 : nums2.length - nums2Index;
        if (nums2Size < nums1Size) {
            return findKth(nums2, nums2Index, nums1, nums1Index, kth);
        }
        if (nums1Size == 0) {
            return nums2[nums2Index + kth - 1];
        }
        if (kth == 1) {
            return Math.min(nums1[nums1Index], nums2[nums2Index]);
        }

        //divide k into two parts
        int nums1Part = Math.min(nums1Index + kth / 2, nums1.length);
        int nums2Part = nums2Index + kth - (nums1Part - nums1Index);
        if (nums1[nums1Part - 1] == nums2[nums2Part - 1]) {
            return nums1[nums1Part - 1];
        } else if (nums1[nums1Part - 1] > nums2[nums2Part - 1]) {
            return findKth(nums1, nums1Index, nums2, nums2Part, kth - (nums2Part - nums2Index));
        } else {
            return findKth(nums1, nums1Part, nums2, nums2Index, kth - (nums1Part - nums1Index));
        }
    }

    public static void main(String[] args) {
        int nums1[] = new int[]{2,3,4};
        int nums2[] = new int[]{1};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

}
