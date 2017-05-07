package com.alice.old;

/**
 * Created by User on 003 03.05.17.
 */
class NoifImpl implements Runnable {
    private int i;
    private static boolean switcher = true;

    NoifImpl(int i) {
        this.i = i;
    }

    public void run() {
        System.out.println("Начинаем обработку в отдельном потоке - " + Thread.currentThread().getName());
        try {
            findMore(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Заканчиваем обработку в отдельном потоке - " + Thread.currentThread().getName());
    }


    private synchronized void findMore(int n) throws InterruptedException {

        System.out.println("Число потока " + Thread.currentThread().getName() + " - " + n);

        int result = n;
        while (n > 0 && isSwitcher()) {
            n--;
            System.out.println("Поток " + Thread.currentThread().getName() + ": " + n);
            Thread.sleep(10);
        }
        System.out.println(result);
        switcher = false;
    }

    public boolean isSwitcher() {
        return switcher;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println("Последнее выведенное число будет являться наибольшим");
        System.out.println(" ");
        Thread t1 = new Thread(new NoifImpl(11), "t1");
        Thread t2 = new Thread(new NoifImpl(16), "t2");
        System.out.println("Стартуем runnable потоки");
        t1.start();
        t2.start();

    }
}