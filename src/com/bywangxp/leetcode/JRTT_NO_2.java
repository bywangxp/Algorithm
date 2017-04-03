package com.bywangxp.leetcode;

import java.util.HashMap;
import java.util.Scanner;
public class JRTT_NO_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int target = in.nextInt(); 
			String []numData =new String[num];
			String []targetData =new String[target];
			for (int i = 0; i < num; i++) {
				numData[i] = in.nextLine().toLowerCase();
			}
			for (int i = 0; i < target; i++) {
				targetData[i] = in.nextLine().toLowerCase();
			}
			int []bingo = new int[num];
			for (int i = 0; i < target; i++) {
				String[] split = targetData[i].split(" ");
				int data = 0;
				for (String string : split) {
				
				}
				
				
			}
			
			
			
			HashMap<String, Integer> map = new HashMap<String,Integer>();
			for (int i = 0; i < num; i++) {
				String lowerCase = numData[i].toLowerCase();
				String[] split = lowerCase.split(" ");
				for (int j = 0; j < split.length; j++) {
					if(map.containsKey(lowerCase)){
						map.put(lowerCase, map.get(lowerCase)+1);
					}else{
						map.put(lowerCase, 1);
					}
				}
			
			}
			
			
			
			
			
			
			
		}
	}
	

}
