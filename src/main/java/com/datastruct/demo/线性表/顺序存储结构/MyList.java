package com.datastruct.demo.线性表.顺序存储结构;

import com.datastruct.demo.线性表.StudyList;
import sun.misc.SharedSecrets;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Copyright (C),2015-2020,Neusoft
 *
 * @FileName: MyList
 * @Author: dreamerlee
 * @Date: 2020-07-07 10:49
 * @Description:
 * @Version: V1.0.0
 * History:
 * <author>        <time>        <version>     <desc>
 * 作者姓名         修改时间          版本        修改内容
 */
public class MyList<E> implements StudyList<E>, Serializable  {

    private Object[] listElem;

    /**
     * list中元素的数量（线性表长度,数据个数）
     */
    private int size;

    /**
     * 初始化一个默认的数组长度
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * 初始化一个有参构造器空的数组对象
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    public MyList(int maxSize){
        if(maxSize > 0 ){
            this.listElem = new Object[maxSize];
        }else if(maxSize ==0){
            this.listElem = EMPTY_ELEMENTDATA;
        }else{
            throw new IllegalArgumentException("参数不合法！！！！！");
        }
    }

    public MyList(){
        this.listElem =DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    /**
     * 若线性表为空，返回true,否则返回false
     *
     * @return boolean true/false
     */
    @Override
    public boolean listEmpty() {
        return size==0;
    }
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
        // Write out element count, and any hidden stuff
        s.defaultWriteObject();

        // Write out size as capacity for behavioural compatibility with clone()
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (int i=0; i<size; i++) {
            s.writeObject(listElem[i]);
        }


    }

    /**
     * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
     * deserialize it).
     */
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        listElem = EMPTY_ELEMENTDATA;

        // Read in size, and any hidden stuff
        s.defaultReadObject();

        // Read in capacity
        s.readInt(); // ignored

        if (size > 0) {
            // be like clone(), allocate array based upon size not capacity
            int capacity = calculateMinSize(listElem, size);
            SharedSecrets.getJavaOISAccess().checkArray(s, Object[].class, capacity);
            ensureCapacityMinSize(size);

            Object[] a = listElem;
            // Read in all elements in the proper order.
            for (int i=0; i<size; i++) {
                a[i] = s.readObject();
            }
        }
    }


    /**
     * 清空线性表
     */
    @Override
    public void clearList() {
        for(int i =0;i<size;i++){
            listElem[i]=null;
        }
        size=0;
    }

    /**
     * 将线性表中的第i个位置的元素值返回
     *
     * @param i 元素下标
     * @return 元素
     */
    @Override
    @SuppressWarnings("unchecked")
    public E getElem(int i) {
        if(i < 0 || i > size - 1){
            throw new IllegalArgumentException("参数不合法");
        }
        return (E) this.listElem[i];
    }

    /**
     * 将线性表L中查找与给定值相等的元素，如果查找成功，返回该元素在表中首次出现序号表示成功，否则返回-1表示失败
     *
     * @param e 待查找元素
     * @return 序号
     */
    @Override
    public int locateElem(E e) {
        if(e == null){
            for(int i=0;i<size;i++){
                if(listElem[i]==null){
                    return i;
                }
            }
        }else{
            for(int i=0;i<size;i++){
                if(e.equals(listElem[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 在线性表中的第i个位置插入新元素e
     *
     * @param e 待插入元素
     * @param i 待插入位置
     */
    @Override
    public void listInsert(E e, int i) {

        //判断是否需要扩容
        ensureCapacityMinSize(calculateMinSize(listElem,i));
        //移动插入位置及后的所有数据
        System.arraycopy(listElem,i,listElem,i+1,size-i);
        //插入数据
        listElem[i]=e;
        size++;
    }

    /**
     * 向线性表中放入数据
     *
     * @param e 新增元素
     */
    @Override
    public void listAdd(E e) {
        ensureCapacityMinSize(size+1);
        listElem[size++]=e;
    }


    /**
     * 计算当前数组需要承载的数据大小
     * @param elementData listElem 当前list数组
     * @param minSize 插入后所需数组胀肚
     * @return 最小长度
     */
    private static int calculateMinSize(Object[] elementData,int minSize){
        //如果当前数组是无参构造器构造的，则直接返回默认大小（10），如果有参构造器构造，则返回初始化大小+1
        if(elementData==DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            return  Math.max(DEFAULT_SIZE,minSize);
        }
        return minSize;
    }

    /**
     * 确保当前数组可以承载需要的数据量，如果不够则进行扩容
     * @param minSize 需要承载大小
     */
    private void ensureCapacityMinSize(int minSize){
        if(minSize>listElem.length){
            expansion(minSize);
        }
    }

    /**
     * 扩容
     * @param minSize 需要大小
     */
    public void expansion(int minSize){
        int oldSize = listElem.length;
        int newSize = oldSize + oldSize >> 1;
        if(newSize<minSize){
            newSize = minSize;
        }
        if(newSize > Integer.MAX_VALUE-8){
           newSize = newBigSize(minSize);
        }
        listElem = Arrays.copyOf(listElem,newSize);
    }

    /**
     * 大容量数据判断
     * @param minSize 需要大小
     * @return 需要的最大容量
     */
    public static int  newBigSize(int minSize){
        return (minSize>Integer.MAX_VALUE-8)? Integer.MAX_VALUE-8: Integer.MAX_VALUE;
    }

    /**
     * 删除线性表中第i个位置元素，并用e返回其值
     *
     * @param i 待删除位置
     * @return 删除的元素
     */
    @Override
    @SuppressWarnings("unchecked")
    public E listDelete(int i) {
        //先判断i是否合理
        if(i<1|| i >size){
            throw new IllegalArgumentException("参数超出范围");
        }
        //取出对应数据
       Object deleteData = listElem[i];
       System.arraycopy(listElem,i+1,listElem,i,size-i-1);
       //最后一位删除
        listElem[--size]=null;
        return (E) deleteData;
    }

    /**
     * 返回线性表的元素个数
     *
     * @return 个数
     */
    @Override
    public int listLength() {
        return size;
    }
}
