package com.bywangxp.enterprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Qunar_No_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String init = in.nextLine();
			String target = in.nextLine();
			String nextLine = in.nextLine();
			HashMap<String,Integer> map=new HashMap<String,Integer>();
			String[] array = nextLine.split(" ");
			for (int i = 0; i < array.length; i++) {
				map.put(array[i], 1);
			}
			int solution = solution(init,target,map,0);
			System.out.println(solution);
		}	
	}
	private static int solution(String init, String target, HashMap<String, Integer> map,int time) {
	   if(!target.equals(init)){
		   Set<String> set = map.keySet();
		   Iterator<String> it = set.iterator();
		   int temp =time;
		   while(it.hasNext()){
			   String next = it.next();
			   if(map.get(next)==1){//没被访问过，
				   boolean flag = diff(init,next);
	    	           if(flag == true){//满足条件,访问
		    	    	         map.put(next, 0);//满足条件访问
		    	    	         int num1 = solution(next,target,map,time+1);
		    	    	         temp = time +1;
	    	            }
			   }
	      }
		   return temp;
	}else{
		return time;
	}
	}


	private static boolean diff(String init, String string) {
		int num = 0;
		char[] int1 = init.toCharArray();
		char[] str = string.toCharArray();
		for (int i = 0; i < str.length; i++) {
			if(int1[i] != str[i]){
				num++;
				if(num > 1){
					return false;
				}
				
			}
		}
		return true;
	}
	
	
}
