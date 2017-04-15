package com.bywangxp.offer;

import java.util.Arrays;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月13日 下午6:42:01 
 * @version   v1.0   
 * @quesetion 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *            例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @summary 
 *
 */
public class No_33_PrintMinNum {
	/**
	 * 方法：使用比较的方法，两个数字分别代表mn，就是存在两种情况，要么m在n前方，要么n在m前方,所以只需要比较mn与nm的大小
	 * 注意大数问题，因为mn与nm组合在一起可能会越界，有一个比较的方法，通过该方法确定谁在前面
	 * 
	 */
	public static void main(String[] args) {
		int []numbers={3,5,1,4,2};
		String printMinNumber = PrintMinNumber(numbers);
		System.out.println(printMinNumber);
	}
	 public static String PrintMinNumber(int [] numbers) {
		 for(int i = 1;i< numbers.length;++i){//插入排序
			int mid = numbers[i];
			int j=i-1;
			for( ; j >= 0 ; --j ){
				//if(mid < numbers[j]){
				 if(compare( mid,numbers[j]) < 0){//后一个数应该在前一个数前方
					numbers[j+1] = numbers[j];
				 }else{
						 break;
				 }
				 }
			 numbers[j+1]=mid;
		 }
		 StringBuilder sb = new StringBuilder();
		 for (int i = 0; i < numbers.length; i++) {
			sb.append(numbers[i]);
		}
		 return sb.toString();

	    }
	public static int compare(int a,int b){ //返回1代表b大于a 即组合ab
		String a1 = a+"";
		String b1 = b+"";
		String composeab = a1+b1;
		String composeba = b1+a1;
		int compareTo = composeab.compareTo(composeba);
		//System.out.println(compareTo);
		return compareTo;
	}
	

}
