package com.bywangxp.offer;

import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月13日 下午7:32:18 
 * @version   v1.0   
 * @quesetion 把只包含素因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 
 *            习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @summary   第二种方法，不需要在非丑数上进行处理，所以时间效率显著提高，缺点是，用空间换时间
 *
 */
public class No_34_GetUglyNumber {
	public static void main(String[] args) {
		int getUglyNumber_Solution = solution(0);
		System.out.println(getUglyNumber_Solution);
	}
	//首先找到丑数，从2，3，5分别整除当前数，直到除不尽，换下一个数继续，到最后结果为1，则代表该数为丑数
	//该方法超时的原因是对每一个数都去判断是不是丑数，时间复杂度太大。
	  public static int GetUglyNumber_Solution(int num) {
		  if(num <= 0){
			  return 0;
		  }
		  int count = 0;//第k个丑数
		  int time = 0;//记录数字 从1到K
		  while(count != num){
			  int index = ++time;
			  while(index % 5==0){
				  index = index / 5;
			  }
			  while(index % 3==0){
				  index = index / 3;
			  }
			  while(index % 2==0){
				  index = index / 2;
			  }
			  if(index == 1){
				  ++count;
			  }
		  }
		  return time;
	    }
	  //方法2：建立一个数组，数组中代表着从小到大的丑数，当前数组的下一个丑数，产生来源自，前面的某个数乘以2，或3，或5
	  //所以只需要分别找到第一个比当前数组最大值大的数，记录为M2，M3，M5中找最小的那个。在前面的数中存在一个位置T2，T3，T5
	  //代表在该位置之前的数乘以2，3，5都比当前最大值小，后面都是比当前最大值大的位置
	  public static int solution(int num){
		  if(num <= 0){
			  return 0;
		  }
		  int [] data = new int[num];
		  data[0] = 1;
		  for(int i=1;i<data.length;++i){
			  int max2 = getMax(data,i,2);
			  int max3 = getMax(data,i,3);
			  int max5 = getMax(data,i,5);
			  max2 = max2 > max3 ? max3 : max2;
			  max2 = max2 > max5 ? max5 : max2;
			  data[i]=max2;
		  }
		//  System.out.println(Arrays.toString(data));
		  return data[num-1];
	  }
	private static int getMax(int []data, int i, int num) {//num代表乘数
		int max = data[i-1];
		int total = 1;
		for(int k=0;k < i; ++k){
			//System.out.println("比较中");
			total = num * data[k];
			if(total > max){//这种情况必然发生
				break;
			}
		}
		return total;
	}
}
