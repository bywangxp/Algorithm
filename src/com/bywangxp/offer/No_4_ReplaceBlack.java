package com.bywangxp.offer;

import java.util.Arrays;

public class No_4_ReplaceBlack {
	
	/**
	 * @author    作者bywangxp  E-mail: bywangxp@mail.ustc.edu.cn
	 * @date      创建时间：2017年3月16日 下午8:35:55 
	 * @version   v1.0   
	 * @quesetion 面试题4：请实现一个函数，把字符串中的每一个空格替换成 %20
	 * @summary   要清醒的注意到在分析得知字符数组会变长的时候，内存覆盖问题。
	 */
	
	public static void main(String[] args) {
		String str="";
		char[] solution = solution(str.toCharArray(),str.length());
		System.out.println(Arrays.toString(solution));
	}
	
	public static  char [] solution(char string[],int length){
//	本题的考点是将字符数组的空格位置体会成%20，因为是char，所以需要在替换过程中需要移位操作
//  如果选择从头到尾开始替换空格，那么最差情况的时间复杂度是O(n2),最好的解法是从后往前替换
//		
//	 1.向遍历数组，得到空格的个数，算出最好总的数组的大小，
		if(length<0){
			return null;
		}
		int i=0;
		int num=0;//记录空格的个数
		while(i<length){
			if(string[i]==' '){
				num++;
			}
			i++;
		}
		System.out.println(num);
//   2.设置两个指针，一个指向原来的字符数组末尾，另一个指向，扩展后的字符数组末尾
		i=length-1;
		char []result=new char[length+2*num];//每个空格大小只需要增加两个
		int j=result.length-1;
//   3.i从后往前遍历，case1：如果当前字符是非空字符，则符合字符到result中，同事指针向前
//		case2：如果是空字符，则result分别向前赋值，j++，i也向前进一隔
		while(i>=0){
			if(string[i] == ' '){
				result[j--]='0';
				result[j--]='2';
				result[j--]='%';
				i--;
			}else{
				result[j--]=string[i--];
			}
		}
		return result;
	}

}
