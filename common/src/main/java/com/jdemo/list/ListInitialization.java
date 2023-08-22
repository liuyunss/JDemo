package com.jdemo.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 对比list初始化几种方式.
 *
 * @author SKIES
 *         2023-03-14 15:56
 */
public class ListInitialization {

    private List list;

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        ListInitialization listInitialization = new ListInitialization();
        for (int i = 0; i < 1_000_000; i++) {
            listInitialization.newList6();
        }
        long l2 = System.currentTimeMillis();
        long l = Runtime.getRuntime().totalMemory();
        System.out.println((l2-l1) +"     "+l/1024);

    }

    //26     249344
    private void newList1(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
    }

    //44     249344
    private void newList2(){
        List<String> list = new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }};
    }

    //36     249344
    private void newList3(){
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));

    }

    //36     249344
    private void newList4(){
        //返回n个拷贝组成的列表
        List<String> list4 = new ArrayList<>();
        Collections.addAll(list4 , "a", "b", "c");
    }

    //142     249344
    private void newList5(){
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());

    }

    //82     249344
    private void newList6(){
        List<String> list = Lists.newArrayList("a", "b", "c");
    }
}
