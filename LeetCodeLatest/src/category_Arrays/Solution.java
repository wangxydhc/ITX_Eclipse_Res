package category_Arrays;

import java.util.Arrays;

public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		/*
		 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description
		 * 探究：java中Arrays.sort的内部实现是怎样的
		 */
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int len1 = nums1.length, len2 = nums2.length;
		int n1 = 0, n2 = 0, resC = 0;
		while (n1 < len1 && n2 < len2) {
			if (nums1[n1] == nums2[n2]) {
				nums1[resC++] = nums1[n1];
				n1++;
				n2++;
			} else if (nums1[n1] > nums2[n2]) {
				n2++;
			} else
				n1++;
		}
		int[] res = new int[resC];
		for (int i = 0; i < resC; i++) {
			res[i] = nums1[i];
		}
		return res;
	}
}
