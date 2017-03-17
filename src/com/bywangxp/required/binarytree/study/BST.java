package com.bywangxp.required.binarytree.study;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月17日 下午3:48:23 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
/*
 * 二叉查找树(BST树)<br/>
 * 比节点小的元素放在节点的左子树中，比节点大的元素放在节点的右子树中<br/>
 **/
public class BST {
	// 二叉根节点
	public Node root;

	// 向二叉树插入新值
	public void insert(int nv) {
		System.out.print("\n----------");
		if (this.root == null) {
			this.root = new Node();
			this.root.value = nv;
			this.root.left = null;
			this.root.right = null;
			this.root.parent = null;
			System.out.printf("\n插入根据节点:" + nv);
			return;
		}

		System.out.print("\nvisit:");
		Node node = this.findPlace(nv);
		if (node != null) {
			if (nv < node.value) {
				System.out.printf("\n在%d的左子数中插入%d:", node.value, nv);
				node.left = new Node();
				node.left.value = nv;
				node.left.left = null;
				node.left.right = null;
				node.left.parent = node;
			} else if (nv > node.value) {
				System.out.printf("\n在%d的右子数中插入%d:", node.value, nv);
				node.right = new Node();
				node.right.value = nv;
				node.right.left = null;
				node.right.right = null;
				node.right.parent = node;
			}
		}
	}

	// 找到等值,返回null
	// 否则返回父节点,将新插入的node做为其孩子
	public Node findPlace(int nv) {
		Node target = null;
		Node node = this.root;

		while (node != null) {
			System.out.print(node.value + ",");

			if (nv == node.value) {
				target = node;
				break;
			}

			if (nv < node.value) {
				if (node.left != null) {
					node = node.left;
					continue;
				} else {
					target = node;
					break;
				}
			}

			if (nv > node.value) {
				if (node.right != null) {
					node = node.right;
					continue;
				} else {
					target = node;
					break;
				}
			}
		}

		return target;
	}

	// 在二叉树中搜索某值
	// 如果找到,则返回匹配节点,不见返回null
	public Node search(int v) {
		System.out.print("\n二叉树查找经过的节点：");
		Node target = null;
		Node node = this.root;

		while (node != null) {
			System.out.print(node.value + ",");

			if (v == node.value) {
				target = node;
				break;
			}

			if (v < node.value && node.left != null) {
				if (node.left != null) {
					node = node.left;
					continue;
				} else {
					target = null;
					break;
				}
			}

			if (v > node.value) {
				if (node.right != null) {
					node = node.right;
					continue;
				} else {
					target = null;
					break;
				}
			}
		}

		return target;
	}

	// 先根遍历(根左右)
	public void dfsFirst(Node node) {
		if (node == null) {
			return;
		}

		// 访问根
		System.out.print(node.value + ",");

		// 访问左子树
		if (node.left != null) {
			this.dfsFirst(node.left);
		}

		// 访问右子树
		if (node.right != null) {
			this.dfsFirst(node.right);
		}
	}

	// 中根遍历(左根右)(从小到大)
	public void dfsMid(Node node) {
		if (node == null) {
			return;
		}

		// 访问左子树
		if (node.left != null) {
			this.dfsMid(node.left);
		}

		// 访问根
		System.out.print(node.value + ",");

		// 访问右子树
		if (node.right != null) {
			this.dfsMid(node.right);
		}
	}

	// ASC
	public void dfsASC(Node node) {
		this.dfsMid(node);
	}

	// DESC,(右根左)(从大到小):
	public void dfsDESC(Node node) {
		if (node == null) {
			return;
		}

		// 访问右子树
		if (node.right != null) {
			this.dfsDESC(node.right);
		}

		// 访问根
		System.out.print(node.value + ",");

		// 访问左子树
		if (node.left != null) {
			this.dfsDESC(node.left);
		}
	}

	// 后根遍历(左右根)
	public void dfsLast(Node node) {
		if (node == null) {
			return;
		}

		// 访问左子树
		if (node.left != null) {
			this.dfsLast(node.left);
		}

		// 访问右子树
		if (node.right != null) {
			this.dfsLast(node.right);
		}

		// 访问根
		System.out.print(node.value + ",");
	}

