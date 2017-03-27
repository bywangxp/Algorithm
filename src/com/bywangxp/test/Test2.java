package com.bywangxp.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月24日 下午7:38:55 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String solution = solution(scanner.nextLine());
			char[] charArray = solution.toCharArray();
			for(int i= 0;i<charArray.length;++i){
			   System.out.print(charArray[i]);
				
			}
		}
		
	}
	public static String solution(String str){
		String sequence="123456";
		if(str == null){
			return sequence;
		}
	
		char[] charArray = str.toCharArray();
		for(int i = 0;i< charArray.length; ++i){
			if(charArray[i] =='L' ){
				//向左转
				lAction(sequence);
			}else if(charArray[i] =='R'){
				//向右转
				rAction(sequence);
			}else if(charArray[i] =='F'){
				fAction(sequence);
			}else if(charArray[i] =='B'){
				bAction(sequence);
			}else if(charArray[i] =='A'){
			    aAction(sequence);
			}else if(charArray[i] =='C'){
				cAction(sequence);
			}
		}
		return null;
	}
	private static void aAction(String sequence) {
		//逆时针转
		swap(sequence,2,1); //前 到 右  后 到 左
		swap(sequence,0,3);
	}
	private static void cAction(String sequence) {
		//顺时针转
		swap(sequence,0,2); //前到左，后到右
		swap(sequence,1,3);
		
	}
	private static void fAction(String sequence) {
		//向前转
		swap(sequence,2,5); 
		swap(sequence,3,4);
	}
	private static void bAction(String sequence) {
		//向后转
		swap(sequence,2,4);//前 上  后 下
		swap(sequence,3,5);
	}
	private static void rAction(String sequence) {
		//向左转 上到左，下到右
		swap(sequence,0,4);
		swap(sequence,1,5);
	}
	private static void lAction(String sequence) {
		//向右转 
		//中间不动,上变成右，下变成左
		swap(sequence,3,4);
		swap(sequence,0,5);
	}
	private static void swap(String sequence , int i ,int j){
		
	}

}
