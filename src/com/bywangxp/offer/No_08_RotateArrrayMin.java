package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月18日 下午2:26:00 
 * @version   v1.0   
 * @quesetion 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *            输入一个递增排序的数组的一个旋转，输出旋转该数组的最小元素
 * @summary 
 *            因为旋转后的两部分都是有序的，所以相当二分排序（基于部分有序）；且前一段数组的值比后一段大
 *            考察特例：三个元素相同不能判断中间元素是属于前者还是后者，整个数组本身就是有序的情况
 */
public class No_08_RotateArrrayMin {
		public static void main(String []args){
			int []array = {1};
			int solution = solution(array);
			System.out.println(solution);
			
		}
        	/*
        	 * 方法：设立两个指针，分别指向第一个排序数组的第一个元素，和第二个排序数组的最后一个元素
	     * 发现最小元素是这两部分数组的中间界限，且第一个指针的值大于等于第二个指针的值（除了对已排序的旋转），
	     * 取数组的中间元素，如果中间元素比第一个指针的元素大于
	     * 或者等于的话，则中间元素属于第一个排序数组（有特殊情况），此时第一个指针指向中间元素，反之则
	     * 第二个元素指向中间元素，循环结束的条件是两个指针间隔，则第二个指针也就是中间元素
	     * 考虑两个特殊情况
	     * 1：第一个就是如果原来的数组就是有序的咋办，只要判断第一次两个指针指向的值，如果前面比后面小，
	     * 则直接输出
	     * 2：考虑刚刚说的特殊情况，也就是10111，11101 无法确认中间元素是第一个数组，还是第二个数组，
	     * 也就是三个元素相等，无法判断中间元素是第一个数组，还是第二个数组
        	 * 
		   */
		public static int solution(int array[]){
			if(array == null || array.length == 0){
				System.out.println("error");
				return 0;
			}
			int i= 0 , j = array.length-1;
			if(array[i] < array[j]){//第一种特殊情况
				return array[0];
			}
		    while(i + 1 != j){//中间元素
		    		int mid = (i + j)/ 2;
		    		if(array[i] == array[mid] && array[mid] == array[j]){//第二种特殊情况
		    			//顺序查找
		    			int min = array[i];
		    			for(; i<=j ;i++){
		    				if(min > array[i]){
		    					min=array[i];
		    				}
		    			}
		    			return min;
		    		}else{
		    			if(array[mid] >= array[i]){
		    				i=mid;//中间元素比第一个指针都要大或者等于，则中间元素属于第一个数组
		    			}else{
		    				j=mid;
		    			}
		    		}
		    	
		    }
		    return array[j];
		}
	 
		
		
		
		
		
		
		
		
		
	

}
