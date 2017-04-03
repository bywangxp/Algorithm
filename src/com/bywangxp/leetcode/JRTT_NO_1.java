package com.bywangxp.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class JRTT_NO_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int []data =new int[num];
			for(int i=0;i<num;++i){
				data[i]=in.nextInt();
			}
			int start = -1;
			int end = 0 ;
			boolean flag =true;
			HashMap<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
			for(int i=0;i<num;++i){
				if(i+1<data.length && data[i]<data[i+1] && flag){
					System.out.println("开始增加"+data[i]);
					if(start == -1){
						start = i;
					}
					end = i;
					flag = false;
					continue;
				}
				if(i>0 &&i+1<data.length && data[i-1]>data[i] && data[i]<data[i+1]&& !flag){
					System.out.println("转折点"+data[i]);
					hashMap.put(start, i);
					flag = true;//新的开始
					start =i;
					continue;
				}
				if(i+1<data.length && data[i]<data[i+1] && !flag){
					System.out.println("上升"+data[i]);
					end++;
					continue;
				}
				
				if(i+1<data.length &&data[i]>data[i+1] && !flag){
					System.out.println("下降"+data[i]);
					end++;
					continue;
				}
			}
			System.out.println(hashMap.toString());
			int max = Integer.MIN_VALUE;
			int startFlag = Integer.MIN_VALUE;
			boolean tag = false;
			for(int i = 0;i<num;++i){
				if(hashMap.containsKey(i)){
					Integer integer = hashMap.get(i);
					int d =integer - i;
					if(d > max){
						startFlag = i;
						max = d;
						tag = true;
					}
				}
			}
			if(!tag){
				System.out.println(-1+""+-1);
			}else{
				System.out.println(startFlag+""+hashMap.get(startFlag));
			}
			
		
		}
	}
	

}
