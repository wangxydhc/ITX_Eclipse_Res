package category_Collection;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack{
	/*
	 * https://leetcode.com/problems/implement-stack-using-queues/description/
	 * 
	 * 自己的办法，不知道有没有更好的
	 * 
	 */	
	    /** Initialize your data structure here. */
	    Queue <Integer>queue=new LinkedList<Integer>();
	    Queue <Integer>queueX=new LinkedList<Integer>();
	    int count=0;
	    public MyStack() {
	        
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	    	queue.add(x);
	        count++;
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	    	for(int i=count;i>1;i--)
	    		queueX.add(queue.poll());
	    	count--;
	    	 Queue <Integer>temp=queueX;
	    	 queueX=queue;
	    	 queue=temp;
	    	return queueX.poll();	        
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	for(int i=count;i>1;i--)
	    		queueX.add(queue.poll());
	    	int re=queue.poll();
	    	queueX.add(re);
	    	 Queue <Integer>temp=queueX;
	    	 queueX=queue;
	    	 queue=temp;
	    	return re;
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        if (count==0)
	        	return true;
	        else
	        	return false;
	    }
	
}
