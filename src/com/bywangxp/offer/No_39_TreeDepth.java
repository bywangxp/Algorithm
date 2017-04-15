package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年4月15日 下午8:23:51 
 * @version   v1.0   
 * @quesetion No1.输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *            No2.输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @summary 
 *
 */
public class No_39_TreeDepth {
	  private boolean flag = true;
	  /**
	   * 该方法是采用后序遍历，因为后序遍历其左右子树已经遍历结束
	   * @param root
	   * @return
	   */
      public boolean solution(TreeNode root){
    	        isbalance(root);
    	  		return flag;
      }
	  private int  isbalance(TreeNode root) {
		  if(root != null){
				 int num1 = TreeDepth(root.left);
				 int num2 = TreeDepth(root.right);
				 if(Math.abs(num1-num2)>1){
					 flag = false;
				 }
				 return Math.max(num1,num2)+1;
			 }else{
				 return 0;
			 }
		  
		
	}
	public boolean IsBalanced_Solution(TreeNode root) {
	  /**
	    * 方法一：平衡二叉树的定义就是左右子树的深度差距<=1;
	    * 该方法虽然简单，但是结点都被重复遍历，效率低
	    */
		  if(root != null){
				 int num1 = TreeDepth(root.left);
				 int num2 = TreeDepth(root.right);
				 if(Math.abs(num1-num2)>1){
					 return false;
				 }else{
					 return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
				 }
			 }else{
				 return true;
			 }
	   }
	  /**
	    * 方法就是递归查找每个结点左右子树，深度的最大值，到达叶子结点
	    */
	 public int TreeDepth(TreeNode root) {
		
		 if(root != null){
			 int num1 = TreeDepth(root.left);
			 int num2 = TreeDepth(root.right);
			 return Math.max(num1,num2)+1;
		 }else{
			 return 0;
		 }
	 }
}
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}