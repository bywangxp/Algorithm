package com.bywangxp.offer;

import java.util.Stack;

import com.bywangxp.util.BinaryTreeNode;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月23日 下午11:54:24 
 * @version   v1.0   
 * @quesetion 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入的整数的所有路径，
 *            从树的根结点出发往下一直找到叶结点所经过的结点形成一条路径。
 * @summary   考虑场景，发现需要用到先序遍历，以及输出的顺序，需要用栈
 *
 */
public class No_25_FindTreePathByValue {
	/*
	 * 方法：使用栈来存储每次经过的结点，每次进去一个结点，然后算总值，然后每次退回的时候，从栈中输出
	 * 因为先序遍历是先经过根结点，然后开始往下，所以选择先序遍历来递归
     */
	public static void main(String[] args) {
		BinaryTreeNode root1 =new BinaryTreeNode(1);
		BinaryTreeNode root2 =new BinaryTreeNode(2);
		BinaryTreeNode root3 =new BinaryTreeNode(0);
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
		solution(root1,8,0,new Stack<BinaryTreeNode>());
	}
	public static void solution(BinaryTreeNode root ,int targetValue ,int currentValue,Stack<BinaryTreeNode> stack){
		if(root == null){
			return ;
		}
		stack.push(root);
		currentValue = currentValue + root.value;
		if(root.left == null && root.right == null){
			//到达叶子结点
			if(currentValue == targetValue){
				for(int i = 0; i < stack.size();++i){
					System.out.print(stack.get(i).value+",");
				}
				System.out.println();
			}
		}else{
			if(root.left != null){
				solution(root.left,targetValue,currentValue,stack);
				//开始回退
				stack.pop();
				
			}
			if(root.right != null){
				solution(root.right,targetValue,currentValue,stack);
				stack.pop();
				//开始回退
			}
		}
	}
	
}
