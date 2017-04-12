package com.bywangxp.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月6日 下午3:00:36 
 * @version   v1.0   
 * @quesetion 多组（不超过 5 组）数据。
每组输入数据分为三行，第一行有两个数字 n,m($0＜n,m\leq10000$)，分别表示集合 A 和集合 B 的元素个数。后两行分别表示集合 A 和集合 B。每个元素为不超出 int 范围的整数，每个元素之间有一个空格隔开。
 * @summary 
 *
 */
public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int numA = in.nextInt();
			int numB = in.nextInt();
			HashSet<Integer> hashSet = new HashSet<Integer>();
			for(int i = 0;i<numA+numB;++i){
				hashSet.add(in.nextInt());
			}
			Object[] array = hashSet.toArray();
			int []arr = new int[array.length];
			for(int i=0;i<array.length;++i){
				arr[i]=(int)array[i];
			}
			Arrays.sort(arr);
			
			String str= "";
			for(int i=0;i<arr.length;++i){
				str+=arr[i]+" ";
			}
			int lastIndexOf = str.lastIndexOf(" ");
			System.out.println(str.substring(0,lastIndexOf));
//			for(int i=0;i<array.length;++i){
//				System.out.print(arr[i]+" ");
//			}
//			String string = hashSet.toString();
//			string =string.substring(1,string.length()-1);
//			String[] split = string.split(",");
//			int [] temp =new int [split.length];
//			for (int i = 0; i < split.length; i++) {
//				temp[i]=Integer.valueOf(split[i].trim());
//			}
//			Arrays.sort(temp);
			String str1= "";
			for(int i=0;i<arr.length;++i){
				str+=arr[i]+" ";
			}
			int lastIndexOf1 = str.lastIndexOf(" ");
			System.out.println(str.substring(0,lastIndexOf));
			
		}
		
	}

}
