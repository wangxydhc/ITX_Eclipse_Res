package date0701;

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> stack;
	private Stack<Integer> stack2;
	private int count;
	private boolean push=true;
	
    /** Initialize your data structure here. */
    public MyQueue() {
    	stack=new Stack<>();
    	count=0;    	
    }
    public void reStack(){
  		stack2=new Stack<Integer>();
		for(int i=0;i<count;i++){
			stack2.push(stack.pop());
		}
		stack=stack2;
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
    	if (push!=true)
    	{
    		this.reStack();
    		push=true;
    	}    		
        stack.push(x);
        count++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if(push==true){
    		this.reStack();  
    		push=false;
    	}
    	int num=stack.pop();
    	count--;
    	return num;  
    }
    
    /** Get the front element. */
    public int peek() {
    	int num=this.pop();
    	stack.push(num);
    	count++;
    	return num;
    }    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (count==0)
        	return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
