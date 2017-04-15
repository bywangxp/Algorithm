package com.bywangxp.enterprise;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class JingDong_no_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			String str = in.next();
			char[] data = str.toCharArray();
			int total = 0;
			for(int i=0;i<num;++i){
				System.out.println(Arrays.toString(data));
				int start;
				int end;
				if('0'<data[i] && data[i]<='9'){
					int extra = data[i] - '0';
					System.out.println(extra);
					start = i -extra;
					end = i + extra;
					if(i-extra < 0){
						start = 0;
					}
					if(end >= num){
						end = num-1;
					}
					System.out.println("extra"+extra+"start"+start+"end"+end);
					int k =start;
					while(k<=end){
						if(data[k]=='X'){
							System.out.println("k="+k);
							data[k] = 'Q';
							total++;
							
						}
						k++;
					}
				}
			}
			System.out.println(total);
		}
	}

}
