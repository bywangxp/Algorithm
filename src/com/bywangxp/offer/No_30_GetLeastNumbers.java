package com.bywangxp.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月26日 下午7:41:29 
 * @version   v1.0   
 * @quesetion 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 *            则最小的4个数字是1,2,3,4,
 * @summary   使用快速排序的方法，需要改变原数组，如果不允许改变数组，则使用堆
 *
 */
public class No_30_GetLeastNumbers {
	//方法一：使用快速插入的partion方法，获取到第k个数，则在k左边的都是最小的k个数
	//时间超时
	public static void main(String[] args) {
		int []array ={4,5,1,6,2,7,3,8};
		ArrayList<Integer> list = GetLeastNumbers2(array,4);
		System.out.println(list.toString());
	}
	private static ArrayList<Integer> solution(int[] array, int k) {
		if(array == null || array.length < k ){
			return new ArrayList();
		}
		ArrayList<Integer> list =GetLeastNumbers(array,0,array.length-1,k);
		return list;
	}
 
	private static ArrayList<Integer> GetLeastNumbers(int[] array, int start, int end, int k) {
		int location = partion(array,start,end);
		while(true){
			if(location == k - 1){//如果是第k个数，下面越界
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int i = 0; i< k;++i){
					list.add(array[i]);
				}
				return list;
			}else if(location < k -1){
				location = partion(array,location + 1,end);
			}else{
				location = partion(array,start,location-1);
			}
		}
	}
	
	public static int partion(int []array, int start, int end){
		int temp = array[start];
		int i = start;
	    int j = end;
		while(i < j){
			while(array[j] >= temp && i < j){
				--j;
			}
			if(i < j){
				array[i++] = array[j];
			}
			while(array[i] <= temp && i < j){
				++i;
			}
			if(i < j){
				array[j--] = array[i];
			}
		}
		array[i] = temp;
		return i;
	}
	//方法2：使用堆结构(大顶堆)  数组从0开始，因为堆结构是一个完全二叉树结构 length代表最大的数组index,
	//postion是开始调整的位置,开始调整的位置为length/2 -1; length/2位置必然存在
	// 最关键步骤
	public static void adjustHeap(int []array,int position,int length){
		int temp;
		int child;
		///2 * position + 1 <= length 表示还有孩子，如果没有孩子就结束了
		for(temp = array[position]; 2 * position + 1 <= length; position = child){
			child = 2 * position + 1;
			if(child < length && array[child+1] > array[child]){//如果有右孩子，找到最大的孩子
				child = child + 1;
			}
			if(temp < array[child]){
				array[position] = array[child];
			}else{
			    //array[position] = temp;不放在这，因为结束循环的条件可能是越界了
				break;//结束
			}
		}
		array[position] = temp;//统一处理temp；
	}
	private static ArrayList<Integer> GetLeastNumbers2(int[] array,int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array == null || k > array.length || array.length == 0){
			return list;
		}
		 //生成k个结点大顶堆
		for(int position = k / 2 -1 ;position >= 0; -- position){
			adjustHeap(array, position, k);
		}
		//开始从第k个元素开始遍历
		for(int index = k;index < array.length;++index){
			if(array[0] > array[index]){
				//交换值
				int temp = array[0];
				array[0] = array[index];
				array[index] = temp;
				adjustHeap(array, 0, k-1);
			}
		}
		for(int i = 0; i<k;++i){
			list.add(array[i]);
		}
		return list;
	}
}
