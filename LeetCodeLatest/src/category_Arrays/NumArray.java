package category_Arrays;

public class NumArray {
	/*
	 * https://leetcode.com/problems/range-sum-query-immutable/description/
	 * description 只要每个位置都是前面所有的数的和 自己做时做错了，算了所有的，超时了。
	 */
	int[] numAs;

	public NumArray(int[] nums) {
		this.numAs = nums;
		for (int i = 1; i < nums.length; i++)
			this.numAs[i] = this.numAs[i] + this.numAs[i - 1];
	}

	public int sumRange(int i, int j) {
		if (i == 0)
			return this.numAs[j];
		else
			return this.numAs[j] - this.numAs[i - 1];
	}
	/**
	 * Your NumArray object will be instantiated and called as such: NumArray
	 * obj = new NumArray(nums); int param_1 = obj.sumRange(i,j);
	 */
}
