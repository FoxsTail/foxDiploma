package com.alice.old.somestuff;

/**
 * Created by User on 009 09.05.17.
 */
class Ob{
    private int a;
    private int b;

    public Ob(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class HashCheck {
    public static void main(String[] args) {
        Ob o1 = new Ob(5, 10);
        Ob o2 = new Ob(5, 10);

        System.out.println(o1.equals(o2));
        System.out.println(o1.hashCode() == o2.hashCode());
    }
}
