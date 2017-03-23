package com.bywangxp.offer;

import com.sun.javafx.geom.transform.GeneralTransform3D;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月22日 下午3:40:03 
 * @version   v1.0   
 * @quesetion 定义栈的数据结构，请在该类型中实现一个能够得到该栈的最小元素的min函数，在该栈中
 *            调用min，push及pop的时间复杂度都是O(1)
 * @summary 
 *
 */
public class No_21_StackWithMin { 
   /*
    * 本题难点是，虽然可以设置一个数，来记录最小的元素，但是当这个元素被pop了，
	*那么第二小的元素,在哪呢？所以本题需要一个辅助的数据结构，来记录每次的最小值
	*方法：设置一个辅助栈，每次元素进栈的时候，和当前的最小元素比较，存入当前的最小元素
	*就算这个新元素比辅助栈的最小元素小，任然将这个最小元素，入栈，
	*（栈中同一个最小元素，被存储多次）
	**/
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(3);
		System.out.println(myStack.getMin());
		myStack.push(4);
		System.out.println(myStack.getMin());
		myStack.push(2);
		System.out.println(myStack.getMin());
		myStack.push(1);
		System.out.println(myStack.getMin());
		myStack.pop();
		System.out.println(myStack.getMin());
		myStack.pop();
		System.out.println(myStack.getMin());
		myStack.push(0);
		System.out.println(myStack.getMin());
	}

}
class MyStack{
	int size = 10;
	int stack[] = new int[size];
	int top = -1;
	int length = 0;
	int min_stack[] = new int[size];
	public boolean push(int num){
		if(length == size){
			return false;
		}
		++length;
		stack[++top] = num;
		if(top-1 == -1 || min_stack[top-1] > num){
			min_stack[top] = num;	
	    }else{
	    	    min_stack[top]=min_stack[top-1];
	    }
		return false;
	}
	public int pop(){
		if(top == -1){
			try {
				throw new Exception("栈为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		--length;
		int num = stack[top--];
		return num;
	}
	public int getMin(){
		if(top == -1){
			try {
				throw new Exception("栈为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
		return min_stack[top];
	}
}