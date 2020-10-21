package com.company;

public class Main {

    public static void main(String[] args) {
        if(args.length != 5 && args.length != 6){
            throw new RuntimeException();
        }

        int n1 = Integer.parseInt(args[0]);
        int m1 = Integer.parseInt(args[1]);
        int n2 = Integer.parseInt(args[2]);
        int m2 = Integer.parseInt(args[3]);
        int n  = Integer.parseInt(args[4]);
        if(args.length == 5){
            test(n1,m1,n2,m2,n);
        }else{
            int m = Integer.parseInt(args[5]);
            test(n1,m1,n2,m2,n,m);
        }
    }

    private static void test(int n1, int m1, int n2, int m2, int n){
        Matrice one = new Matrice(n1,m1,n);
        Matrice two = new Matrice(n2,m2,n);

        System.out.println("The modulus is " + n);
        test(one, two);
    }

    private static void test(int n1, int m1, int n2, int m2, int n, int m){
        Matrice one = new Matrice(n1,m1,n);
        Matrice two = new Matrice(n2,m2,m);

        System.out.println("The first modulus is "  + n + "\n");
        System.out.println("The second modulus is " + m + "\n");
        test(one, two);
    }

    private static void test(Matrice one, Matrice two){
        System.out.println("one");
        System.out.println(one + "\n");

        System.out.println("two");
        System.out.println(two + "\n");

        System.out.println("one + two");
        System.out.println(one.add(two) + "\n");

        System.out.println("one - two");
        System.out.println(one.sub(two) + "\n");

        System.out.println("one * two");
        System.out.println(one.mult(two) + "\n");
    }
}
