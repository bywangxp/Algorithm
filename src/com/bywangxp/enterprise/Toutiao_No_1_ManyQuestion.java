package com.bywangxp.enterprise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月30日 下午2:04:46 
 * @version   v1.0   
 * @quesetion 头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队。每个出题人都出了一些有趣的题目，
 *            而我们现在想把这些题目组合成若干场考试出来。在选题之前，我们对题目进行了盲审，并定出了每道题的难度系数。
 *            一场考试包含3道开放性题目，假设他们的难度从小到大分别为a, b, c，我们希望这3道题能满足下列条件：
 *			  a＜= b＜= c b - a＜= 10 c - b＜= 10
 *            所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须
 *            使用且只能用一次），然而由于上述条件的限制，可能有一些考试没法凑够3道题，
 *            因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求。然而我们出题已经出得很累了，
 *            你能计算出我们最少还需要再出几道题吗？
 * @summary 
 *
 */
public class Toutiao_No_1_ManyQuestion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			Integer []question=new Integer[num];
			for(int i = 0;i < num; ++i){
				question[i] = in.nextInt();
			}
			int answer= solution(question);
		}
	}
// 4 20 35 23 40
// 5 2 1 28 99 27	
	private static int solution(Integer[] question) {
		//方法：先排序，排序完后，前后比较，如果第二个比第一个大10以上则添加元素，该元素的值是前一个元素+10；该元素与后一个元素继续
		//比较，如果还是大于10，则继续添加，然后继续遍历下一个元素，
		Arrays.sort(question);
		int num = 0;//记录总共有多少个元素
	    for (int i = 0; i < question.length; i++) {
	    		num++;
	    		int temp = question[i];
	    		int  numtemp2 = num;
	     	int  numtemp1 = num;
	    		//选取以上两种情况中最小的一个
	    		//case1，在后面添加新的元素，知道满足条件
			while(i+1 < question.length && question[i+1] -temp > 10){
				temp += 10;
				numtemp1++;
			}
			//case2  不管下一个元素，只要大小大于10，则直接补上元素
			if(i+1 < question.length && question[i+1] -question[i] > 10){
				if(i % 3 != 0){
					numtemp2 = numtemp2 + (3- i % 3) ;
			    }
			}
			num = numtemp2 > numtemp1 ? numtemp1 : numtemp2;

	    }

	    if(num % 3 != 0){
	    	   num = num + (3- num % 3) ;
	    }
		return num;
	}

}
//方法2
class Main {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	int[] arr = new int[n];
	for(int i=0;i<n;i++){
		arr[i]=scan.nextInt();
	}
	int res=0;
	Arrays.sort(arr);
	for(int i =0;i<n;i++){
		//判断第二个数和第一个数字的差 大于20则跳过（还需要出2道题目）
		if(i+1<n && arr[i+1]-arr[i]>20){
			res+=2;
			continue;
			//如果不到与20但是大于10，则还需要出一道题
		}else if(i+1<n && arr[i+1]-arr[i]>10){
			res+=1;
			i=i+1;
			continue;
			//如果在10以内的情况
		}else if(i+1<n){
			//判断第三个数字比第二个数字大多少
			//10以内
			if(i+2<n && arr[i+2]-arr[i+1]<=10){
				i=i+2;
			//10以外
			}else if(i+2<n){
				res+=1;
				i=i+1;
			//不存在第三个数字
			}else{
				res+=1;
				i=i+1;
			}
		}else{
			//如果没有下一个了就+2
			res+=2;
		}
	}
	System.out.println(res);
}
}
