package com.bywangxp.offer;

import java.util.LinkedList;

import com.bywangxp.util.BinaryTreeNode;


/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月23日 下午9:42:51 
 * @version   v1.0   
 * @quesetion 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
 * @summary 
 *
 */
public class No_23_PrintFromTopToBottom {
	public static void main(String[] args) {
		BinaryTreeNode root1 =new BinaryTreeNode(1);
		BinaryTreeNode root2 =new BinaryTreeNode(2);
		BinaryTreeNode root3 =new BinaryTreeNode(3);
		BinaryTreeNode root4 =new BinaryTreeNode(4);
		BinaryTreeNode root5 =new BinaryTreeNode(5);
		BinaryTreeNode root6 =new BinaryTreeNode(6);
		BinaryTreeNode root7 =new BinaryTreeNode(7);
		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;
		root6.left = null;
		root6.right = null;
		root5.left = null;
		root5.right = null;
		root4.left = root6;
		root4.right = null;
		root3.left = null;
		root3.right = root7;
		root7.left = null;
		root7.right = null;
		print(root1);
	}
	public static void print(BinaryTreeNode root){
		//方法：使用队列，从头结点开始入队，循环判断队列是否为空，开始出队列，出队列时，打印结点
		// 同时将该结点的左右子结点分别入队
		if(root == null){
			return;
		}
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(queue.size() != 0){
			BinaryTreeNode ele = queue.poll();
			System.out.print(ele.value+",");
			if(ele.left != null){
				queue.offer(ele.left);
			}
			if(ele.right != null){
				queue.offer(ele.right);
			}
			
		}
		
	}

}
