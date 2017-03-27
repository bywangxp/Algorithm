package com.bywangxp.offer;

import sun.applet.Main;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月24日 上午12:32:49 
 * @version   v1.0   
 * @quesetion 请实现函数ComplexListNode Clone（ComplexListNode pHead）复制一个复杂链表。在复杂链表中，每个结点除了
 *            有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中任意结点或者null
 * @summary   把复杂链表的复制过程分成三个阶段，同时每个阶段都用图形化的方式表达出来，这些方法能够帮助我们理清思路，写代码的时候
 *            为每一个步骤定义一个函数，最后在复制函数的过程中先后调用这三个函数
 *
 */
public class No_26_ComplexListNodeClone {
/*	分析：
 *  方法一
 *	本题难点在于复杂结点有一个任意指针，最简单的方法是先将结点复制一份，然后来处理任意指针，因为任意结点可能在当前结点
 *	的前方，也可能在后方，这时候只能从头结点开始查找，比如是第n个结点，则在复制的结点中同样移动到第n个结点，所以时间复杂度O（n2）
 *	方法二
 *   可以使用额外的空间来记录结点的任意指针指向的结点比如hashmap <N,N'>,
 *   第一步同样是复制结点，但是在复制结点的时候往hashmap中添加<N,N'>，代表原结点与当前结点
 *   第二步遍历原来的结点，如果有任意指针，则在hashmap中找到指向的结点，则复制的该结点也指向这个位置，则再取出复制的这两个结点，
 *   然后建立连接即可。
 *   方法三（最优）
 *    第一步遍历原结点，每遇到一个结点，生成该结点，并将该新结点直接插入原结点的前方，
 *    第二步遍历链表，如果一个结点有任意指针，则前一个结点也要指向该结点指向的结点的前方结点
 *    第三步将生成的结点从原有链表中抽取出来，新生成的结点都是在奇数位置上
 */
	public static void main(String[] args) {
		ComplexListNode root1 = new ComplexListNode(1);
		ComplexListNode root2 = new ComplexListNode(2);
		ComplexListNode root3 = new ComplexListNode(3);
		ComplexListNode root4 = new ComplexListNode(4);
		ComplexListNode root5 = new ComplexListNode(5);
		ComplexListNode root6 = new ComplexListNode(6);
		ComplexListNode root7 = new ComplexListNode(7);
		root1.m_pNext = root2;
		root1.m_pSibling =root3;
		root2.m_pNext = root3;
		root2.m_pSibling =root7;
		root3.m_pNext = root4;
		root4.m_pNext = root5;
		root5.m_pNext = root6;
		root6.m_pNext = root7;
		root6.m_pSibling =root2;
		root7.m_pNext = null;
		
		print(root1);
		ComplexListNode solution = solution(root1);
		System.out.println("复制的结点");
		print(solution);
		
	}
	public static void print(ComplexListNode root){
		while(root != null){
			System.out.print(root.m_nValue);
			if(root.m_pSibling != null){
				System.out.print("是当前结点，并且它的任意指针指向"+root.m_pSibling.m_nValue);
			}
			System.out.println();
			root = root.m_pNext;
		}
		
	}
	public static ComplexListNode solution(ComplexListNode root){
		if(root == null){
			return null;
		}
		//第一步复制结点
		ComplexListNode temp = root;
		while(temp != null){
			ComplexListNode copyOfRoot = new ComplexListNode();
			copyOfRoot.m_nValue = temp.m_nValue;
			copyOfRoot.m_pNext = temp.m_pNext;
			copyOfRoot.m_pSibling = null;
			temp.m_pNext = copyOfRoot;
			temp = copyOfRoot.m_pNext;
		}
		//处理任意指针
		temp = root;
		while(temp != null){
			if(temp.m_pSibling != null){
				temp.m_pNext.m_pSibling = temp.m_pSibling.m_pNext;
			}
			temp = temp.m_pNext.m_pNext;
		}
		//将结点抽取出来
		temp = root;
		ComplexListNode target = root.m_pNext;
		while(temp != null){//假设只有一个结点
			ComplexListNode next = temp.m_pNext;
			temp.m_pNext = next.m_pNext;
			if(next.m_pNext == null){//到了最后一个结点
				break;
			}
			next.m_pNext = next.m_pNext.m_pNext;
			temp = next.m_pNext;
		}
		return target;
	}
}
class ComplexListNode{
	int m_nValue;
	public ComplexListNode(int m_nValue) {
		super();
		this.m_nValue = m_nValue;
	}
	public ComplexListNode() {
		super();
	}
	ComplexListNode m_pNext;
	ComplexListNode m_pSibling;
	
}
