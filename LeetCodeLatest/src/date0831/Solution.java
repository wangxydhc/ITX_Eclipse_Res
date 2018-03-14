package date0831;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


class Solution {
    public int numberOfArithmeticSlices(int[] A) {
    	if (A.length<=2)
    		return 0;
        int diff=A[1]-A[0];
        int count=2,sum=0;   
        for(int i=1;i<A.length-1;i++){
        	if(A[i+1]-A[i]==diff){
        		count++;
        	}
        	else
        	{	
        		diff=A[i+1]-A[i];
        		sum+=(count-1)*(count-2)/2;
        		count=2;
        	}
        }
        sum+=(count-1)*(count-2)/2;
        return sum;
    }
    public List<Integer> largestValues(TreeNode root) {
    	
        Stack<TreeNode> stack=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        int max=Integer.MIN_VALUE;
        TreeNode temp;
        List<Integer> res=new LinkedList<Integer>();
        if (root!=null)
        	res.add(root.val);
        else 
        	return res;
        stack.push(root);
        while(!stack.isEmpty()){
        	temp=stack.pop();
        	if(temp.left!=null){
        		max=Math.max(max, temp.left.val);
        		stack2.add(temp.left);        		
        	}
        	if(temp.right!=null){
        		stack2.add(temp.right);
        	max=Math.max(max, temp.right.val);}
        	
        	if(stack.isEmpty()&&!stack2.isEmpty()){
        		res.add(new Integer(max));
        		max=Integer.MIN_VALUE;
        		Stack<TreeNode> tempS=stack2;
        		stack2=stack;
        		stack=tempS;
        	}        	
        }
        return res;
    }
    public TreeNode convertBST(TreeNode root) {
    	if (root==null)
    		return null;
    	Stack<TreeNode> stack=new Stack();    	
        int sum=0;
        TreeNode isHandled;
        this.handle(root, stack);
    	while(!stack.isEmpty()){
    		isHandled=stack.pop();
    		isHandled.val+=sum;
    		sum=isHandled.val;
    		if (isHandled.left!=null)
    			this.handle(isHandled.left, stack);
    	}
    	return root;    	
    }
    
    public void convert(TreeNode handle,int sum) {
    	if (handle.right!=null)
    	convert(handle.right,sum);
    	handle.val+=sum;
    	sum=handle.val;
    	if (handle.left!=null)
    	convert(handle.left,sum);
    }
    public TreeNode convertBST2(TreeNode root){
    	if (root==null)
    		return root;
    	convert(root,0);
    	return root;
    }
    
    public int countArrangement(int N) {
    	int []count=new int[1];
    	count[0]=0;
        boolean[] isUsed=new boolean[N+1];
       help(1,N,isUsed,count);
       return count[0];
    }
    public void help(int sig,int N,boolean [] used,int[] count){
    	for(int i=1;i<N+1;i++){
    		if (used[i]==false&&(sig%i==0||i%sig==0)){
                used[i]=true;
    			if(sig!=N){
    				help(sig+1,N,used,count);
                   
                }
    			else{
    				count[0]++;
                  
                }
                used[i]=false;   	}
        
    }
}
    
    public void handle(TreeNode node,Stack<TreeNode> stack){
    	
    	stack.push(node);
    	while(node.right!=null){    		
    	stack.push(node.right);
    	node=node.right;
    	}    	
    }
    public int MaxInTri(int a,int b,int c){
    	int d=a*c,e=b*c,max=c;
    	if (e>=max)
    		max=e;
    	if(d>=max)
    		max=d;
    	return max;
    }
    public int MinInTri(int a,int b,int c){
    	int d=a*c,e=b*c,min=c;
    	if (e<min)
    		min=e;
    	if(d<min)
    		min=d;
    	return min;
    }
    public int maxProduct(int[] nums) {
    	int max=Integer.MIN_VALUE;
    	if (nums.length==1)
    		return nums[0];
    	int maxWithLa=max,minWithLa=max;
    	int temp;
    	for(int i=0;i<nums.length-1;i++){
    		temp=this.MaxInTri(maxWithLa, minWithLa, nums[i+1]);
    		minWithLa=this.MinInTri(maxWithLa,minWithLa,nums[i+1]);
    		maxWithLa=temp;
    		max=Math.max(max, maxWithLa);
    	}
    		
    	return max;  
    }
    public static void main(String[] args) {
		int [] A={1, 3, 5, 7, 9, 11};
		Solution s=new Solution();
		System.out.println(s.numberOfArithmeticSlices(A));
	}
}
