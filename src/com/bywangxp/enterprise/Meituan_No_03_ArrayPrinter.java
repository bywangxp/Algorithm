package com.bywangxp.enterprise;

import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月20日 下午8:22:07 
 * @version   v1.0   
 * @quesetion 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
              给定一个二位数组arr及题目中的参数n，请返回结果数组。
 * @summary 
 *
 */
public class Meituan_No_03_ArrayPrinter {
	public static void main(String[] args) {
		int [][]array={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[] arrayPrint = arrayPrint(null,0);
		System.out.println(Arrays.toString(arrayPrint));
	}
	public static int[] arrayPrint(int[][] arr, int n) {
        //下个数都是上一个数横坐标+1；纵坐标+1;得到的，界限是x,y=n,拆成两部分
		int array[]=new int[n * n];
		int w=0;
     	for(int j=n-1; j>=0;--j){
     	   int k=j;
           for(int i = 0;i < n ;){
             if(k < n && i < n){
            	     array[w++]=arr[i][k];
                 ++i;
                 ++k;
             }else{
            	 	break;
             }
          }
       }
       for(int i = 1; i < n ;++i){
        		int k=i;
        	 	for(int j = 0 ;j < n ;){
        	 		if(k < n && j < n){
        	 			array[w++]=arr[k][j];
                    k++;
                    j++;
                  }else{
              	 	break;
                  }
        	 	}
        }
        return array;
    }
}
