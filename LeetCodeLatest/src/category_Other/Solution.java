package category_Other;

public class Solution {
	/*
	 * https://leetcode.com/problems/power-of-four/description/
	 */
	public boolean isPowerOfFour(int num) {
		return (num>0)&&((num-1)&num)==0&&((num&0x55555555)!=0);
	}
}
