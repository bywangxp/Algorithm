package com.bywangxp.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月6日 下午4:17:18 
 * @version   v1.0   
 * @quesetion 输入中有多组测试数据。每组测试数据的第一行为两个整数n和m（1=＜n, m=＜1000），分别表示价签的数量以及小B的购买清单中所列的物品数。第二行为空格分隔的n个正整数，表示货架上各类物品的价格，每个数的大小不超过100000。随后的m行为购买清单中物品的名称，所有物品名称为非空的不超过32个拉丁字母构成的字符串，保证清单中不同的物品种类数不超过n，且商店有小B想要购买的所有物品。
 * @summary 
 *
 */
public class JinDong_no_1 {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			while(in.hasNext()){
				int kinds = in.nextInt();
				int products = in.nextInt();
				int []price=new int[kinds];
				for(int i = 0;i<kinds;++i){
					price[i] = in.nextInt();
				}
				HashMap<String, Integer> map = new HashMap<String,Integer>();
				for(int i = 0;i<products;++i){
					String next = in.next();
					if(map.get(next)!=null){
						map.put(next, map.get(next)+1);
					}else{
						map.put(next, 1);
					}
				}
//				Collection<Integer> values = map.values();
//				ArrayList<Integer> arrayList = new ArrayList<Integer>(values);
//				Collections.sort(arrayList);
//				System.out.println(arrayList.toString());
				Arrays.sort(price);
				Set<String> keySet = map.keySet();
				Iterator<String> it = keySet.iterator();
				int []buy  = new int[map.size()];
				int i =0;
				while(it.hasNext()){
					buy[i++] =map.get(it.next());
				}
				Arrays.sort(buy);
				//算最少
				int total = 0;
				int k=0;
				for(i = buy.length-1;i>=0;--i){
					total += buy[i]*price[k++];
				}
				//算最多
				int max = 0;
				k= price.length-1;
				for(i = buy.length-1;i>=0;--i){
					max += buy[i]*price[k--];
				}
				System.out.println(total+" "+ max);
				
 			}
		}
}
