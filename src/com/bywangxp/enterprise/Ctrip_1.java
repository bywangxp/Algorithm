package com.bywangxp.enterprise;

import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月11日 下午6:54:53 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class Ctrip_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int array[]=new int[1000];
			int num = in.nextInt();
			int total = 0;
			int left =0;
			int l =0;
			for(int i=2;i<=num;i++){
				array[l++]=i;
				total+=i;
				if(total>num){
					total-=i;
					l--;
					left = num-total;
					break;
				}
			}
			for(int j =l-1;left>0;left--){
				array[j]++;
				j--;
				if(j<0){
					j=l-1;
				}
			}
			int sum =1;
			for(int i=0;i<=l-1;i++){
				sum*=array[i];
			}
			System.out.println(sum);
			
		}
	}
}
