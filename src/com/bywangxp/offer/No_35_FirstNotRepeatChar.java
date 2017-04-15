package com.bywangxp.offer;

import java.util.HashMap;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月28日 下午10:33:15 
 * @version   v1.0   
 * @quesetion 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。如果字符串为空,返回-1
 * @summary 
 *
 */
public class No_35_FirstNotRepeatChar {
	public static void main(String[] args) {
		int firstNotRepeatingChar = FirstNotRepeatingChar("123");
		System.out.println(firstNotRepeatingChar);
	}
	//最直观的方法，建立一个hashMap存储着只出现一次的字符，遍历完成后在从新遍历一次，找到第一个存在于链表里的结果
   public static int FirstNotRepeatingChar(String str) {
	   if(str == null || str==""){
		   return -1;
	   }
	   char[] charArray = str.toCharArray();
	   HashMap<Character, Integer> hashMap = new HashMap<Character,Integer>();
	    int i = 0;
		for (char c : charArray) {
			if(hashMap.containsKey(c) && hashMap.get(c) !=-1 ){
				hashMap.put(c, -1);//重复出现发生第一次，设置标志位，后面的重复不做修改
			}else if(!hashMap.containsKey(c)){
				hashMap.put(c, i);
			}
			i++;
		}	   
		for (char c : charArray) {
			if(hashMap.get(c) != -1){
				return hashMap.get(c);
			}
		}
		return -1;
	   
    }
   //方法2 使用ArrayList，一步步的遍历
}
