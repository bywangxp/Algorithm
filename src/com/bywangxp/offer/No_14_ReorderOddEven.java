package com.bywangxp.offer;

import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月20日 下午4:41:59 
 * @version   v1.0   
 * @quesetion 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 *            奇数位于数组的前半部分，所有偶数位于所有数组的后半部分。
 * @summary   本问题，可以将判断奇数偶数的方法抽取出来，单独成为一个方法，那个
 *            这个判断函数就可以用来解决其他问题，变得更加通用
 *
 */
public class No_14_ReorderOddEven {
	/*
	 * 方法：设置两个指针，指针1指向数组的第一个元素，第二个指向最后一个元素，
	 * 第一个元素，指向不符合规定的第一个元素，即偶数，如果不是偶数，就继续找下一个元素
	 * 第二个元素，指向奇数。同理，然后开始交换两个元素，循环结束的条件是i>=j
	 * 
	 * */
	public static void main(String[] args) {
		int []num ={0};
		solution(num);
		System.out.println(Arrays.toString(num));
	}
	public static boolean isEven(int num){
		return num % 2 == 0 ? true : false;
	}
	public static void solution(int []num){
		if(num == null || num.length ==0){
			try {
				throw new Exception("输入为空，或数组长度为0");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int indexOdd = 0;
		int indexEven = num.length - 1;
		while(indexOdd < indexEven){
			while(!isEven(num[indexOdd])){//第一个指针一直移动到找到第一个偶数
				++indexOdd;
				if(indexOdd >= indexEven){
					break;
				}
			}
			while(isEven(num[indexEven])){
				--indexEven;
				if(indexOdd >= indexEven){
					break;
				}
			}
			//交换值
			int temp=num[indexOdd];
			num[indexOdd] = num[indexEven];
			num[indexEven] = temp;
		
		
	}
	
	}
}
