package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月18日 下午7:55:18 
 * @version   v1.0   
 * @quesetion 实现一个函数power(double base,int exponent),求base的exponent次方
 *            不得使用库函数，同时不需要考虑大整数
 * @summary   要考虑底数为0，指数为负数的情况，抛出异常。
 *            也要考虑到可以优化的地方，使用递归的方式。
 *            判断double值相等，只能是在一定的范围内相等。
 *
 */
public class No_11_Power {
	public static void main(String[] args) throws Exception {
		double power = power(2,-2);
		System.out.println(power);
	}
	public static double power(double base,int exponent) throws Exception{
		if( exponent == 0){//规定0的0次方为1，没有数学意义
			return 1;
		}
		int flag = 0;//设置标志 指数为负数
		if(exponent < 0){
			flag = 1;
			exponent=-exponent;
		}
		if(exponent == 0){
			return 1;
		}
		if(base == 0 && flag ==1){
			throw new Exception("0的负次幂");
		}
		double sum = PowerWithExponent(base ,exponent);
//		double sum =Recursiving(base,exponent);
		
		if(flag == 1){
			sum = 1 / sum ;
		}
		if(base < 0 && (exponent % 2 )== 0){
			sum = -sum;
		}
		return sum;
	}
	private static double PowerWithExponent(double base, int exponent) {
		double sum=1;//注意这里sum=1；这样当指数为1，也直接进行计算等于本身
		for(int i = 1;i<= exponent; ++i){
			sum = sum * base;
		}		
		return sum;
	}
	//使用递归的方式，提高计算效率
	public static double Recursiving(double base, int exponent){
		//当指数为偶数，可以拆为两个exponent/2幂相乘，如果为奇数可拆为exponent-1/2 相乘再乘一个base
		//所以想到递归 递归的结束条件是 0 则为1，1则为本身
		if(exponent == 0){
			return 1;
		}
		if(exponent == 1){
			return base;
		}
		double result=Recursiving(base, exponent / 2) * Recursiving(base, exponent / 2);
		int temp=exponent & 1;
		if(temp == 1){
			result=result*base;
		}
		return result;
		/*if(exponent % 2 == 0){//如果为偶数
			return Recursiving(base, exponent / 2) * Recursiving(base, exponent / 2);
			
		}else{
			return Recursiving(base, exponent / 2) * Recursiving(base, exponent / 2) * base;
			
		}*/
	}

}
