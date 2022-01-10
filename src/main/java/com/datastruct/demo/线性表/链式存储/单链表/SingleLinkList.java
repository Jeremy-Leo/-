package com.datastruct.demo.线性表.链式存储.单链表;

/**
 *
 *
 * @FileName: SingleLinkList 单链表
 * @Author: dreamerlee
 * @Date: 2020-07-15 16:05
 * @Description:
 * @Version: V1.0.0
 * History:
 * <author>        <time>        <version>     <desc>
 * 作者姓名         修改时间          版本        修改内容
 */
public class SingleLinkList<E> {
    /**
     * 头节点，并将链表大小放入头节点
     */
    Node<E> head ;

    /**
     * 链表长度
     */
    transient int size = 0;


    /**
     * 构造空链表
     */
    public SingleLinkList(){
        this.head = new Node<>();
    }

    /**
     * 定义单链表中的节点元素
     * @param <E> 返回一个节点
     */
    private  static class Node<E>{
        /**
         * 数据域名
         */
        E  data;
        /**
         * 指针域
         */
        Node<E> next;

        Node(){
            this(null,null);
        }

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    public  E getData(int index){

        if(size==0){
            throw new IllegalArgumentException("链表为空，无任何数据");
        }else if (index<0){
            throw new IllegalArgumentException("索引不合法，请重新输入");
        }
        //从第一个节点开始
        Node<E> node = head.next;
        for(int i=0;i<index;i++){
            node = node.next;
        }
        return node.data;
    }

    /**
     * 新增数据
     * @param data 待插入数据
     * @param type 插入方式 1:头插法，2:尾插法
     */
    public void add(E data,int type){
        //创建待插入节点
        Node<E> newNode = new Node<>(data,null);
        //头插法
        if(type==1||head.next==null){
            //将待插入节点后继地址指向头节点后继地址
            newNode.next = head.next;
            //将头节点的后继地址，指向新加入的节点
            head.next = newNode;

        }else{
            //从头节点开始寻找
            Node<E> lastNode = head.next;
            while(lastNode.next!=null){
                lastNode = lastNode.next;
            }
            //将最后一个节点后继指向新节点
            lastNode.next = newNode;
        }
        //链表长度+1
        size++;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("(");
        Node<E> node = head.next;
        while(node!=null){
            str.append(node.data.toString()).append(",");
            node = node.next;
        }
        str.deleteCharAt(str.length()-1).append(")");
        return str.toString();
    }
}
