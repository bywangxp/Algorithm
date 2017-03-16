package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月16日 下午10:00:18 
 * @version   v1.0   
 * @quesetion 输入一个链表，输出该链表中倒数第k个结点，为了符合大多数人的习惯，从1开始计数 列入 1，2，3，4，5，6 倒数第3个则为4
 * @summary 
 * 			  1.提高代码的鲁棒性，很明显在此处有三处代码需要提高的地方，head为空，k小于1，或者k大于链表的长度
 * 			  2.在链表的问题中，可以使用两个指针，来帮忙，一个指针比另一个指针走的快，比如判断中间结点，可以一个走一步，一个走两步，
 * 				（注意奇数偶数的关系）以及求链表是否是个环形，若在快结点到达尾部null时，还没有赶上慢的结点，则非环
 */
public class No_15_FindToTail {
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
		solution(head,0);
	}
	public static void solution(ListNode head,int k){
		//一种方法是，获得链表的结点总个数为k，然后倒数第k个，也就是正数n-k+1；但是这个方法需要遍历链表两次
		//第二种方法是只遍历链表一次，设置两个指针，i，j 刚开始i先前进k-1，但是i保持不变，
	    //之后i，j一起前进，当i到达链表的尾部，则说明j也就是倒数k个结点,移动了k-1，则i，j之间差为k-1+1=k
		//注意k的界限，如果k大于链表的长度
		if(head==null || k<1){
			return;
		}
	    ListNode nodei=head;
	    ListNode nodej=head;
	    while(k>1){//只一定k-1个
	    		if(nodei.next!=null){
	    			nodei=nodei.next;
	    			k--;
	    		}else{
	    			System.out.println("k值比链表长度大");
	    			return;
	    		}
	    }
	    while(nodei.next!=null){
	    		nodei=nodei.next;
	    		nodej=nodej.next;
	    }
	    System.out.println("找到啦"+nodej.key);
		
	}

}
