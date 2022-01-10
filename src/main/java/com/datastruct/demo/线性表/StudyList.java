package com.datastruct.demo.线性表;

/**
 *
 *
 * @FileName: List
 * @Author: dreamerlee
 * @Date: 2020-07-07 11:26
 * @Description:
 * @Version: V1.0.0
 * History:
 * <author>        <time>        <version>     <desc>
 * 作者姓名         修改时间          版本        修改内容
 */
public interface StudyList<E>  {
    /**
     * 若线性表为空，返回true,否则返回false
     * @return boolean true/false
     */
    boolean listEmpty();

    /**
     * 清空线性表
     */
    void clearList();

    /**
     * 将线性表中的第i个位置的元素值返回
     * @param i 元素下标
     * @return   元素
     */
    E getElem(int i);

    /**
     * 将线性表L中查找与给定值相等的元素，如果查找成功，返回该元素在表中首次出现序号表示成功，否则返回0表示失败
     * @param e 待查找元素
     * @return 序号
     */
    int locateElem(E e);


    /**
     * 在线性表中的第i个位置插入新元素e
     * @param e 待插入元素
     * @param i 待插入位置
     */
    void listInsert(E e,int i);

    /**
     * 向线性表中放入数据
     * @param e 新增元素
     */
    void listAdd(E e);
    /**
     * 删除线性表中第i个位置元素，并用e返回其值
     * @param i 待删除位置
     * @return 删除的元素
     */
    E listDelete(int i);

    /**
     * 返回线性表的元素个数
     * @return 个数
     */
    int listLength();
}
