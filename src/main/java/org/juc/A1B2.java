package org.juc;

import java.util.concurrent.locks.LockSupport;

public class A1B2 {
    private char[] a = "abcdefg".toCharArray();
    private char[] b = "1234567".toCharArray();

    public static void main(String[] args) {
        new A1B2().sync();
    }

    void sync(){
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            for (char c : a) {
                synchronized (o) {
                    try {
                        System.out.println(c);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    o.notify();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (char c : b) {
                synchronized (o) {
                    try {
                        System.out.println(c);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    o.notify();
                }
            }
        });
        t1.start();
        t2.start();

    }

    static Thread t1 = null,t2 = null;
    void supportLock(){
        t1 = new Thread(() -> {
            {
                for (char c : a) {
                    System.out.println(c);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });

        t2 = new Thread(() -> {
            for (char c : b) {
                System.out.println(c);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });
        t1.start();
        t2.start();
    }
}
