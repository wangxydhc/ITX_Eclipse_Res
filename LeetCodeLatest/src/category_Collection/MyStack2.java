package category_Collection;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2{
	/*
	 * https://leetcode.com/problems/implement-stack-using-queues/description/
	 * 
	 * 这个是LeetCode上只用一个queue的方法
	 * 
	 */	
	    /** Initialize your data structure here. */
	    private Queue <Integer>queue=new LinkedList<Integer>();	   
	    public MyStack2() {
	        
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	    	queue.add(x);
	        for(int i=1;i<queue.size();i++)
	        	queue.add(queue.poll());
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	    	return queue.poll();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	return queue.peek();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	      return queue.isEmpty();
	    }	
}
