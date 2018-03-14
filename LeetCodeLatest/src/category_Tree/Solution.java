package category_Tree;

import java.util.*;

public class Solution {
	public int sumOfLeftTrees(TreeNode root) { // 这个是所有左子树，递归方法
		int left = 0, right = 0;
		if (root == null)
			return 0;
		if (root.left != null)
			left = sumOfLeftTrees(root.left) + root.left.val;
		if (root.right != null)
			right = sumOfLeftTrees(root.right);
		return left + right;
	}

	public int sumOfLeftLeaves(TreeNode root) {
		/*
		 * 这个是左叶子树 LeetCode 编号 404
		 * https://leetcode.com/problems/sum-of-left-leaves/description
		 * 这个是递归（recursive）方法
		 */
		if (root == null)
			return 0;
		int sum = 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null)
				sum += root.left.val;
			else
				sum += sumOfLeftLeaves(root.left);
		}
		sum += sumOfLeftLeaves(root.right);
		return sum;
	}

	public int sumOfLeftLeaves_0(TreeNode root) {
		/*
		 * 这个是左叶子树 LeetCode 编号 404
		 * https://leetcode.com/problems/sum-of-left-leaves/description
		 * 这个是迭代（iteration）方法
		 */
		if (root == null || (root.left == null && root.right == null))
			return 0;
		int sum = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			if (temp.left == null && temp.right == null) {
				sum += temp.val;
			} else if (temp.right != null) {
				temp = temp.right;
				if (temp.left != null || temp.right != null) {
					while (temp != null) {
						stack.push(temp);
						temp = temp.left;
					}
				}
			}
		}
		return sum;
	}

	


}