package com.bywangxp.required.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月14日 下午9:36:40 
 * @version   v1.0   
 * @quesetion 归并排序
 * @summary 
 *
 */
public class MergeSort {
	/*归并排序的方法就是一直从中间开始拆分数组，知道拆到数组大小唯一，后每个数组都是排好序的，然后调用合并方法，
	 * 合并方法是针对两个已经排好序的数组，进行排序
	 *
	 */
	public static void main(String[] args) {
		int array[]={1,3,2,4,1,10,-1};
		solution(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
	}
	public static void solution(int []array,int start,int end){
		if(start < end){
			int mid = (end + start)/2;
			solution(array,start,mid);
			solution(array,mid+1,end);
			merger(array,start,mid,end);
		}
	}

	private static void merger(int[] array, int start, int mid, int end) {
		//归并方法：分别设置两个数组暂存两个已拍好序的数组，技巧，数组大小分别多申请一个；
		//多的一个作为结束标志，设置这个末尾值Max，这样当单个数组结束，就不需要判断了，继续下去，自动结束
		int length1 = mid-start +1;
		int length2 = end - mid;
		int array1[]= new int[length1+1];
		int i = 0;
		for (; i < length1; i++) {
			array1[i] = array[start+i];
		}
		array1[length1]=Integer.MAX_VALUE;
		int array2[]= new int[length2+1];
		for (i = 0; i < length2; i++) {
			array2[i] = array[mid+1+i];
		}
		array2[length2]=Integer.MAX_VALUE;
		i = 0;
		int j = 0;
		
		for(int k = start; k <= end; ++k){
			if(array1[i] <= array2[j]){
				array[k]=array1[i++];
			}else{
				array[k]=array2[j++];
			}
		}
		
		
		
	}

}