	// 二叉树的广度优先遍历，顺序输出
	public void bfs() {
		System.out.print("\nBFS:");
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(this.root);

		Node node = null;
		while (!queue.isEmpty()) {
			// 删除队列头结点
			node = queue.poll();
			System.out.print(node.value + ",");

			// 将节点的左孩子加入队列
			if (node.left != null) {
				queue.offer(node.left);
			}
			// 将节点的右孩子加入队列
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}

	// 二叉树的广度优先遍历，按照层次，从上到下，从左到右，打印此树
	public void bfsLevel() {
		System.out.print("\n--------------- bfsLevel ---------------");
		System.out.print("\nBFS:[节点值,是否叶子,双亲节点,层次]");
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(this.root);

		// 上一个节点的层次
		int prevLevel = 0;
		Node node = null;

		while (!queue.isEmpty()) {
			// 删除队列头结点
			node = queue.poll();
			// 某节点在整棵树的第几层(ROOT为第1层)
			int levelOfFullTree = this.getLevelOfFullTree(node);

			// 如果当前深度比前一个节点的尝试大,则开始的新一层的节点访问
			if (levelOfFullTree > prevLevel) {
				System.out.print("\n");
			}

			System.out.print("[");
			System.out.print(node.value + ",");
			System.out.print((node.parent == null ? null : node.parent.value) + ",");
			System.out.print(prevLevel);
			System.out.print("]");
			// System.out.printf("%3s," , node.value);

			// 将节点的左孩子加入队列
			if (node.left != null) {
				queue.offer(node.left);
			}
			// 将节点的右孩子加入队列
			if (node.right != null) {
				queue.offer(node.right);
			}

			prevLevel = levelOfFullTree;
		}
	}

	// 树形本层节点打印
	private void printTreeLevel(int[] nodes) {
		System.out.print("\n|");
		for (int j = 0; j < nodes.length; j++) {
			if (nodes[j] == 0) {
				// 打印两位数字的占位符
				System.out.printf("--");
			} else {
				// 打印节点
				System.out.printf("%02d", nodes[j]);
				// 重置数组
				nodes[j] = 0;
			}
		}
		System.out.print("|");
	}

	/**
	 * 二叉树的广度优先遍历，按照树形打印此树
	 * 
	 * <pre>
	 * 算法用到的参数：
	 * 1：二叉树的最大深度。
	 * 2：每个节点在二叉树中的层次Level，从1开始。
	 * 3：每个节点在该层中的序号indexOfLevel，从1开始。
	 * 注：
	 * 	(1)Level和indexOfLevel可以在广度优先遍历时用计数器实现。
	 * 	(2)Level和indexOfLevel也可以在向树中插入新节点时，初始化到节点中。
	 * 		如果用数组存储二叉树，假设父节点下标为i，则其左孩子的下标是2*i-1，右孩子的下标是2*i+1。
	 * 
	 * 算法基本思路：
	 * (1)：创建一个水平数组，水平数组的长度为 "满二叉树" 中的节点总数，将二叉树的所有节点，按满二叉树的样子，投影到水平数组上，每个节点在水平数组中都对就一个位置。
	 * (2)：我们总结一下，对于每一个层级，映射到水平数组后，第一个节点的开始下标=s，本层任意相邻节点的步长(间距)=d，如果下所示
	 * 层级	起始下标		步长
	 * 1	2^3-1=7		2^4=16
	 * 2	2^2-1=3		2^3=8
	 * 3	2^1-1=1		2^2=4
	 * 4	2^0-1=0		2^1=2
	 * (3)：有了以上数据，我们可以计算出，任意一层，任意一节点在水平数组中的下标，
	 * 下标=起始下标+(该节点所在层次-1)*步长
	 * (4)：OK，每一次每个节点的位置确定了，树形图自然也确定了。
	 * 
	 * 另：
	 * 如果想要让输出特别规矩，我们必须：
	 * 1：先确定每个节点的值(即输出的内容)最多占多少个字符宽度，假设为flength。
	 * 	   在输出树的过程中，不论遇到空值还是有值，都格式化输出，长度不足flength的，用空格补齐。
	 * 2：可以适当的将水平数组扩大一倍，这样每层中的各节点之间的距离拉长了，最终看到的结果是整个树水平放大了。
	 * </pre>
	 */
	public void bfsTree() {
		System.out.print("\n------------------ 树形打印开始 ------------------");

		if (this.root == null) {
			System.out.print("\n树为pw");
			return;
		}

		// 二叉树的高度
		int maxLevel = this.getDepth(this.root);
		// 满二叉树时的总结点数
		int fullTotal = (int) Math.pow(2, maxLevel) - 1;
		// 水平数组
		int[] nodes = new int[fullTotal];

		// 上一个节点的层次
		int prevLevel = 1;
		// 每层的起始下标
		int start = 0;
		// 每一层的元素的间距
		int stepSize = 0;

		// 广度优先遍历
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(this.root);
		Node node = null;
		// 如果用数组存储二叉树，indexMap中存储各节点对应数组的下标
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		while (!queue.isEmpty()) {
			// 删除队列头结点
			node = queue.poll();
			// 某节点在整棵树的第几层(ROOT为第1层)
			int levelOfFullTree = this.getLevelOfFullTree(node);

			// 如果当前深度比前一个节点的尝试大,则开始的新一层的节点访问
			if (levelOfFullTree > prevLevel) {
				// 打印层次的节点
				this.printTreeLevel(nodes);
			}

			// 计算新的层次的开始下标与步长
			start = (int) Math.pow(2, maxLevel - levelOfFullTree) - 1;
			stepSize = (int) Math.pow(2, maxLevel - levelOfFullTree + 1);
			// System.out.print("\n" + "start:" + start + ",stepSize:" + stepSize);

			// 记录节点的下标
			int idx = -1;
			if (node == this.root) {
				indexMap.put(node.value, 1);
				idx = 1;
			} else {
				if (node == node.parent.left) {
					idx = 2 * indexMap.get(node.parent.value) - 1;
				} else if (node == node.parent.right) {
					idx = 2 * indexMap.get(node.parent.value);
				}
				indexMap.put(node.value, idx);
			}

			// 计算映射到水平数组的位置
			int y = start + (idx - 1) * stepSize;
			nodes[y] = node.value;
			// System.out.print("\n" + "node.value:" + node.value + ",y:" + y);

			// 将节点的左孩子加入队列
			if (node.left != null) {
				queue.offer(node.left);
			}
			// 将节点的右孩子加入队列
			if (node.right != null) {
				queue.offer(node.right);
			}

			// 保留层次数,为下次循环使用
			prevLevel = levelOfFullTree;
		}

		// 打印最底层的节点，因为while的推出，最底层次的节点没有打印，在这里单独打印
		this.printTreeLevel(nodes);
		System.out.print("\n------------------ 树形打印结束 ------------------");
	}

	// 计算以某节点为根的树的深度(从1开始)
	public int getDepth(Node node) {
		if (node == null) {
			return 0;
		}

		return 1 + Math.max(this.getDepth(node.left), this.getDepth(node.right));
	}

	// 计算某节点在整棵树的第几层(ROOT为第1层)
	public int getLevelOfFullTree(Node node) {
		int depth = 0;
		Node t = node;
		while (t != null) {
			depth++;
			t = t.parent;
		}
		return depth;
	}

	// 计算以某节点为根的二叉树的总结点数(包含根节点)
	public int getTotalNode(Node node) {
		if (node == null) {
			return 0;
		}

		int L = getTotalNode(node.left);
		int R = getTotalNode(node.right);

		return 1 + (L + R);
	}

	// 以该节点为根的树，找树中最大的元素
	public Node getMaxNode(Node node) {
		Node nodeMax = node;
		while (nodeMax != null) {
			if (nodeMax.right != null) {
				nodeMax = nodeMax.right;
			} else {
				break;
			}
		}
		return nodeMax;
	}

	// 以该节点为根的树，找树中最大的元素
	public Node getMinNode(Node node) {
		Node nodeMax = node;
		while (nodeMax != null) {
			if (nodeMax.left != null) {
				nodeMax = nodeMax.left;
			} else {
				break;
			}
		}
		return nodeMax;
	}

	/**
	 * <pre>
	 * 找到目标节点并删除，返回目标节点
	 * 如果没找到，返回null
	 * 注意，我们处理每一种分类时，总是先处理ROOT节点
	 * </pre>
	 * 
	 * @param v
	 * @return
	 */
	public Node delete(int v) {
		Node t = this.search(v);

		if (t == null) {
			return t;
		}

		// -------------------------------- 处理叶子节点，开始 --------------------------------
		if (t.isLeaf()) {
			// t是叶子节点，且是ROOT
			if (t.isRoot()) {
				this.root = null;
				return t;
			}
			// t是叶子节点，且是双亲的左孩子，但非ROOT
			if (t.isLeft()) {
				t.parent.left = null;
				return t;
			}
			// t是叶子节点，且是双亲的右孩子，但非ROOT
			if (t.isRight()) {
				t.parent.right = null;
				return t;
			}
		}

		/**
		 * -------------------------------- 处理有两个孩子的节点，开始 --------------------------------
		 * 
		 * <pre>
		 * 如果目标节点t只有一个孩子，或有两个孩子，在这里我们统一处理，都当成有两个孩子。
		 * 
		 * t有两个孩子的情况处理比较复杂点，当我们删除t后，必须找到一个合适的节点来顶替t的位置。
		 * 这个节点的选择有两种方法。
		 * 方法1：从目标节点的左子树中选择值最大的节点，去顶替t的位置。
		 * 方法2：从目标节点的右子树中选择值最小的节点，顶替t的位置。
		 * 
		 * 我们在这里是这样处理的：
		 * 先从t的左右子树中，选择深度最深的子树(如果t.left==null，则左子树的尝试为0)。
		 * 如果是t的左子树，选择值最大的节点。
		 * 如果是t的右子树，选择值最小的节点。
		 * 这样做可以尽量延迟二叉树出现极端不平衡的情况。
		 * 
		 * <pre>
		 */
		if (true) {
			int L = this.getDepth(t.left);
			int R = this.getDepth(t.right);
			// 新选出的节点
			Node nm = null;

			if (L >= R) {
				// 从t的左子树中选择一个最大的
				nm = this.getMaxNode(t.left);
				// 如果max是t的左子树的根，那么max一定没有右孩子
				if (nm == t.left) {
					nm.parent = t.parent;
					nm.right = t.right;
					t.right.parent = nm;
				}
				// 如果max是t的左子树的最右侧的叶子结点，max没有左孩子，或，max有左孩子
				if (nm.isRight()) {
					nm.parent.right = nm.left;
					if (nm.left != null) {
						nm.left.parent = nm.parent;
					}
					nm.left = t.left;
					if (nm.left != null) {
						nm.left.parent = nm;
					}
					nm.right = t.right;
					if (nm.right != null) {
						nm.right.parent = nm;
					}
					nm.parent = t.parent;
				}
			} else {
				// 从t的右子树中选择一个最小的
				nm = this.getMinNode(t.right);
				// min是t的右子树的根，那么min一定没有左孩子
				if (nm == t.right) {
					nm.parent = t.parent;
					nm.left = t.left;
				}
				// min是t的右子树的最左侧的叶子结点，min没有右孩子，或，min有右孩子
				if (nm.isLeft()) {
					nm.parent.left = nm.right;
					if (nm.right != null) {
						nm.right.parent = nm.parent;
					}
					nm.left = t.left;
					if (nm.left != null) {
						nm.left.parent = nm;
					}
					nm.right = t.right;
					if (nm.right != null) {
						nm.right.parent = nm;
					}
					nm.parent = t.parent;
				}
			}

			// 调整选出的新节点与t的双亲节点的关系
			if (t.isRoot()) {
				this.root = nm;
			} else {
				if (t == t.parent.left) {
					t.parent.left = nm;
				} else {
					t.parent.right = nm;
				}
			}
		}

		return t;
	}

	public static void main(String[] args) {
		// 初始化二叉查找树
		BST bst = new BST();
		bst.insert(50);
		bst.insert(30);
		bst.insert(80);
		bst.insert(10);
		bst.insert(40);
		bst.insert(35);
		bst.insert(90);
		bst.insert(85);
		bst.insert(5);
		bst.insert(15);
		bst.insert(20);
		bst.insert(13);
		bst.insert(3);
		bst.insert(8);
		bst.insert(37);
		bst.insert(70);
		bst.insert(60);
		bst.insert(75);
		bst.insert(78);
		bst.insert(72);
		bst.insert(95);
		bst.insert(99);

		bst.bfsLevel();
		bst.bfsTree();

		// int v = 35;
		// Node node = bst.search(v);

		// System.out.print("\ndepth:" + bst.getDepth(node));

		// int k = bst.getMaxLevel(node);
		// System.out.print("\n树的深度,R:" + v + ",V:" + k);
		//
		// int k2 = bst.getTotalNode(node);
		// System.out.print("\n树总结点数,R:" + v + ",V:" + k2);
		//
		// Node nodeMax = bst.getMaxNode(node);
		// System.out.print("\n树中最大值,R:" + v + ",V:" + (nodeMax == null ? null : nodeMax.value));

//		int value = 30;
//		bst.delete(value);
//		bst.bfsTree();
	}

}

