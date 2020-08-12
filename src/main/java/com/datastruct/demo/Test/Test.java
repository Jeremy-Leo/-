package com.datastruct.demo.Test;

import com.alibaba.fastjson.JSON;
import com.datastruct.demo.线性表.StudyList;
import com.datastruct.demo.线性表.顺序存储结构.MyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (C),2015-2020,Neusoft
 *
 * @FileName: Test
 * @Author: dreamerlee
 * @Date: 2020-06-08 10:28
 * @Description:
 * @Version: V1.0.0
 * History:
 * <author>        <time>        <version>     <desc>
 * 作者姓名         修改时间          版本        修改内容
 */
public class Test {

    public static void main(String[] args) {
        StudyList<Integer> myList = new MyList<Integer>();
        List<Integer> ll = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        myList.listAdd(1);
        myList.listAdd(2);
        myList.listAdd(3);
        System.out.println("List长度=========="+myList.listLength());
        System.out.println("List中的序号1的数据为:======="+myList.getElem(1));
        System.out.println("删除位置2的元素===="+myList.listDelete(2));
        System.out.println("获取是否与3有匹配====="+myList.locateElem(3));
        myList.listInsert(3,2);
        System.out.println(myList.getElem(0));
        System.out.println(JSON.toJSONString(myList));
//        System.out.println(JSON.toJSONString(list));
//        myList.clearList();

    }
}
