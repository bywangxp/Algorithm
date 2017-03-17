package com.bywangxp.offer;

import com.bywangxp.util.ListNode;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月16日 下午9:17:10 
 * @version   v1.0   
 * @quesetion 给定一个单向链表的头指针和和一个结点指针，定义一个函数在O(1)时间删除该结点
 * @summary 
 * 			  1.要想到删除一个结点，不一定要删除它本身，可以通过先复制下一个结点的值到当前结点，然后删除也可。
 *  		  2.要考虑特殊情况，比如删除的是末尾结点，以及只有一个结点的情况。
 */
public class No_13_DeleteNode {
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
		solution(head6,head6);
	}
	//考虑如果该结点不在链表上，还是需要遍历链表才能知道
	public static void solution(ListNode head,ListNode node){
		//case1:如果该结点是中间结点，则先复制下一个结点的值给当前结点，然后删除下一个结点，相当于删除了当前结点
		if(node.next != null){
			node.key=node.next.key;
			ListNode temp=node.next;
			node.next=node.next.next;
			delete(temp);
		}else if(head == node ){
		//case12：如果链表只有一个结点，则这时候,需要删除该结点，且头结点赋值为null
			delete(node);
			head = null;
			node=null;
		}else{
		//case3:如果该结点是末尾结点，仍然需要从头到尾遍历链表找到前一个结点，然后删除
			ListNode temp=head;
			while(temp.next!=node){
				temp=temp.next;
			}
			temp.next=null;
			delete(node);
			node=null;
		}
	}
	public static void delete(ListNode node){
		System.out.println(node.key);
		System.out.println("结点已经删除");
	}
	

}
