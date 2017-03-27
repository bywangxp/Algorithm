package com.bywangxp.offer;

import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月26日 下午9:30:27 
 * @version   v1.0   
 * @quesetion 输入一个整型数组，数组里有正数，也有负数，数组中一个或者连续的多个整数构成一个数组。
 *            求所有子数组的和的最大值。要求时间复杂度是O(n);
 * @summary 
 *
 */
public class No_31_FindGreatSumOfSubArray {
	public static void main(String[] args) {
		int []array ={1,-2,3,10,-4,7,2,-5};
		int solution2 = solution2(array);
		System.out.println(solution2);
	}
	 public static int solution(int[] array) {
		 //使用动态规划，设置f(n)为第n个数之前的最大值，有两个选择，包括当前值和不包括当前值发
		 //f(n-1)+array[n]        当f(n-1)大于0  
		 //array[n]               当f(n-1)<0或者n=0；
		 if(array == null){
			 return 0;
		 }
		 int []MaxSubNum = new int[array.length];
		 FindGreatSumOfSubArray(array,0,MaxSubNum);
		 System.out.println(Arrays.toString(MaxSubNum));
		 int max = array[0];
		 for(int i =1; i<MaxSubNum.length;++i){
			 if(max <MaxSubNum[i]){
				 max= MaxSubNum[i];
			 }
		 }
		 System.out.println(max);
		 return max;
	 }

	private static void FindGreatSumOfSubArray(int[] array, int i, int[] maxSubNum) {
		while(i<array.length){
			if(i == 0 || maxSubNum[i-1] <= 0){
				maxSubNum[i] = array[i];
			}else{
				System.out.println(maxSubNum[i-1]);
				maxSubNum[i] = maxSubNum[i-1]+array[i];
			}
			++i;
		}
	}
	//方法2：设置两个数，第一个数记录累加的最大的部分和，第二数记录当前的最大和
	public static int solution2(int []array){
		if(array == null || array.length == 0){
			return 0;
		}
		int curSum = array[0];
		int maxCurSum = curSum;
		for(int i =1; i< array.length;++i){
			if(curSum < 0){//如果之前累计都是负数的话，则舍弃之前的
				curSum = array[i];
			}else{
				curSum = curSum + array[i];//虽然可能array[i]可能为负数，使得curSum比之前的小，但是需要记录下来，可能会在后面有用
			}
			if(curSum > maxCurSum){
				maxCurSum = curSum;
			}
		}
		return maxCurSum;
	}
}
