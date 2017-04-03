package com.bywangxp.enterprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author    作者：bywangxp   E-mail: bywangxp@mail.ustc.edu.cn
 * @date      创建时间：2017年3月25日 下午2:44:19 
 * @version   v1.0   
 * @quesetion 
 * @summary 
 *
 */
public class WangyiTest1 {
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while(scanner.hasNext()){
    		int n = Integer.valueOf(scanner.next());
    		ArrayList<Location> list = new ArrayList<Location>();
    		for(int i = 0 ;i < n; i++){
    			int x = Integer.valueOf(scanner.next());
    			int y = Integer.valueOf(scanner.next());
    			Location location = new Location(x, y);
    			list.add(location);
    		}
    		int targetX = Integer.valueOf(scanner.next());
    		int targetY = Integer.valueOf(scanner.next());
    		int walkTime = Integer.valueOf(scanner.next());
    		int taxiTime = Integer.valueOf(scanner.next());
    		System.out.println(solution(list,targetX ,targetY,walkTime,taxiTime));
    }
		
    	
	}

	private static  int solution(ArrayList<Location> list, int targetX, int targetY, int walkTime, int taxiTime) {
		int totalDistance =Math.abs(targetX) + Math.abs(targetY);
		int totalWalkTime =totalDistance * walkTime;
		//找与目标最近的出租车地点
		int sumTaxiTime =Integer.MAX_VALUE;
		for(int i = 0 ;i< list.size();++i){
			Location location = list.get(i);
			//算走路的时间+算坐车的时间
			int taxiWalkTime = (Math.abs(location.x) + Math.abs(location.y)) * walkTime;
			int taxiRunTime = (Math.abs(targetX - location.x) + Math.abs(targetY -location.y)) * taxiTime;;
			if(sumTaxiTime > taxiWalkTime + taxiRunTime){
				sumTaxiTime = taxiWalkTime + taxiRunTime;
			}
		}
		if(sumTaxiTime >= totalWalkTime){
			return totalWalkTime;
		}else{
			return sumTaxiTime;
		}
	}

}
class Location{
	int x;
	int y;
	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}
