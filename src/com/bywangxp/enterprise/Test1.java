package com.bywangxp.enterprise;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月24日 下午7:03:00 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			String reverseAdd = reverseAdd(a, b);
			System.out.println(reverseAdd);
		}
	}
	public static String reverseAdd(int a, int b){
		if(a >70000 || a < 1){
			return "-1";
		}
		if(b >70000 || b < 1){
			return "-1";
		}
	 String a1 = change(a);
	 System.out.println(a1);
	 BigInteger a2 = new BigInteger(a1);
	 String b1 = change(b);
     BigInteger b2 = new BigInteger(b1);
	 return a2.add(b2).toString();
	}

	private static String  change(int a) {
		StringBuffer sb = new StringBuffer();
		while(a / 10 != 0){
			sb.append(a % 10);
			a= a / 10;
		}
		if(a != 0){
			sb.append(a);
		}
		//去掉前道0
		String string = sb.toString();
		char[] charArray = string.toCharArray();
		int i = 0;
		for(;i < charArray.length;++i ){
			if(charArray[i] == '0'){
				i++;
			}else{
				break;
			}
		}
		char[] copyOfRange= null;
		if(i == charArray.length){
			return "0";
		}else{
			return  string.substring(i, string.length());
		}
	}

}
