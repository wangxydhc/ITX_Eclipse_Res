package data0711;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class Solution {
	int len = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		this.lengM(root);
		return len;
	}

	public int lengM(TreeNode root) {
		int lengl = 0, lengr = 0;
		if (root.left!= null)
			lengl = lengM(root.left) + 1;
		if (root.right!= null)
			lengr = lengM(root.right) + 1;
		len = Math.max(len, lengl + lengr);
		return Math.max(lengl, lengr);
	}

	public int findLUSlength(String a, String b) {
		if (a.equals(b))
			return -1;
		return Math.max(a.length(), b.length());
	}



	public int rob(int[] nums) {
		int len = nums.length;
		int[] money = new int[len];
		money[0] = 0;
		money[1] = nums[1];
		for (int i = 2; i < len; i++) {
			money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
		}
		return money[len - 1];
	}

	public int longestPalindrome(String s) {
		int i = 0, res = 0;
		boolean ty = false;
		Map<Integer, Integer> map = new HashMap<>();
		while (i < s.length()) {
			char c = s.charAt(i);
			map.put(c - 'A', map.getOrDefault(c - 'A', 0) + 1);
			i++;
		}
		for (Map.Entry<Integer, Integer> u : map.entrySet()) {
			int num = (int) u.getValue();
			if (ty == false) {
				if (num % 2 == 1)
					ty = true;
			}
			res += ((int) u.getValue());
		}
		if (ty)
			res++;
		return res;
	} int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			int cnt=map.getOrDefault(nums[i], 0)+1;
			if (cnt>nums.length/2)
				return nums[i];
			else
				map.put(nums[i], cnt);
		}
		return 0;
	}
    public int[] twoSum(int[] numbers, int target) {
        int a=0,b=numbers.length-1;
        int sum=numbers[a]+numbers[b];
        while(sum!=target){
        	if(sum>target)
        		b--;
        	if(sum<target)
        		a++;
        	sum=numbers[a]+numbers[b];
        }
        int []loc=new int[2];
        loc[0]=a+1;
        loc[1]=b+1;
        return loc;
    }
    public void rotate(int[] nums, int k) {
    	int len=nums.length;
    	k=k%len;
        int []temp=new int[k];
        for(int i=0;i<k;i++){
        	temp[i]=nums[nums.length-k+i];        	
        }
        for(int i=0;i<nums.length-k;i++){
        	nums[nums.length-i-1]=nums[nums.length-k-i-1];
        }
        for(int i=0;i<k;i++){
        	nums[i]=temp[i];
        }
    }

	public String reverseWords(String s) {
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ')
				stack.push(c);
			else {
				while (!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(' ');
			}
		}
		while (!stack.isEmpty())
			sb.append(stack.pop());
		return sb.toString();
	}

	public static void main(String[] args) {
		char c = 'a', d = 'z';
		char b = 'A', g = 'Z';
		int[] r = new int[4];
		r[0] = c;
		r[1] = d;
		r[2] = b;
		r[3] = g;
		for (int i = 0; i < 4; i++)
			System.out.println(r[i]);
	}
}
