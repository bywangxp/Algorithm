package com.bywangxp.offer;

import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月13日 下午8:46:19 
 * @version   v1.0   
 * @quesetion 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的
 *            逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007 (题目保证输入的数组中没有的相同的数字)
 * @summary 
 *
 */
public class No_36_Inversepairs {
	public static void main(String[] args) {
		int array[]=null;
		int num = InversePairs(array);
		System.out.println(num);
	}
	 public static int InversePairs(int [] array) {
		 if(array == null){
			 return 0;
		 }
		 /**
		  * 方法：使用分治方法，将数组拆成一个个的子数组，知道数组大小为1，一边统计逆序数，一边进行排序操作，
		  * 核心思想就是：先统计两个数组内部的逆序数，两个数组之间的逆序数，进行排序是以免已经算过逆序数的数重新计算。
		  * 同时内部排序，对外部的逆序数个数是没有影响的
		  * 与归并merger一样，不同的是在拷贝完，做好准备工作后，从数组末尾开始往原数组中填充数据，规则：设置两个指针，分别
		  * 指向拷贝的两个数组中的末尾，case1：如果前一个数组指针处的大小大于后一个数组指针的大小则，逆序数为整个后一个数组的长度
		  * 同时取这个最大值放入原数组，指针前进，case2：如果小于，则取最大值赋值数组，且后一个指针向前进，
		  */
		 int solution = solution(array,0,array.length-1);
	     return solution ; 
	 }

	private static int solution(int[] array, int i, int j) {
		if(i < j){
			int mid = (i+j)/2;
			int k1 = solution(array,i,mid) %1000000007;
			int k2 = solution(array,mid+1,j) %1000000007;
			int k = merger(array,i,mid,j);//内部的逆序数；
			return k1+k2+k % 1000000007;
		}
		return 0;
	}

	private static int merger(int[] array, int start, int mid, int end) {
		int[] array1 = Arrays.copyOfRange(array, start, mid+1);
		int[] array2 = Arrays.copyOfRange(array, mid+1,end+1);
		//System.out.println("array1"+Arrays.toString(array1));
		//System.out.println("array2"+Arrays.toString(array2));
		int i=array1.length-1,j=array2.length-1;
		int count = 0;//记录逆序数的个数
		for(int k=end; k>=start; --k){
			if(i>=0 && j>=0 && array1[i] > array2[j]){
				count+=j+1;
				if(count >= 1000000007){//一定要有
					count %=1000000007;
				}
				
				array[k] = array1[i--];
			}else if(i>=0 && j>=0 && array1[i] < array2[j]){
				array[k] = array2[j--];
			}else if(i <0 && j >= 0){
				array[k] = array2[j--];
			}else if(j <0 && i >= 0){
				array[k] = array1[i--];
			}
		}
		//System.out.println("count"+count);
		//System.out.println("array"+Arrays.toString(array));
		return count;
	}
	

}
