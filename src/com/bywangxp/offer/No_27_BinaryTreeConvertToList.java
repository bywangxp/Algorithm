package com.bywangxp.offer;

import com.bywangxp.util.BinaryTreeNode;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月24日 下午3:11:12 
 * @version   v1.0   
 * @quesetion 输入一个二叉搜素树，将该二叉搜索树转换成一个排序的双向链表，要求不能创建任何新的结点
 *            只能调整树中结点指针的指向。
 * @summary   因为本题的lastNode需要一直保持一致，和c++不同，本处需要每次返回lastNode，不然lastNode就丢失了
 *            
 *
 */
public class No_27_BinaryTreeConvertToList {
	//思路：因为中序遍历的结果就是二叉搜索树的结点从小到大的排序结果，所以选择中序遍历
	//可以在原来二叉树中改变结点的左指针指向它的上一个结点，右指针指向下一个结点（双向链表）
	//方法：改造的过程中需要记录上一个遍历的结果， 然后当前结点指向上一个结点，上一个结点指向当前结点
	//同时当前结点替换成链表的最后一个结点
	public static void main(String[] args) {
		BinaryTreeNode root10 =new BinaryTreeNode(10);
		BinaryTreeNode root6 =new BinaryTreeNode(6);
		BinaryTreeNode root14 =new BinaryTreeNode(14);
		BinaryTreeNode root4 =new BinaryTreeNode(4);
		BinaryTreeNode root8 =new BinaryTreeNode(8);
		BinaryTreeNode root12 =new BinaryTreeNode(12);
		BinaryTreeNode root16 =new BinaryTreeNode(16);
		root10.left = root6;
		root10.right = root14;
		root6.left = root4;
		root6.right = root8;
		root4.left = null;
		root4.right = null;
		root8.left = null;
		root8.right = null;
		root14.left = root12;
		root14.right = root16;
		root12.left = null;
		root12.right = null;
		root16.left = null;
		root16.right = null;
		solution(root10);
	}
	
	public static void solution(BinaryTreeNode root){
		if(root == null){
			return;
		}
		BinaryTreeNode lastNode = null;//代表上一个经过的结点
		lastNode = convert(root,lastNode);//方法返回末尾结点 
		BinaryTreeNode firstNode = lastNode;
		while(firstNode != null && firstNode.left != null){
			firstNode = firstNode.left;
		}
		while(firstNode != null){
			System.out.print(firstNode.value+",");
			firstNode = firstNode.right;
		}
	}
	
	private static BinaryTreeNode convert(BinaryTreeNode currentNode, BinaryTreeNode lastNode) {
		if(currentNode == null){
			return null;
		}
		if(currentNode.left != null){
			lastNode = convert(currentNode.left,lastNode);
		}
		currentNode.left = lastNode;//因为当前结点的left结点肯定是空的，或者已经遍历过结点，用来指向上一个结点
		if(lastNode != null){//只有当上一个结点非空，才起作用
			lastNode.right = currentNode;
		}
		lastNode = currentNode;
		if(currentNode.right != null){
			lastNode = convert(currentNode.right, lastNode);
		}
		return lastNode;
	}

}
