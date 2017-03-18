package com.bywangxp.offer;

import java.math.BigInteger;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月18日 下午3:24:46 
 * @version   v1.0   
 * @quesetion 问题1:写一个函数，输入n，求出斐波那契数列的第n项；
 *                       0  n=0
 *                       1  n=1
 *            f(n-1)+f(n-2) n>1
 *            问题2:一只青蛙一次可以跳上1级台阶，也可以跳上2级，
 *            求该青蛙跳上一个n级台阶总共有多少种跳法
 * @summary 
 *            1级台阶 有一种跳法，二级台阶有2种跳法 讨论一般的情况，把n级台阶的跳法看成是n的函数，
 *            即为f(n),第一次有两种选择，跳1个台阶，剩下f(n-1),或者跳两个台阶，剩下f(n-2);
 *            f(n)=f(n-1)+f(n-2);
 */
	
public class No_09_Fibonacci {
	public static void main(String[] args) {
        BigInteger solution = solution2(100);
		System.out.println(solution);
	}
	public static int solution(int n){
		//递归的方法很多计算都是重复的，并且会出现调用栈溢出的情况
		if(n == 0){
			return 0;
		}
		if( n == 1){
			return 1;
		}
	    return solution(n-1)+solution(n-2);
	}
	public static BigInteger solution2(int n){
		//记录下中间结果，避免重复计算，设置一个result数组记录没个n的取值
		BigInteger []result=new BigInteger[n+1];
		result[0]=new BigInteger("0");
		result[1]=new BigInteger("1");
		if(n<0){
			System.out.println("error");
			return null;
		}
		if( n < 2){
			return result[n];
		}
		BigInteger minusOne=result[1];
		BigInteger minusTwo=result[0];
		for(int i=2;i<=n;++i){
			result[i]=minusOne.add(minusTwo);
			minusTwo=minusOne;
			minusOne=result[i];
		}
		return result[n];
		
	}

}
