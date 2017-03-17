package com.bywangxp.offer;

import com.bywangxp.util.ListNode;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月17日 上午11:39:34 
 * @version   v1.0   
 * @quesetion 输入两个递增的排序的链表，合并这两个链表并使新链表中的结点任然按照递增的顺序
 * @summary   注意递归的使用
 * 			  当我们得到两个链表中值较小的头结点并把它链接到已经合并的链表之后，两个链表剩余的结点依然是有序的
 * 			  因此合并的步骤和之前的步骤是一样的。
 *
 */
public class No_17_Merge {
	public static void main(String[] args) {
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
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		/*
		ListNode solution = solution(head,node);
		print(solution);*/
        ListNode recursiving = recursiving(head,node);
        print(recursiving);
	}
	public static void print(ListNode head){
		while(head!=null){
			System.out.print(head.key);
			head=head.next;
		}		
		System.out.println();
		
	}
	public static ListNode solution(ListNode head1,ListNode head2){
		//方法：建立一个新的链表，链表的头结点就是head1，与head2，最小的那个，
		//然后分别用next1，next2，指向二者的未比较元素，总是指向最小的
		if(head1 == null || head2 == null ){
			if(head2 != null){
				return head2;
			}else{
				return head1;
			}
		}
		//ListNode node = head1.key <= head2.key ? head1 : head2;
		ListNode node =null;//指向新链表的当前结点
		if(head1.key <= head2.key){
			node = head1;
			head1 = head1.next;
		}else{
			node = head2;
			head2 = head2.next;
		}
		ListNode head =node;//新链表的头指针
		while(head1 != null && head2 !=null){
			if(head1.key <= head2.key){
				node.next = head1;
				head1 = head1.next;
			}else{
				node.next = head2;
				head2 = head2.next;
			}
			node=node.next;
		}
		while(head1 != null){
			node.next = head1;
			head1 = head1.next;
			node=node.next;
		}
		while(head2 != null){
			node.next = head2;
			head2 = head2.next;
			node=node.next;
		}
		node.next=null;
		return head;
	}
	public static ListNode recursiving(ListNode head1,ListNode head2){
		//方法：从head1，和head2中找出最小的那个结点，然后接着从剩下的两个头结点中选出最小的结点，可以使用递归
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		ListNode MergerHeader = null;
		if(head1.key <= head2.key){
			MergerHeader=head1;
			MergerHeader.next=recursiving(head1.next, head2);
		}else{
			MergerHeader=head2;
			MergerHeader.next=recursiving(head1, head2.next);
		}
	    return MergerHeader;		
	}

}
