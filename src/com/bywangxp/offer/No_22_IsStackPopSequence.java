package com.bywangxp.offer;

import java.util.Stack;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月22日 下午4:22:00 
 * @version   v1.0   
 * @quesetion 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列
 *            是否为该栈的弹出顺序。（假设压入栈的所有数字均不相等）
 * @summary   本方法与剑指offer方法不同。
 * 
 */
public class No_22_IsStackPopSequence {
	/*
	* 方法：如果下一个弹出元素，是栈顶元素，直接弹出，否则从未入栈的元素中一直入栈到这个弹出元素，
	* 如果所有元素都入栈了。任没找到这个元素则失败。
	*
	*
	*
	*/
	public static void main(String[] args) {
		int []pushNum={1,2,3,4,5};
		int []popNum={2,4,5,3,1};
		boolean solution = solution(pushNum ,popNum,5);
		System.out.println(solution);
	}
	public static boolean solution(int pushNum[], int popNum[], int length){
		if(length == 0){
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int popIndex = 0; //popIndex指向还没有找到栈顶元素的待查找元素
		int pushIndex = 0;//pushIndex指向还没有入栈的元素
		while(pushIndex <= length){
			if(!stack.isEmpty()){
				Integer top = stack.peek();
				while(top == popNum[popIndex]){//如果栈顶元素与弹出元素一样则下一个栈顶元素
					System.out.println("find");
					popIndex++;
					stack.pop();
					if(stack.isEmpty()){//最后虽然pushIndex中无元素了，但是栈中还有元素，继续与popIndex比较
						                //必须继续比较
						break;
					}else{
						top=stack.peek();
					}
				}
			}
			//一直从入栈元素中找到出栈元素中的当前元素
			while(pushIndex < length && pushNum[pushIndex]!=popNum[popIndex]){
				stack.push(pushNum[pushIndex++]);
				System.out.println("push...");
			}
			if(pushIndex == length && popIndex < length){
				return false;
			}else if(pushIndex == length && popIndex == length){
				System.out.println("stack是空的吗？ "+stack.isEmpty());
				return true;
			}else if(pushIndex < length){
				//找到这个元素,这个元素还没有入栈，直接入栈，下一次循环直接在栈顶中找到这个元素
				stack.push(pushNum[pushIndex]);
				System.out.println("push..."+"agin");
				pushIndex++;//pushIndex指向下一个还没有入栈的元素
			}
		}
		return false;
		
		
	}

}
