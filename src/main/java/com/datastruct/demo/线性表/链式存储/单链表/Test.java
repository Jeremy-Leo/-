package com.datastruct.demo.线性表.链式存储.单链表;

/**
 *
 *
 * @FileName: Test
 * @Author: dreamerlee
 * @Date: 2020-07-16 11:04
 * @Description:
 * @Version: V1.0.0
 * History:
 * <author>        <time>        <version>     <desc>
 * 作者姓名         修改时间          版本        修改内容
 */
public class Test {


    public static void main(String[] args) {
        SingleLinkList<String> testList = new SingleLinkList<>();
        //头插法
        testList.add("第一个",1);
        testList.add("第二个",1);
        testList.add("第三个",1);
        System.out.println(testList.toString());
        //尾插法
        SingleLinkList<String> testList2 = new SingleLinkList<>();
        testList2.add("第一个",2);
        testList2.add("第二个",2);
        testList2.add("第三个",2);
        System.out.println(testList2.toString());
    }
}
