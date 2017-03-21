package com.bywangxp.dynamic;

import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月21日 上午10:18:03 
 * @version   v1.0   
 * @quesetion 给定N个矩阵的序列（A1A2A3A4A5），计算乘积；
 *            矩阵乘法问题：给定n个矩阵的，矩阵Ai的规模为pi-1*pi(1<=i<=n),求完全括号化问题
 *            完全括号化：它是单一矩阵，或者是两个完全括号化矩阵的乘积，且已外加括号
 * @summary 
 *
 */
public class No_1_Matrix_Mutilple {
	 /* 步骤1.刻画一个最优解构成的结构特征
	  * 假设最优化方案的分割点在Ak和Ak+1的位置，那么接下来对A1-Ak和Ak+1到An
	  * 之间采用独立求解它的最优解问题
	  * 步骤2：递归的定义一个最优解的值
	  * 定义m[i,j]表示计算Ai。。Aj的进行乘法运算的计算量
	  * 定义S[i,j]表示在取m[i,j]时的分割点。
	  * 	将矩阵转化为p0p1p2p3p4p5p6的序列，
	  * i<=j;
	  * i=j    0
	  * i<j   min{m[i,k]+m[k+1,j]+pi-1*pk*pj}
	  * 
	  * 
	  *
	  *
	  *
	  *
	  */
	public static void main(String[] args) {
		int []p={30,35,15,5,10,20,25};//共有p.length-1个数组
		int l=p.length-1;//表示矩阵的个数
		int [][]s = new int[l][l];//表示在取m[i,j]时的分割点。
		int [][]m = new int[l][l];//表示在取m[i,j]最小的代价。
		solution(p,s,m);
		for(int i=0;i<s.length;++i){
			System.out.println("s:"+Arrays.toString(s[i]));
		}
		for(int i=0;i<m.length;++i){
			System.out.println("s:"+Arrays.toString(m[i]));
		}
	}
	public static void solution(int []p,int m[][],int s[][]){
		int l=p.length-1;//表示矩阵的个数
		for(int i=0;i<l;++i){
			m[i][i] = 0;//当i=j。0
		}
		for(int chain = 2;chain < l;++l){//表示矩阵链的长度
			for(int i = 0;i < l-chain+1 ;++i){
					int j = i + l -1;
					m[i][j] = Integer.MAX_VALUE;
					for(int k =i ;k < j ; ++k){
						int cost = m [i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
						if(cost < m[i][j]){
							m[i][j]=cost;
							s[i][j]=k;
						}
					}
			}
		}
	}
	public static void print_optimal(int s[][],int i,int j){
		if(i == j){
			System.out.println("A"+i);
		}else{
			System.out.println("(");
			print_optimal(s, i, s[i][j]);
			print_optimal(s,s[i][j]+1,j);
			System.out.println(")");
		}
		
	}
}
