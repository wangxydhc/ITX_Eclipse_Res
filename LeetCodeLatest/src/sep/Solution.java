package sep;

import java.util.Stack;
import java.util.TreeSet;

public class Solution {
	public int getMinimumDifference(TreeNode root) {		
		int min=Integer.MAX_VALUE,preVal=0;
		boolean isEm=true; 
		Stack<TreeNode> stack = new Stack();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		TreeNode temp;
		while (!stack.isEmpty()) {
			temp = stack.pop();
			if(isEm==true){
				preVal=temp.val;
				isEm=false;
			}
			else{
				min=Math.min(Math.abs(temp.val-preVal),min);
				preVal=temp.val;				
			}
			temp=temp.right;
			while (temp!= null) {
				stack.push(temp);
				temp = temp.left;
			}
		}
		return min;
	}
	int min=Integer.MAX_VALUE;
	Integer Esal=null;
/*	public int getMinimumDifference2(TreeNode root){
		if (root==null)
			return 0;
		this.getMinimumDifference2(root.left);		
		if(Esal!=null)
			min=Math.min(min, Math.abs(root.val-Esal));
		Esal=root.val;
		this.getMinimumDifference2(root.right);
	   TreeSet<Integer> set=new TreeSet();
	   set.ce
		return min;
	}*/
}
