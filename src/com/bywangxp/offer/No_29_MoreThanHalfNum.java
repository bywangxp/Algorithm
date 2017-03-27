package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月26日 下午4:16:40 
 * @version   v1.0   
 * @quesetion 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *            例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *            由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @summary 
 *
 */
public class No_29_MoreThanHalfNum {
	public static void main(String[] args) {
		int []array={2};
		int moreThanHalfNum_Solution = MoreThanHalfNum_Solution2(array);
		System.out.println(moreThanHalfNum_Solution);
	}
	public static int MoreThanHalfNum_Solution(int [] array) {
		//方法1：使用快速排序的思想，因为有超过数组长度一半，则如果排序后，中间的数肯定就是它了
		//使用一个元素进行一次快速排序，如果这个数最终的位置=n/2；则正好，如果小于，则在右边找一个数继续排
		int solution1 = solution1(array,0,array.length -1);
		return solution1;
     }
	private static int solution1(int[] array, int start ,int end) {
		//进行一次快速排序
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
			while(array[j] >= temp && i < j){
				++i;
			}
			if(i < j){
				array[j--] = array[i];
			}
		}
		array[i] = temp;
		if(i == array.length / 2){
			System.out.println("i"+i);
			if(checkMoreThanHalf(array,array[i])){//一定要检查是否符合规定
				return array[i];
			}else{
				return 0;
			}
		}else if(i < array.length / 2){
			return solution1(array,i+1,end);
		}else{
			return solution1(array,start,i-1);
		}
	}
	public static boolean checkMoreThanHalf(int[] array , int number){
		int time = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == number){
				time++;
			}
		}
		boolean result = false;
		if(time > array.length / 2 ){//大于一半
			result =true;
		}
		return result;
	}
	//方法2:因为其他元素出现的次数，比这个数出现的次数之后都要高，可以设置两个变量，一个记录出现的元素
	//一个记录元素出现的次数，当我们遍历一个新的元素的时候，如果这个元素与之前元素相同，则次数+1；否则
	//次数-1；当次数减为0，则当前元素替换这个元素，次数设置为1；一直当最后，剩下的元素就是次数最多的。
	//同样要验证，输入的序列到底是不是满足条件的，只要验证剩下的元素次数是不是整个元素的一半以上
	
	 public static int MoreThanHalfNum_Solution2(int [] array) {
		 if(array == null || array.length == 0){
			 return 0;
		 }
		 int num = array[0];
		 int time = 1;
		 for(int i = 1;i < array.length;++i){
			 if(num == array[i]){
				 time++;
			 }else{
				 time--;
				 if(time == 0){
					 num = array[i];
					 time = 1;
				 }
			 }
			 
		 }
		 if(checkMoreThanHalf(array,num)){//一定要检查是否符合规定
				return num;
		  }else{
				return 0;
		  }
	  }
	
}
