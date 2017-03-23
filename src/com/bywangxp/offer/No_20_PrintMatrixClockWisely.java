package com.bywangxp.offer;
/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月22日 下午2:00:21 
 * @version   v1.0   
 * @quesetion 输入一个矩阵，按照从外向里以顺时针依此打印出每一个数字
 * @summary   本方法与剑指offer方法不同
 *            本题可以优化的技巧为，直接给出endx，endy，代表右下角的结束点。作为参照
 *
 */
public class No_20_PrintMatrixClockWisely {
	/*
	 * 方法：第一步找到循环打印结束的条件，因为除了最后一次打印，其余都是行遍历了两个，列遍历两个
	 *      所以当发现rows>2*次数&&column>2*次数，因为这里的次数也就是起始点的坐标
	 *      且起始点是从0开始计数，所以以起始点坐标为次数标记的方式，当rows=2*start，
	 *      column=2*start，表示肯定之前已经遍历结束了
	 *      
	 *      第二步找到具体打印的过程结束条件，总共有四个方向打印，
	 *      第一个方向，肯定是有的                  顶部 从左往右
	 *      第二个方向，只有当行最少两行             右边 从上往下
	 *      第三个方向，只有当行最少两行，列最少两列   底部，从右往左
	 *      第四个方向，当行至少三行，两列           左边，从下往上
	 * 
	 * */
	public static void main(String[] args) {
		int [][]array={{1,2,3,4,8},{5,6,7,8,8},{9,10,11,12,9},{13,14,15,16,9}};
		solution(array,5,4);
	}
	public static void solution(int [][]array, int columns , int rows){
		if(array == null || columns == 0 && rows == 0){
			return;
		}
		for(int start = 0; rows > 2 * start && columns > 2 * start; ++start){
			printCircle(array, start, columns, rows);
			System.out.println("结束");
		}
	}

	private static void printCircle(int[][] array, int start , int columns, int rows) {
		//下面的讨论过于复杂，可以参照offer上的写法
		//第一个方向
		int j = start;
		for(; j< columns -start; ++j){
			System.out.print(array[start][j]+",");
		}
		System.out.println();
		--j;
		//当行至少有两行，终止行号，大于起始行号
		int i = start + 1;
		if( rows - start > start ){
			for(; i < rows - start; ++i){
				System.out.print(array[i][j]+",");
			}
			--i;
			System.out.println();
		//第三个方向  行至少两行，列至少两列
			if(columns - start > start){
				--j;
				for(; j >= start ; --j){
					System.out.print(array[i][j]+",");
				}
				++j;
				System.out.println();
		//第四个方向，列至少有两列，行至少三个 ,也就是终止行号比起始行号至少大2
				--i;
				if(i > start){
					for(; i > start; --i){
						System.out.print(array[i][j]+",");
					}
				}
			}
		}		
	}
}
