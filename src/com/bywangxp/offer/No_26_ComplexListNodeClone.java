package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月24日 上午12:32:49 
 * @version   v1.0   
 * @quesetion 请实现函数ComplexListNode Clone（ComplexListNode pHead）复制一个复杂链表。在复杂链表中，每个结点除了
 *            有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中任意结点或者null
 * @summary 
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
	public static ComplexListNode solution(ComplexListNode root){
		
		//第一步复制结点
		while(root != null){
			
		}
		
		
		
		return null;
		
	}
	
	
	
}
class ComplexListNode{
	int m_nValue;
	ComplexListNode m_pNext;
	ComplexListNode m_pSibling;
}
