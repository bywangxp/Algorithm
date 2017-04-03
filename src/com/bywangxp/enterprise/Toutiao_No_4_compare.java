package com.bywangxp.enterprise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月30日 下午5:09:22 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class Toutiao_No_4_compare {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int target = in.nextInt();
			String []data =new String [num+1];
			for(int i = 0 ; i<num+1;++i)
				data[i] = i+"";
			Arrays.sort(data);
			System.out.println(data[target]);

		}
	}

}
