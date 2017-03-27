package com.bywangxp.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月24日 下午4:34:11 
 * @version   v1.0   
 * @quesetion 输入一个字符串，打印出该字符串中字符的所有排列+组合问题
 * @summary   分成两步，首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换
 *            （注意每次交换后，叫交换回来，然后继续与下一个位置交换）；第二步固定第一个字符，
 *             求后面所有字符的排列。这个时候任然把第一个字符，以及这个字符后面的所有字符分成两部分 
 *             ：后面第一个字符，以及这个字符后面的所有字符，然后把第一个字符与它后面的所有字符交换。
 *
 */
public class No_28_CharPermutation {
	//固定一个数，然后剩下的数变化，在剩下的数中任然采用这个方法。递归实现
	public static void main(String[] args) {
		char num[]={'1','2','3','4'};
		//solution(num,0);
		//combiantion(num);
		compose(num);
	}
	public static void solution(char num[] ,int start) {
		if(start == num.length){
			System.out.println(Arrays.toString(num));
		}else{
			for(int i = start ; i< num.length; ++i){
				char temp = num[start];//初始时自己和自己交换，保持不变
				num[start] = num[i];
				num[i] = temp;
				solution(num,start+1);// 注意这里是start+1，不是i+1
			    temp = num[start];//每一次交换后，在交换回来，之后再回到上部交换
				num[start] = num[i];
				num[i] = temp;
			}
		}
	}

	public static void compose(char num[]){
		//组合问题 输入n个数，得到长度为1，2，3...n的组合。
		//方法把这n个字符拆成两部分，第一个字符和剩余的部分，如果组合里包含第一个字符，
		//则下一步在剩余的字符里选取m-1个字符，如果没有，则在剩下的n-1个字符里找m个字符
		if(num == null){
			return ;
		}
		Stack stack = new Stack();
		for(int i =1 ;i <= num.length; ++i){
			combine(num , 0 , i ,stack);
		}
	}
	private static void combine(char[] num, int begin, int number, Stack stack) {
		if(number == 0){//结束条件1，当number=0输出;
			System.out.println(stack.toString());
			return ;
		}
		if(begin == num.length){//结束条件2，到达尾部
			return ;
		}
		stack.push(num[begin]);//一定要使用栈结构,因为先一直递归是增加，后面开始把最后添加的舍去，在递归
		combine(num, begin+1,number-1,stack);
		stack.pop();
		combine(num, begin+1,number,stack);
	}
}
