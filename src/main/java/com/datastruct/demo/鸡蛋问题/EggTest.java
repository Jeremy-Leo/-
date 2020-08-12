package com.datastruct.demo.鸡蛋问题;

/**
 * @author lee.c
 * @PackageName:com.datastruct.demo.鸡蛋问题
 * @ClassName: EggTest
 * @Description:
 * @date 2020 2020/2/7 14:04
 */
public class EggTest {
    public static void main(String[] args) {
        for (int i=1;i<1000000;i++){
            if ((63*i)%3==0 && (63*i)%4==1 && (63*i)%5==4 && (63*i)%6==3 && (63*i)%8==1){
                System.out.println(63*i);
                System.err.println(i);
            }
        }
    }
}
