package com.bywangxp.offer;

import com.bywangxp.util.BinaryTreeNode;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月20日 下午6:23:39 
 * @version   v1.0   
 * @quesetion 输入两个二叉树，B，A，判断B是不是A的子结构
 * @summary   拆开成两个函数，一个是用来查找根相同的子树，第二方法判断根结点相同，其他结点是否相同
 *
 */
public class No_18_DoesTree1HaveTree2 {
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
		root4.left = root6;
		root1.right = null;
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
		
		BinaryTreeNode node1 =new BinaryTreeNode(2);
		BinaryTreeNode node2 =new BinaryTreeNode(2);
		BinaryTreeNode node3 =new BinaryTreeNode(3);
		BinaryTreeNode node4 =new BinaryTreeNode(4);
		BinaryTreeNode node5 =new BinaryTreeNode(5);
		BinaryTreeNode node6 =new BinaryTreeNode(6);
		BinaryTreeNode node7 =new BinaryTreeNode(7);
		node2.left = node4;
		node2.right = node5;
		node4.left = null;
		node4.right = null;
		node5.left = null;
		node5.right = null;
		
		boolean hasSubTree = hasSubTree(root1,root2);
		System.out.println(hasSubTree);
	}
	//首先从根结点开始判断，二叉树B中是否有和A一样的根结点，如果有的话，继续调用一个判断的函数
	//子节点是否相同，如果不相同，继续调用B的其他结点来查找与根结点相同的结点。
	public static boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2){
		if(root1 == null || root2 == null){
			return false;
		}
		boolean result = false;
		if(root1.value == root2.value){
			result=doesTree1hasTree2(root1, root2);
		}
		if(result == false){
			result=hasSubTree(root1.left,root2);
		}
		if(result == false){
			result=hasSubTree(root1,root2.right);
		}
		return result;
	}
	public static boolean doesTree1hasTree2(BinaryTreeNode root1,BinaryTreeNode root2){
		//虽然第一次调用时，结果肯定相同，但是之后每次调用该函数，并不知道是否相同，所以要先开始判断
		if(root2 == null){
			return true;//当root2为空，返回成功
		}
		if(root1 == null){
			return false;//当root2不为空，root1为空，则返回失败
		}
		if(root1.value != root2.value){//两个虽然都不为空，但是两个也不相等，则返回空
			return false;
		}
		return doesTree1hasTree2(root1.left, root2.left) && doesTree1hasTree2(root1.right, root2.right);
	}
	
	

}
