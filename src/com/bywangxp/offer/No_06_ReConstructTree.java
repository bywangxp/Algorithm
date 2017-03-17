package com.bywangxp.offer;

import java.util.Arrays;

import com.bywangxp.util.BinaryTreeNode;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月17日 下午4:10:35 
 * @version   v1.0   
 * @quesetion 输入某二叉树的前序遍历和中序遍历的结果，请重构出该二叉树（假设输入的结果中都不包含重复的数字）
 * @summary   规律：首先由先序遍历找到根节点，然后根据该结点和中序遍历找到左右子树，继续递归找到左右字数根结点
 *            注意：数组的范围，不要越界 递归的结束条件是数组的长度为空，先序遍历和中序遍历结点数相同，任意一方为空，则结束
 *            防止输入的数据，不是同一个树的，比如结点个数都不相同
 */
public class No_06_ReConstructTree {
	public static void main(String[] args) {
		char []preorder={'1','2','4','7','3','5','6','8'};
		char []inorderorder={'4','7','2','1','5','3','8','6'};
		BinaryTreeNode solution = solution(preorder, inorderorder);
		print(solution);
	}
	public static void  print(BinaryTreeNode root){
		if(root != null ){
			print(root.left);
			print(root.right);
			System.out.print(root.value-'0');
		}
	}
	public static BinaryTreeNode solution(char []preorder,char []inorder){
		//方法使用递归的方法：首先先序遍历的第一个结点是根结点，然后这个结点在中序遍历中
		//将结点分成左右子树两部分，由这个结果可以在先序遍历中，分出左右字树，
		if(preorder.length == 0 || inorder.length == 0 ){//当数组的长度为0，则返回空
			return null;
		}
		//需要判断两个串，是不是同一颗数的先序遍历，后序遍历
		if(preorder.length!=inorder.length){
			return null;
		}
		char root = preorder[0];
		//在中序遍历中找到这个结点
		int i=0;//i 即为在中序遍历中的结果
		BinaryTreeNode ele = new BinaryTreeNode();
		for( ; i<inorder.length ; ++i){
			if(root == inorder[i]){//假设不存在同一个结点，每一个结点都是独一无二
				//在中序遍历中，找到左右子树
				char[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
				char[] inorderRight= Arrays.copyOfRange(inorder, i+1, inorder.length);
				//在先序遍历中，找出左右字树
				char[] preorderLeft= Arrays.copyOfRange(preorder, 1, i+1);//注意i+1；
				char[] preorderRight=Arrays.copyOfRange(preorder, i+1, preorder.length);//i+1
				ele.value=root;
				ele.left=solution(preorderLeft,inorderLeft);
				ele.right=solution(preorderRight,inorderRight);
			}
		}
		return ele;
		
	}

}
