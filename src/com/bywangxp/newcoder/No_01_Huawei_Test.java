package com.bywangxp.newcoder;

import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月24日 下午5:31:23 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class No_01_Huawei_Test {
	
	    public static void main(String []args){
	        int flag = 0;
	        Scanner scanner = new Scanner(System.in);
	        int operate = Integer.MAX_VALUE;
	        int []grades = null;
	        StringBuffer sb = new StringBuffer();
	        
	        while(scanner.hasNext()){

	            if(flag == 0){
	                int n = scanner.nextInt();
	                grades = new int[n];
	                operate= scanner.nextInt();
	            }
	            if(flag == 1){
	                for(int i =0;i<operate;++i){
	                  //  opearate[i]=scanner.nextInt;
	                }

	            }
	            if(scanner.nextByte() == 'Q'){
	                
	            }
	            if(scanner.nextByte() == 'U'){
	                
	            }
	            if(flag == operate + 2){
	                System.out.println(sb.toString());
	            }





	            ++flag;          


	            
	        }
	        
	}
}
