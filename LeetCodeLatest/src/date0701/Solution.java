package date0701;

import java.util.Arrays;

public class Solution {
	int min1 = 1001, min2 = 1001, max1 = -1001, max2 = -1001, max3 = -1001;

	public int maximumProduct(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] < min2) {
				min2 = nums[i];
				if (min1 > min2)
					swap1();
			}
			if (nums[i] > max3) {
				max3 = nums[i];
				if (max3 > max2) {
					swap2();
					if (max2 > max1)
						swap3();
				}
			}
			i++;
			// System.out.println(min1 +" " +min2+" "+max1+" "+max2+" "+max3 );
		}

		int m = max1 * max2 * max3;
		int mn = max1 * min1 * min2;

		return m > mn ? m : mn;
	}

	public void swap1() {
		int temp = min1;
		min1 = min2;
		min2 = temp;
	}

	public void swap2() {
		int temp = max2;
		max2 = max3;
		max3 = temp;
	}

	public void swap3() {
		int temp = max2;
		max2 = max1;
		max1 = temp;
	}
}