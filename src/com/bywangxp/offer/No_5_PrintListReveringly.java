package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月16日 下午9:07:12 
 * @version   v1.0   
 * @quesetion 输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 * @summary 
 *
 */
public class No_5_PrintListReveringly {
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
		
		recurivelyPrint(head);
	}
	public static void recurivelyPrint(ListNode head){
		if(head!=null){
			recurivelyPrint(head.next);
			System.out.println(head.key);
		}
		
		
	}

	
}