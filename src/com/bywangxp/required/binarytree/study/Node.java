package com.bywangxp.required.binarytree.study;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月17日 下午3:44:51 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
class Node {
	// 节点值
	public int value;
	// 节点左孩子
	public Node left;
	// 节点右孩子
	public Node right;
	// 节点的双亲
	public Node parent;

	public Node() {
		
	}

	// 是否有左孩子
	public boolean hasLeft() {
		return this.left == null ? false : true;
	}

	// 是否有右孩子
	public boolean hasRight() {
		return this.right == null ? true : false;
	}

	// 是否只有一个孩子
	public boolean hasOneSub() {
		return (this.left == null && this.right != null) || (this.left != null && this.right == null) ? true : false;
	}

	// 是否有两个孩子
	public boolean hasTwoSub() {
		return (this.left != null && this.right != null ? true : false);
	}

	// 是否没有孩子
	public boolean hasNonSub() {
		return (this.left == null && this.right == null) ? true : false;
	}

	// 是否叶子节点
	public boolean isLeaf() {
		return this.hasNonSub();
	}

	// 是否是ROOT节点
	public boolean isRoot() {
		return (this.parent == null) ? true : false;
	}

	// 是否是双亲的左孩子
	public boolean isLeft() {
		boolean flag = false;
		if (this.parent != null && (this == this.parent.left)) {
			flag = true;
		}
		return flag;
	}

	// 是否是双亲的右孩子
	public boolean isRight() {
		boolean flag = false;
		if (this.parent != null && (this == this.parent.right)) {
			flag = true;
		}
		return flag;
	}

	// 该节点只能有一个孩子，返回这个孩子
	public Node getOneSub() {
		if (this.left != null && this.right != null) {
			throw new RuntimeException("该节点只能有一个孩子。");
		}
		return this.left == null ? this.right : this.left;
	}

}

