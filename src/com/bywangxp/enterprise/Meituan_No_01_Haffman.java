package com.bywangxp.enterprise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

import com.sun.xml.internal.ws.api.client.SelectOptimalEncodingFeature;

import sun.misc.Queue;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月20日 下午8:23:42 
 * @version   v1.0   
 * @quesetion 请设计一个算法，给一个字符串进行二进制编码，使得编码后字符串的长度最短。
 * @summary 
 *
 */
public class Meituan_No_01_Haffman {
	public static void main(String[] args) {
		int solution = solution("AAB");
		System.out.println(solution);
	}
	public static int solution(String target){
		//统计目标字符串中每个字符出现的次数
		char[] charArray = target.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i = 0;i<charArray.length;++i){
			if(map.containsKey(charArray[i])){
				Integer integer = map.get(charArray[i]);
				map.put(charArray[i], integer++);
			}else{
			    map.put(charArray[i],1);
			}
		}
		int size = map.size();
		//使用最小优先队列（最小堆构成）
		PriorityQueue<HuffmanNode> queue=new PriorityQueue<HuffmanNode>(map.size(), new Comparator<HuffmanNode>(){
			@Override
			public int compare(HuffmanNode o1, HuffmanNode o2) {
				return o1.weight-o2.weight;
			}
		});
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			HuffmanNode huffmanNode = new HuffmanNode(entry.getValue(), entry.getKey());
			queue.offer(huffmanNode);
		}
		while(queue.size()>1){
			HuffmanNode minNode = queue.poll();
			HuffmanNode secondeMinNode = queue.poll();
			HuffmanNode huffmanNode = new HuffmanNode(minNode.weight+secondeMinNode.weight,null);//构成新的结点
			huffmanNode.left=minNode;
			huffmanNode.right=secondeMinNode;
			queue.offer(huffmanNode);
		}
		HuffmanNode poll = queue.poll();
		return getLength(poll , 1);
	}
    //计算整个哈夫曼编码的总长度，因为如果是合成的结点，则value==null.通过这个来识别出属于哪个结点
	private static int getLength(HuffmanNode poll , int depth) {
		if(poll == null){
			return 0;
		}
		return (poll.ch == null ? 0 : poll.weight) * depth + getLength(poll.left ,depth + 1)+ getLength(poll.right,depth+1);
	}
}
class HuffmanNode{
	int weight;
	Character ch;
	HuffmanNode left;
	HuffmanNode right;
	public HuffmanNode(int weight,Character ch){
		this.weight=weight;
		this.ch=ch;
	}
}
