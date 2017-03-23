package com.bywangxp.util;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月17日 下午4:12:42 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class BinaryTreeNode {
	public int value;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public BinaryTreeNode(int value){
		this.value = value;
	}
	public BinaryTreeNode(){
		
	}
	public static void preOrder(BinaryTreeNode root){
		if(root != null){
			System.out.print(root.value+",");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
}
