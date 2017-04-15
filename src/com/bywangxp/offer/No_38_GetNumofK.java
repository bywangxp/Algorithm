package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月15日 下午7:51:54 
 * @version   v1.0   
 * @quesetion 统计一个数字在排序数组中出现的次数。
 * @summary 
 *
 */
public class No_38_GetNumofK {
	  public static void main(String[] args) {
		int []array ={1,3,5,6,7,8};	
		int num = GetNumberOfK(array,9);
		System.out.println(num);
	  }
	  public void solution(){
		  /**
		   * 优化的方法:本题麻烦的点是如何查找第一次出现k的位置，和最后一次出现的位置，如果采用方法一 顺序遍历的方法找，时间复杂度很大
		   * 所以想到优化的方法：寻找第一个最后一个同样适用二叉查找 ，查找条件是两个，首先中间位置的值是不是等于k，如果等于，判断前一个
		   * 值是否与它相等，如果不相等则这个位置的值就是第一个，反之继续，对与后一个数同理。
	       */
	  }
	  
	  
	  public static int GetNumberOfK(int [] array , int k) {
		  /**
		   * 方法1：利用二分查找，知道找到该元素，之后开始从当前位置往前往后找，直到找到第一个出现的位置，以及最后一个出现的位置
		   * 
		   */
		  int location = binaryFind(array,0,array.length-1,k);
		  if(location == -1){
			  return 0;//
		  }
		  int start = location - 1;
		  int end = location + 1;
		  while(start >=0 ){
			  if(array[start] == k){
				  start--;
			  }else{
				  break;
			  }
		  }
		  while(end <= array.length-1 ){
			  if(array[end] == k){
				  end++;
			  }else{
				  break;
			  }
		  }
	      return end -1 - start; 
	  }

	private static int binaryFind(int[] array, int start, int end ,int target) {
		  int mid = (start + end) / 2;
		  int location = -1;
		  if(start <= end){
			  if(array[mid] == target){
				  location = mid;
			  }else if(array[mid] < target){
				  location =  binaryFind(array,mid+1,end,target);
			  }else {
				  location =  binaryFind(array,start,mid-1,target);
			  }
		  }
		  return location;
	}
	
}
