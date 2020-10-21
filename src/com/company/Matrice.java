package com.company;

import java.util.function.BinaryOperator;

public class Matrice {
    final private int n;
    final private int m;
    private int mod;
    final private int[][] matrice;

    private Matrice(int n, int m){
        if (n < 0 || m < 0) {
            throw new RuntimeException();
        }
        this.n = n;
        this.m = m;
        matrice = new int[n][m];
    }

    public Matrice(int[][] tabValue, int n, int m, int modulo){
        this(n,m);
        if (modulo <= 0) {
            throw new RuntimeException();
        }
        this.mod = modulo;
        for(int i = 0; i < Math.min(tabValue.length, n); ++i){
            for(int j = 0; j < Math.min(tabValue[0].length, m); ++j){
                matrice[i][j] = Math.floorMod(tabValue[i][j], this.mod);
            }
        }
    }

    public Matrice(int n, int m, int modulo){
        this(n,m);
        if (modulo <= 0) {
            throw new RuntimeException();
        }
        this.mod = modulo;
        for(int i = 0; i < n; ++i){
            for(int j = 0;j < m; ++j){
                matrice[i][j] = (int) Math.round(Math.random() * modulo);
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < n; ++i){
            for(int j = 0;j < m; ++j){
                s += matrice[i][j];
            }
            s += "\n";
        }
        return s;
    }

    public Matrice operation(Matrice other, BinaryOperator<Integer> op){
        if(this.mod != other.mod){
            throw new RuntimeException();
        }
        int nMax = Math.max(this.n, other.n);
        int mMax = Math.max(this.m, other.m);
        Matrice one = new Matrice(this.matrice, nMax, mMax, this.mod);
        Matrice two = new Matrice(other.matrice, nMax, mMax, other.mod);
        Matrice res = new Matrice(nMax, mMax);
        for(int i = 0; i < nMax; ++i){
            for(int j = 0;j < mMax; ++j){
                res.matrice[i][j] =  Math.floorMod(op.apply(one.matrice[i][j], two.matrice[i][j]),this.mod) ;
            }
        }
        return res;
    }

    public Matrice add(Matrice other){
        return operation(other, ( i, j) -> i + j);
    }

    public Matrice sub(Matrice other){
        return operation(other, ( i,  j) -> i - j);
    }

    public Matrice mult(Matrice other){
        return operation(other, ( i,  j) -> i * j);
    }
}
