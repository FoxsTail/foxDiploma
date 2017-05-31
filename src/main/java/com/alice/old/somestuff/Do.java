package com.alice.old.somestuff;

/**
 * Created by User on 006 06.05.17.
 */
 class A {
    int a;

     A(int a) {
        this.a = a;
    }

    public void printA(){
        System.out.println("From A class number a: " + a);
    }

}

class B extends A {
     int b;

     B(int a, int b) {
        super(a);
        this.b = b;
    }

    public void printB(){
        System.out.println("From B class number b: " +b);
    }

    @Override
    public void printA(){
        System.out.println("From B class number a: " + a);
    }
}
//метод - тип объекта, доступные методы - тип ссылки
public class Do{
    public static void main(String[] args) {
        A a = new A(10);
        B b = new B(11, 12);

        a.printA();

        a = b;

        a.printA();


    }
}