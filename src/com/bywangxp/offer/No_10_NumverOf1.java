package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月18日 下午4:31:37 
 * @version   v1.0   
 * @quesetion 请实现一个函数，输入一个整数，输出该数二进制表中1的个数，
 * @summary   solution2：可以借鉴，不移动整数，改为左移1，如果整数对应位置为1，则中间值不为0
 *            结束条件是1移动后结果为0，也就是移动到了字节的末尾
 *            soution1: 把一个整数减去1以后得到的结果与原来的结果相与，得到的结果相对于是把整个
 *            二进制表示中的最右边1变成0。很对问题都可使用本方法解决。
 *            比如:如果判断一个数是不是2的整数次，只要判断是不是只有一个1，使用上面的方法，只要相
 *            与结果为0，则满足要求。
 *            
 *
 */
public class No_10_NumverOf1 {
	public static void main(String[] args) {
		int solution = solution1(-1);
		System.out.println(solution);
	}
	
	public static int solution1(int x){
		//方法：考虑一个特殊的现象：数n 与 n-1 相与的情况，得到的结果是右边第一个1被消除
		int count = 0;
		while(x != 0){
			x=(x-1) & x;
			count++;
		}
		return count;
		
		
		
	}
	
	public static int solution2(int x){
		//不一定 x ，改为移动1，因为可能int 类型有多少位组成，在不同的机子上不同，所以
		int flag = 1;
		int count = 0;
		while(flag != 0){
			int temp = x & flag;
			if(temp != 0){
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	public static int solution3(int a){
		int num = 0;
		int time =0;
		while( num < 32){
		  int c = a & 1; 
		  if(c == 1){
			  time++;
		  }
		  a= a>>1;
		  num++;
		}
		return time;
	}
	public static int solution4(int n){
		// 因为n可能为负数，所以只能使用 >>>  
		int count = 0;
		while(n != 0){
			int k= n & 1;
			if (k == 1){
				count ++;
			}
			n = n >>> 1;
		}
		return count;
	}
	

}
