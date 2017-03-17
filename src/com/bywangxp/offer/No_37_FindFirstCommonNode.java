package com.bywangxp.offer;

import java.util.Stack;

import com.bywangxp.util.ListNode;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月17日 下午2:33:44 
 * @version   v1.0   
 * @quesetion 输入两个链表，找出他们的第一个公共结点
 * @summary   发现规律，因为是单链表，所以当有一个公共结点后，之后的每一个结点都是一样的，所以链表的
 *            形状是Y，所以有两种解决方案
 *
 */
public class No_37_FindFirstCommonNode {
	public static void main(String []args){
		ListNode head=new ListNode(1);
		ListNode head2=new ListNode(2);
		ListNode head3=new ListNode(3);
		ListNode head4=new ListNode(4);
		ListNode head5=new ListNode(5);
		ListNode head6=new ListNode(6);
		head.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next=head5;
		head5.next=head6;
		head6.next=null;
		
		ListNode node=new ListNode(1);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(5);
		ListNode node4=new ListNode(7);
		ListNode node5=new ListNode(9);
		ListNode node6=new ListNode(10);
		node.next=node2;
		node2.next=node3;
		node3.next=head5;
		//ListNode easySolution = easySolution(head,node);
		//System.out.println(easySolution.key);
		ListNode solution = easySolution(head,node);
		System.out.println(solution.key);
	}
			
	// 比较傻的方法是，从一个链表头结点开始，遍历链表的每一个结点的时候，遍历第二个链表的每一个结点，时间复杂度是O(m*n)
	public static ListNode solution(ListNode head1,ListNode head2){
		/*
		 * 方法1：借助栈从末尾结点开始，因为末尾结点应该都是一样的，找到第一个不一样的结点开始
		 * 但是需要从末尾向前遍历，单链表是不可以的，所以借助栈来实现，建立双栈，分别将两个链表结
		 * 点放入，然后一个个出栈,最后一对结点不相同的前一个结点即为第一个公共结点
		*/
		if(head1 == null || head2 == null){
			return null;
		}
		Stack<ListNode> stack1 = new Stack<ListNode>();
		Stack<ListNode> stack2 = new Stack<ListNode>();
		stack1.push(null);
		stack2.push(null);
		while(head1 != null){
			stack1.push(head1);
		}
		while(head2 != null){
			stack1.push(head2);
		}
		ListNode node1 = stack1.pop();
		ListNode node2 = stack2.pop();
		ListNode temp = node1;//记录上一次pop的结果
		while(node1 != null && node2 !=null ){
			 node1=stack1.pop();
			 node2=stack2.pop();	
			 if(node1 != node2){
				 return temp;
			 }
			 temp=node1;
		}
		return null;
		
	}
	public static int length(ListNode head){
		if(head == null){
			return 0;
		}
		int num=0;
		while(head != null){
			num++;
			head=head.next;
		}
		return num;
	}
	public static ListNode easySolution(ListNode head1,ListNode head2){
	/*	
	 * 因为第一个方法需要借助两个栈来实现，是空间换时间的做法，本题可以先遍历两个链表，得到两个链表的长度
	 * 利用规律发现，两个链表在第一个公共点后面的链表长度是一样的，所以两个链表刚开始长度不一致的
	 * 结点肯定不会是公共结点，所以可以找到长度一致的位置，开始一个个的判断，如果相同则是
	 * 
	*/
		if(head1 == null || head2 == null){
			return null;
		}
		int length1 = length(head1);
		int length2 = length(head2);
		int num = length1 - length2;//获得长度差
		if(num > 0){
			while(num > 0){
				head1=head1.next;
				num--;
			}
		}
		else{
			while(num < 0){
				head2=head2.next;
				num++;
			}
		}
		while(head1 !=null && head2 !=null && head1 != head2){
			head1 = head1.next;
			head2 = head2.next;
		}
		if(head1 != null){
			return head1;
		}else{
			return null;
		}
	}
}
