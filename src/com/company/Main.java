package com.company;

public class Main {

    public static void main(String[] args) {
        Matrice m1 = new Matrice(3,3,5);
        System.out.println(m1);

        Matrice m2 = new Matrice(3,3,5);
        Matrice m3 = m1.sub(m2);

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
