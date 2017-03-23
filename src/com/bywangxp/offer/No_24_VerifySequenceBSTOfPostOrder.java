package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月23日 下午9:59:28 
 * @version   v1.0   
 * @quesetion 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果，如果是则返回true，否则false
 * @summary   如果面试题要去处理一个二叉树的遍历序列，我们可以先找到二叉树的根结点，再根据根节点把整棵树的遍历序列拆分成左子树，右子树，接下来递归处理两个序列
 */
public class No_24_VerifySequenceBSTOfPostOrder {
	public static void main(String[] args) {
		int []array={1,2}; //当结点为6，4
		boolean solution = solution(array,0,array.length-1);
		System.out.println(solution);
	}
//	二叉搜索树，中间结点比左子树小，比右边结点大；因为后序遍历的结果中，中间结点都是当前子树的末尾，所以如果用后序遍历某
//	搜索二叉树，得到的序列中最后一个结点的前面，一定将二叉树分成两个序列，前一个序列的结点都比末尾结点小，另一个都比它大
//  或者是所有序列都比它大，所有序列都比它小这种情况，当然还有一个结点的情况
//  方法是一串序列，从后面结点开始判断从第一个起始位置找，找到比它大的第一个结点，然后判断后面是不是都是比他大的，然后前段，后段递归
	public static boolean solution(int[] sequence, int start, int end){//end,应该改为length
		if(sequence == null){
			return false;
		}
		if(start == end){
			System.out.println("start == end");
			return true;
		}
		/* if(start + 1 == end){//只有两个结点肯定true
			 System.out.println("start + 1 == end");
			 return true;
		 }*/
		 int index = start ;//用来记录分界结点，即一半比中间结点大，一半比他小
		 while(sequence[index] < sequence[end] && index < end){
			 ++index;
		 }
		 System.out.println("index"+index);
		 if(index == end){//前面的结点都比中间结点小
			 return solution(sequence, start, end-1);
		 }
		 int index2 = index;//记录后半部分的
		 while(sequence[index2] > sequence[end] && index2 < end){
			 ++index2;
		 }
		 System.out.println("index2"+index2);
		 if(index2 == end){
			 //注意：如果后面的结点不都是比中间结点大则肯定出错 index ==start 表示只有比中间结点大的情况，就不能进入循环
			boolean flag1 =false;
			if(start  == index ){
				flag1 = true;
			}else{
			    flag1 = solution(sequence, start ,index-1);
			}
			boolean flag2 = solution(sequence, index ,end -1);
			if(flag1 && flag2){
				return true;
			}else{
				return false;
			}
		 }else{
			 System.out.println("cicic");
			 return false;
		 }
		
	}

}
