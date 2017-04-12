package com.bywangxp.required.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月12日 下午2:32:42 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int []array = {4,4,4,4};
		solution(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
	}

public static void solution(int array[],int start,int end){
	if(start < end){
		int k = partion(array,start,end);//k为已经已排元素位置
		solution(array,start,k-1);
		solution(array,k+1,end);
		
		
	}
	
}

private static int partion(int[] array, int start, int end) {
	//默认存储末尾元素为要排的元素，设置两个指针，一个指向已排好的区域(元素值都比末尾元素小)，另一个指向待排的区域
//	次从头开始将待排元素与该元素比较，如果待排区域的元素比末尾元素比较，符合规定，则指针前进，如果不符合则交换元素
	int temp = array[end];
	int i = start -1;
	int j = i+1;
	for(; j < end; ++j){
		if(temp >= array[j]){//array[j]小于temp，则满足交换条件
			swap(array,++i,j);
		}
	}
	swap(array,++i,j);
	return i;
}

private static void swap(int[] array, int i, int j) {
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
}
	

//partion2 使用两个首末指针
public static void solution2(int array[],int start,int end){
	if(start < end){
		int k = partion2(array,start,end);//k为已经已排元素位置
		solution(array,start,k-1);
		solution(array,k+1,end);
		
		
	}
	
}

private static int partion2(int[] array, int start, int end) {
	int temp = array[start];
	while(start < end){
		while(start < end && array[end]>= temp){
			--end;
		}
		if(start < end){
			array[start++] = array[end];
		}
		while(start < end && array[start]<= temp){
			++start;
		}
		if(start < end){
			array[end--] = array[start];
		}
	}
	array[start] = temp;
	return start;
}
//非递归形式，实现快速排序
public static void solution3(int[] array, int start, int end){
	//递归方式，每次都是找到指定元素的位置，然后分别遍历其左右两边，可以使用栈来代替，记录
	//在这里中间变量也就是通过Pritation函数划分之后分成左右两部分的首尾指针，只需要保存这两部分的首尾指针即可。
	Stack<Integer> stack = new Stack<Integer>();
	stack.push(end);
	stack.push(start);
	while(!stack.isEmpty()){
		int left  = stack.pop();
		int right  = stack.pop();
		if(left < right){
			int k = partion(array,left,right);
			if(left < k){
				stack.push(k-1);
				stack.push(left);
			}
			if(right > k){
				stack.push(right);
				stack.push(k+1);
			}
		}
	}
}	
}
