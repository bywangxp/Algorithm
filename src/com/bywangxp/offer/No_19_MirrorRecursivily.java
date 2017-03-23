package com.bywangxp.offer;

import java.util.LinkedList;

import com.bywangxp.util.BinaryTreeNode;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月22日 下午1:22:08 
 * @version   v1.0   
 * @quesetion 请完成一个函数，输入一个二叉树，请函数输出它的镜像
 * @summary   如何不使用
 *
 */
public class No_19_MirrorRecursivily {
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
		
		BinaryTreeNode.preOrder(root2);
		System.out.println();
		solution3(root1);
		BinaryTreeNode.preOrder(root2);
	}
	
	//方法：通过画图知道，镜像就是左右子树对调，然后左右子树的子节点也分别对调，这是个递归的过程
	public static void solution(BinaryTreeNode root){
		if(root != null){
			BinaryTreeNode temp=root.left;
			root.left=root.right;
			root.right=temp;
			solution(root.left);
			solution(root.right);
		}
	}
	public static void solution2(BinaryTreeNode root){
		//此处考虑到有些情况可以提前结束遍历
		if(root == null){
			return ;
		}
		if(root.left == null && root.right == null){
			return ;
		}
		BinaryTreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		if(root.left != null ){
			solution(root.left);
		}
		if(root.right != null){
			solution(root.right);
		}
	}
	//使用循环来实现
	public static void solution3(BinaryTreeNode root){
		if(root == null ){
			return ;
		}
		//使用队列，按照层次遍历的方式
		LinkedList<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode poll = queue.poll();
			BinaryTreeNode left = poll.left;
			BinaryTreeNode right = poll.right;
			BinaryTreeNode temp=left;
			if(left != null ){
				queue.offer(left);
			}
			if(right != null){
				queue.offer(right);
			}
			//交换元素
			poll.left=right;
			poll.right=temp;
		}
	}
	

}
