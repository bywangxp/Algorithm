package com.bywangxp.enterprise;


import java.util.Scanner;

public class HuaWeiTest {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            String str=in.next();
            String a=str.split(",")[0];
            String b=str.split(",")[1];
            System.out.println(reverseAdd(Integer.valueOf(a),Integer.valueOf(b)));
        }

    }
    public static int reverseAdd(int a,int b){
        if(a<1||a>70000||b<1||b>70000)
            return -1;
        StringBuffer bufferOne=new StringBuffer(String.valueOf(a));
        StringBuffer bufferTwo=new StringBuffer(String.valueOf(b));
        bufferOne=bufferOne.reverse();
        bufferTwo=bufferTwo.reverse();
        Integer one=Integer.valueOf(bufferOne.toString());
        Integer two=Integer.valueOf(bufferTwo.toString());
        return one+two;
    }
}
