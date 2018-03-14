package category_BitManipulation;

public class Solution {
	/*
	 * https://leetcode.com/problems/bitwise-and-of-numbers-range
	 */
	public int rangeBitwiseAnd(int m, int n) {		
		int factor=1;
		while(m!=n){
			m>>=1;
			n>>=1;
			factor<<=2;
		}
		return m*factor;
	}

	public static void main(String[] args) {
		int res = 5 & 6 & 7;
		System.out.println("res=" + res);
	}
}
