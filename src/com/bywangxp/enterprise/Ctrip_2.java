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
public class Ctrip_2 {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	      
        String numbers = new String();
        for(int rows=3; rows>0; rows--){
            for(String n: scan.nextLine().split(" ")){
                numbers += n;
            }
        }
 
	}
	 static int maxProfit(int[] stockPrices, int k) {
		 if(stockPrices == null || stockPrices.length<=1){
			 return 0;
		 }
		 int b0=-stockPrices[0],b1 = b0;
		 int s0=0,s1=0,s2=0;
		 for(int i=1;i<stockPrices.length;i++){
			 b0=Math.max(b1, s2-stockPrices[i]);
			 s0=Math.max(s1, b1+stockPrices[i]);
			 b1=b0;
			 s2=s1;
			 s1=s0;
		 }
		 return s0;
	       


	    }
	
}
