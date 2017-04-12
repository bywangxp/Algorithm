package com.bywangxp.enterprise;


import java.util.Scanner;

public class HuaWeiTest2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            StringBuffer order=new StringBuffer(in.next());
            StringBuffer origin=new StringBuffer("123456");
            System.out.println(changeOrder(order,origin));
        }
    }
    public static StringBuffer changeOrder(StringBuffer order,StringBuffer status){
        for(int i=0;i<order.length();i++){
            StringBuffer one=new StringBuffer(status.substring(0,2));
            StringBuffer two=new StringBuffer(status.substring(2,4));
            StringBuffer three=new StringBuffer(status.substring(4,6));
            StringBuffer temp;
            if(order.charAt(i)=='L'){
                temp=one;
                one=three;
                three=temp.reverse();
            }else if(order.charAt(i)=='R'){
                temp=one;
                one=three.reverse();
                three=temp;
            }else if(order.charAt(i)=='F'){
                temp=two;
                two=three;
                three=temp.reverse();
            }
            else if(order.charAt(i)=='B'){
                temp=two;
                two=three.reverse();
                three=temp;
            }
            else if(order.charAt(i)=='A'){
                temp=one;
                one=two.reverse();
                two=temp;
            }
            else if(order.charAt(i)=='C'){
                temp=one;
                one=two;
                two=temp.reverse();
            }
            status=new StringBuffer(one.toString()+two.toString()+three.toString());
        }
        return status;
    }
}
