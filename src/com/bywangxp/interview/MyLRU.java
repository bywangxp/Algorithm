package com.bywangxp.interview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月12日 下午7:34:05 
 * @version   v1.0   http://www.cnblogs.com/lzrabbit/p/3734850.html
 * @quesetion 实现LRU算法，最近最久未使用算法，设置一个缓冲区，设置一个阀值，
 * 如果超过该阀值则删除元素
 * @summary xixi : 2hah : 4xw1 : 5xw3 : 5xw4 : 5
 *
 */
public class MyLRU extends LinkedHashMap<String,Integer>{
	public static void main(String[] args) {
		MySelfLRU myLRU = new MySelfLRU(3);
		//MyLRU myLRU = new MyLRU(3);
		myLRU.put("A", 1);
		System.out.println(myLRU.toString());
		myLRU.put("B", 2);
		System.out.println(myLRU.toString());
		myLRU.put("C", 3);
		System.out.println(myLRU.toString());
		myLRU.put("A", 4);
		System.out.println(myLRU.toString());
		myLRU.put("D", 5);
		System.out.println(myLRU.toString());
		myLRU.put("E", 6);
		System.out.println(myLRU.toString());
		myLRU.put("C", 7);
		//myLRU.remove("hah");
		System.out.println(myLRU.toString());
	}
	private  final int MAXSIZE;
	
	public MyLRU(int maxSize) {
		super( (int) (Math.ceil(maxSize / 0.75)+1),0.75f,true);
		MAXSIZE = maxSize;
	}
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
		//重写该删除方法，默认情况返回false
		if(size() > MAXSIZE){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry entry : entrySet()) {
			sb.append(entry.getKey()+" : "+ entry.getValue());
		}
		return sb.toString();
	}

}
class MySelfLRU<K,V>{
	//方法2：利用HashMap+list（带有头指针和尾指针）实现LRU，此处HashMap中V需要存储Entity，方便操作，可以利用它直接定位到链表中指定位置
	private final int MAXSIZE;
	private Entity<K,V> first;
	private Entity<K,V> last;
	private HashMap<K,Entity<K,V>> map ;
	public MySelfLRU(int size){
		MAXSIZE = size;
		map = new HashMap<K,Entity<K,V>>();//维护一个HashMap
	}
	public void put(K k,V v){
		//将一对值装入缓存，第一步先检查是否已经存在于当前缓存中，如果已经则需要将该元素移动first位置，
		//并且删除该位置，否则判断当前缓存区大小，如果大小不够，则需要删除last处元素，在头结点位置插入该元素
		Entity<K,V> entity = getEntity(k);
		if(entity == null){
			//当该位置为空，判断是否满了
			if(map.size() >= MAXSIZE){
				remove(last.key);
			}
			entity = new Entity<K,V>(k,v);
			entity.key = k;
		}
	     //此处需要写通用一点，不使用else，因为这部分操作不管entity是否为空都需要
		//修改实体值，并且将该位置元素删除，插入first位置，重置map中该出的值
		entity.value = v;
		moveToFirst(entity);
		map.put(k, entity);
	}
	public V get(K k){
		Entity<K,V> entity = getEntity(k);
		if(entity == null){
			return null;
		}
		moveToFirst(entity);
		return  entity.value;
	}
	
	public void remove(K k) {//考虑特殊情况
		Entity<K,V> entity = getEntity(k);//找到要删的元素
		//因为放入map中v可能为null
		if(entity != null){
			if(entity.pre != null){
				entity.pre.next = entity.next;
			}
			if(entity.next != null){
				entity.next.pre = entity.pre;// entity.pre必然存在元素
			}
			//如果是第一或者最后一个结点需要特殊处理
			if(entity == last){
				last = entity.pre;
				if(last == null){//细节之处，删除结尾的时候考虑first
					first = null;
				}else{
					last.next=null;
				}
			}
			if(entity == first){
				first = first.next;
			}
		}
		map.remove(k);
	}
	private void removelast(){
		if(last != null){
			last = last.pre;
			if(last == null){//细节之处，删除结尾的时候考虑first
				first = null;
			}else{
				last.next=null;
			}
		}
	}
	private void moveToFirst(Entity<K,V> entity) { //此处该entity就是指向链表中的实体，所以下面的操作不需要寻找到该元素,所以可以使用==号判断是否是该元素
		
		if(first == entity){
			return ;
		}
		if(entity.pre != null){
			entity.pre.next = entity.next;
		}
		if(entity.next != null){
			entity.next.pre = entity.pre;// entity.pre必然存在元素
		}
		if(entity == last){
			//entity.pre.next = null;
			last = last.pre;
			last.next = null;
		}
		if(first == null || last == null){//当初始化缓存区为空时，添加一个元素时也需要调用moveToFirst
			first = last = entity;
			return ;
		}
		//移动到第一个位置
		entity.pre = null;
		entity.next = first;
		first.pre = entity;//务必要有
		first = entity;
	}
	
	//从map中获取是否已经存在实体
	private Entity<K,V> getEntity(K k) {
		return map.get(k);//如果该出为空，返回的是null
	}
	
	@Override
	public String toString() {
		  StringBuilder sb = new StringBuilder();
	      Entity<K,V> entity = first;
	      while (entity != null) {
	          sb.append(String.format("%s:%s ", entity.key, entity.value));
	          entity = entity.next;
	      }
	      return sb.toString();
	}
}
class Entity<K,V>{
	
	public Entity(K key,V vlaue) {
		this.key = key;
		this.value = value;
	}
	Entity<K,V> next;
	Entity<K,V> pre;
	K key;
	V value;
	
}
