package com.example.utils.mianshi;

/**
 * Created by cicada on 2019/12/20.
 */
public class Singleton {

    public static class SingletonHolder{
        private static final  Singleton instance = new Singleton();
    }


    private  Singleton(){

    }
    public  static  Singleton getInstance(){
        return SingletonHolder.instance;
    }

    /***
     * 第一次初始化Singleton的时候并不会初始化instance，只有在第一次调用getInstance方法时，才会导致instance初始化。
     * 因此第一次调用getInstance的方法会导致虚拟机加载 SingletonHolder类
     * 这种方式不仅能够确保线程安全，而且也能保证单利对象的唯一性，同时延迟了单利的实例化。
     *
     *
     * 原因：虚拟机会保证一个类的构造器<clinit>() 方法在多线程环境中正确的加载、同步，如果多个线程同时去初始化这个类，
     * 只有一个线程去执行这个类的构造器<clinit>() 方法，其他线程都需要阻塞等待，值活动线程的<clinit>() 方法执行完毕
     */
}
