package com.bywangxp.enterprise;

import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月30日 下午3:32:46 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
//3 10 6 5 10
public class TouTiao_No_2_YiHuo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int target = in.nextInt();
			int []data = new int[num];
			for(int i= 0; i < num;++i){
				data[i] = in.nextInt();
			}
			int many = 0;
			for(int i= 0; i < num;++i){
				for(int j = i + 1; j< num;++j){
					if(data[i] + data[j]< target ){
						continue;
					}
					int a = data[i] ^ data[j];
					//System.out.println("data[i]:"+data[i]+"  data[j]:"+data[j] +"="+a);
					if((data[i] ^ data[j]) > target){
						++many;
					}
				}
			}
			System.out.println(many);
			
		}
	}
	public boolean check(int num1, int num2,int target){
		int k = 0x80000000;
		boolean flag = false;
		while(!flag){
			if((num1 & k) == 0 && (num1 & k) == 0 ){
				k = k>>>1;
			}
		}
		//
		return false;
	}

}
