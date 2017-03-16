package com.bywangxp.newcoder;

import java.util.Arrays;

public class No3_4_String {
	public static void main(String[] args) {
		//boolean easykmp = Easykmp("ancdccc","cd");
		String str="abcdabd";
		int next[]=new int[str.length()];
		//getNext(str,next);
		boolean kmp = kmp("abc","adfsdfabc");
		System.out.println(kmp);
	}
	
	
	
	private static void getNext(char[] charArray) {
		// TODO Auto-generated method stub
		
	}



	//1.判断字符串是否互为旋转词 字符串1234 旋转词 2341  3412  4123
	//旋转词：将字符串的前面任意部份移动到后面形成的字符串
	public static boolean rotateString(String a,String b){
		//1.判断是否相等
		if(a==null||b==null){
			return false;
		}
		if(a.length()!=b.length()){
			return false;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(a);
		sb.append(a);
		return kmp(sb.toString(),b);
		//2.生成新的字符串str1+str1.若str2在这个新的字符串之中，则正确，
		//3.使用KMP算法匹配即可
	}

	private static boolean kmp(String a, String b) {
		//1.当模式串匹配时，则i++。j++
		//2.当不匹配时，则i-j+1，j=0；
		char[] a1 = a.toCharArray();
		char[] b1 = b.toCharArray();
		int i=0,j=0;
		int []next=new int[b.length()];
		getNext(b,next);
		while(i<a1.length-1&&j<b1.length-1){
			if(a1[i]==b1[j]){
				i++;
				j++;
			}else{
				j=next[j];
			}
			if(j==b1.length){
				System.out.println("匹配上了，位置："+(i-j));
				return true;
			}
		}
		return false;
		
	}
	private static boolean Easykmp(String a, String b) {
		//暴力求解
		//1.当模式串匹配时，则i++。j++
		//2.当不匹配时，则i-j+1，j=0；
		char[] a1 = a.toCharArray();
		char[] b1 = b.toCharArray();
		int i=0,j=0;
		while(i<a1.length&&j<b1.length){
			if(a1[i]==b1[j]){
				i++;
				j++;
			}else{
				i=i-j+1;
				j=0;
			}
			if(j==b1.length){
				System.out.println("匹配上了，位置："+(i-j));
				return true;
			}
		}
		return false;
	}
	//获取字符串的next数组
	private static void getNext(String str,int []next){
		char[] array = str.toCharArray();
		int i =-1,j =0;//j为记录数组的位置
		next[0] = -1;
		//p[i]表示前缀，p[j]表示后缀
		while( j < array.length-1){ //注意-1；
			if(i == -1 || array[i] == array[j]){
				i++;
				j++;
				next[j]=i;
			}else{
				i = next[i];
			}
		}
	}
	
     

}
