package com.jdemo.list;


/**
 * Created by Administrator on 2023/7/28.
 */
public class Demo {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;
        int c = a ^ b;
//        a = a ^ b;
//        b = b ^ a;
//        a = a ^ b;
//        System.out.println( a );
//        System.out.println( b );
//        System.out.println( a ^ b );
//        System.out.println( b ^ 101094 );
        System.out.println(a ^ b);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.parseInt("11110",2));
    }
}
