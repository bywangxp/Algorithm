package com.bywangxp.offer;

import com.bywangxp.util.ListNode;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月17日 上午10:31:08 
 * @version   v1.0   
 * @quesetion 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 * @summary   1.要考虑链表头指针为空，或者整个链表只有一个节点的情况
 * 			  容易出现反转后链表出现断层
 * 			  2.本题可以使用递归的方式
 *
 */
public class No_16_ReverseLIist {
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
		print(head);
		//ListNode solution = solution(null);
		ListNode solution = recursiving(head);
		print(solution);
	}
	public static void print(ListNode head){
		while(head!=null){
			System.out.print(head.key);
			head=head.next;
		}		
		System.out.println();
		
	}
	public static ListNode solution(ListNode head){
		//解决方法是：使用三个指针，分别指向当前当前节点，与当前节点之前和之后的结点
		//通过转换指针的方法，使next指向之前的结点；但是会丢失原来next之后的结点，所以需要记录下之后的结点
		ListNode beforeNode = null;
		ListNode nowNode = head;
		if(head == null){
			return null;
		}
		ListNode nextNode = head.next;//注意nextNode防止位置
		//判断条件可以是当前结点，也可以是下一个结点
		while(nextNode != null){//结束条件是下一个结点为空，但是当到达末尾结点，还需要操作一次
			nowNode.next=beforeNode;
			beforeNode = nowNode;
			nowNode = nextNode;
			nextNode =nowNode.next;
		}
		if(beforeNode != null){
			nowNode.next=beforeNode;
		}
		return nowNode;
	}
	public static ListNode recursiving(ListNode head){
		//递归方式，先递归的结尾结点，然后再跟新每一个结点的next指针，并且nowNodw一直指向结尾结点保持不变
		if(head == null || head.next ==null){
			return head;//最后一递归函数，返回结尾结点
		}else{
			ListNode nowNode=recursiving(head.next);//第二次返回
			head.next.next=head;//下一个结点的next指针指向前一个结点
			head.next=null;
			return nowNode;//nowNode一直没有变就是最终结点
		}
	}

}
