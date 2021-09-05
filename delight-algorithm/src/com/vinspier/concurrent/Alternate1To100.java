package com.vinspier.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程 1-100交替打印
 *
 * @author  vinspier
 * @date    2021/9/5 7:58 下午
 * @version 1.0
 * @menu
*/
public class Alternate1To100 {

    /**
     * 是否切换
     */
    public static boolean alternate = false;

    /**
     * 打印起始位
     */
    public static int index = 1;

    /**
     * 重入锁
     * */
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    public static Semaphore semaphore = new Semaphore(1);

    /**
     * 原子变量 打印起始位
     */
    public static AtomicInteger atomicStart = new AtomicInteger(1);

    public static void main(String[] args) {
        Alternate1To100 alternate1To100 = new Alternate1To100();
//        alternate1To100.alternate_1();
//        alternate1To100.alternate_2();
//        alternate1To100.alternate_3();
        alternate1To100.alternate_4();
    }


    /**
     * 方式一：synchronized关键字实现
     * */
    public void alternate_1(){
        // 打印奇数
        new Thread(() -> {
            while (index < 101){
                synchronized (this){
                    if ((index & 1) == 1){
                        System.out.println(index++);
                    }
                }
            }
        }).start();
        // 打印偶数
        new Thread(() -> {
            while (index < 101){
                synchronized (this){
                    if ((index & 1) == 0){
                        System.out.println(index++);
                    }
                }
            }
        }).start();
    }

    /**
     * 方式二：使用原子变量CAS原理
     * */
    public void alternate_2(){
        new Thread(() -> {
            while (atomicStart.get() < 101){
                if ((atomicStart.get() & 1) == 1){
                    System.out.println(atomicStart.get());
                    atomicStart.getAndIncrement();
                }
            }
        }).start();
        // 打印偶数
        new Thread(() -> {
            while (atomicStart.get() < 101){
                if ((atomicStart.get() & 1) == 0){
                    System.out.println(atomicStart.get());
                    atomicStart.getAndIncrement();
                }
            }
        }).start();
    }

    /**
     * 方式三：reentrantLock
     * */
    public void alternate_3(){
        // 打印奇数
        new Thread(() -> {
            while (index < 101){
                try {
                    lock.lock();
                    if (alternate){
                        condition.await();
                    }
                    System.out.println(index++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        // 打印偶数
        new Thread(() -> {
            while (index < 101){
                try {
                    lock.lock();
                    if (!alternate){
                        condition.await();
                    }
                    System.out.println(index++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }


    /**
     * 方式三：JU包下的信号量
     * */
    public void alternate_4(){
        // 打印奇数
        new Thread(() -> {
            while (index < 101){
                try {
                    semaphore.acquire();
                    if (!alternate){
                        System.out.println(index++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        }).start();
        // 打印偶数
        new Thread(() -> {
            while (index < 101){
                try {
                    semaphore.acquire();
                    if (alternate){
                        System.out.println(index++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        }).start();
    }

}
