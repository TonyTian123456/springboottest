package com.example.utils.mianshi;

/**
 * Created by cicada on 2019/12/23.
 */
public class DeadLockTest {

    private static  Object lock1 =new Object();
    private static  Object lock2 =new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock1){
                try {
                    System.out.println("thread1 begin");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("thread1 End");
                }
            }

        }).start();

        new Thread(()->{
            synchronized (lock2){
                try {
                    System.out.println("thread2 begin");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("thread2 End");
                }
            }

        }).start();

        System.out.println("main thread end");
    }
}
