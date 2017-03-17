package com.bywangxp.offer;

import java.util.Stack;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月17日 下午9:59:50 
 * @version   v1.0   
 * @quesetion 用两个栈实现一个队列，请实现它的两个函数appendTail和deleteHead，分别完成
 *            队列尾部插入结点和在队列头部删除结点
 * @summary   引申：由两个队列实现栈的操作，两个队列分别进行入队出队，queue1，进队列，当出队列的时候
 *            时，应该让队列1，最新加入的元素出队列，方法就是先让队列中最后一个元素前的元素加入到queue2中
 *            然后队列1出队列，即为出栈，进队列时，直接进入有元素的队列，模仿之前的方法。
 *
 */
public class No_7_DoubleStackToQueue {
	public static void main(String[] args) {
		CQueue queue=new CQueue();
		queue.appendTail(1);
		queue.appendTail(3);
		queue.appendTail(5);
		queue.appendTail(7);
		queue.deleteHead();
		queue.deleteHead();
		queue.deleteHead();
		queue.deleteHead();
		queue.deleteHead();
	}
}
class CQueue{
	//方法：使用一个栈来存入放入的元素，每个元素进队列，先进栈1，出元素的时候，当栈2非空的时候
		//则栈2出栈，当栈2为空，则栈1元素全部出栈到栈2中，再出栈
		Stack<Integer> stack1=new Stack<Integer>();
		Stack<Integer> stack2=new Stack<Integer>();
		public void appendTail(int value){
			stack1.push(value);
		}
		public void deleteHead(){
			if(stack1.isEmpty() && stack2.isEmpty()){
				System.out.println("error");
				return ;
			}
			if(stack2.isEmpty()){
				while(!stack1.isEmpty()){
					stack2.push(stack1.pop());
				}
			}
			Integer pop = stack2.pop();
			System.out.println(pop);
		}
}
