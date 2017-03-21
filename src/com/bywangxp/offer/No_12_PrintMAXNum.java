package com.bywangxp.offer;

import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月18日 下午8:54:01 
 * @version   v1.0   
 * @quesetion 输入数字n，按顺序打印出从1最大的n位十进制数。
 * @summary 
 *
 */
public class No_12_PrintMAXNum {
	public static void main(String[] args) {
		solution(5);
	}

	/*
	 * 本题应该使用一个增加的函数，一个输出的函数，
	 * 因为没有指定n的位数，所以很可能会超过int的范围，考虑用字符数组来操作。
	 * 难点：判断输出到达上界，方法是当在最高位，发生越界也就是结束了；
	 * 注意：初始化数组时，将数组初始化为0，在输出时，需要将前导0去除。
	 * 模拟加法的操作，每次增加都是从第一位开始遍历+1；然后当该位数字
	 * 大于10的时候，开始产生进位，增加结束就break；
	 * 
	 * */
	public static void solution(int n){
		char []num=new char[n];
	    //初始化字符数组为'0'
	    for(int i = 0; i < num.length; ++i){
	    		num[i] ='0';
	    }
	    while(!add(num)){
	    		print(num);
	    }
	}
	public static boolean add(char []num){
		int nTakeOver = 0;//进位标识符，
		boolean isOverflow = false;
		for(int i = num.length - 1; i >= 0; --i){
			int data = num[i] - '0'  + nTakeOver;//每位都添加上进位，代表当前值
			//System.out.println(data);
			if(i == num.length - 1){
				data = data + 1; //只在第一位+1；
			}
			if(data >= 10){
				if(i == 0 ){//判断是否到达最高位，当加上进位大于等于10，且最高位则产生越界，整个输出都结束
					isOverflow = true;
				}else{
					nTakeOver = 1;
					num[i] =(char)(data - 10 + '0');
				}
			}else{
				num[i] =(char) (data + '0');//没有产生进位，则增加结束
				break;
			}
		}
		return isOverflow;
	}
	public static void print(char []num){
		//去掉前导0
		int i = 0;//记录第一个非0的位置
		boolean flag = false;//设置标志位 flase代表前面都是0
		for(;i < num.length ; ++i){
			//去掉前导0
			if(!flag && num[i] != '0'){
				flag =true;//当flag=true，则表示从当前位开始都不是0了
			}
			if(flag){
				System.out.print(num[i]);
			}
		}
		System.out.println();
	    
		
	}
	
}
