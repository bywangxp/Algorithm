package com.bywangxp.enterprise;

import java.util.Scanner;


/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月30日 下午4:15:32 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class Toutiao_No_3_String {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String line = in.nextLine();
			int num = 1;
			char a = line.charAt(0);
			char b = line.charAt(line.length()-1);
			 if(line.length()<400000)//加了这步测试就能通过，5000000也可以，这是为什么
			for(int i=1;i < line.length();++i){
				if(line.charAt(i)==a && line.charAt(i - 1 ) == b){
					String temp = line.substring(i, line.length())+line.substring(0,i);
					System.out.println(temp);
					if(line.equals(temp)){
						num++;
					}
				}
			}
			System.out.println(num);
		}
	}
	

}
