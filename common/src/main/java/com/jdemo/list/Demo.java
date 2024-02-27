package com.jdemo.list;


/**
 * Created by Administrator on 2023/7/28.
 */
public class Demo {
    public static void main(String[] args) {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
        System.out.println(a[0]);
        System.out.println(b[0]);
    }
}
