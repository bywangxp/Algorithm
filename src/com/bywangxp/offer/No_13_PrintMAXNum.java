package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月18日 下午8:54:01 
 * @version   v1.0   
 * @quesetion 输入数字n，按顺序打印出从1最大的n位十进制数。
 * @summary 
 *
 */
public class No_13_PrintMAXNum {
	public static void main(String[] args) {
		solution(3);
	}
	//因为没有指定n的位数，所以很可能会超过int的范围，考虑用字符串来操作。
	public static void solution(int n){
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; ++i){
			sb.append("0");
		}
		//首先初始化字符串，高位置0；
		for(int i = 0 ; i < n ;++ i){
			for( int j = 0 ; j < 9 ; ++j){
				System.out.print(sb.toString()+", ");
				System.out.println(sb.charAt(i)-'0'+1);
				sb.replace(i, i+1, sb.charAt(i)-'0'+1+"");
			}
			sb.replace(i, i+1, "0");
		}
		
		
		
	}
	private static void StringBuilder() {
		// TODO Auto-generated method stub
		
	}
	
}
