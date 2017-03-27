package com.bywangxp.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月24日 下午10:26:25 
 * @version   v1.0   
 * @quesetion 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
			{1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列, 
			{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
			现在给出一个数字序列，允许使用一种转换操作：
			选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
			现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列
 * @summary 
 *
 */
public class Wangyi_No_1_Min {
	//设置两个指针，分别指向第一个和最后一个元素，如果第一个元素比最后一个元素大，则两个后两个元素合并一直重复下
  @SuppressWarnings("resource")
public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  int flag = 0;
	  int n = 0;
	  int index = 0;
	  int []item =null;
	  while(scanner.hasNext()){
		  String str = scanner.next();
		  n = Integer.valueOf(str);
		  item =new int[n];
		  for(int i = 0; i < n;++i){
			  item[i] = Integer.valueOf(scanner.next());
		  }
	  }
}
}
