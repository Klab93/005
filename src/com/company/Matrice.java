package com.company;

import java.util.Arrays;

public class Matrice {
    private int n;
    private int m;
    private int mod;
    private int[][] matrice;

    public Matrice(int n, int m, int modulo){
        this.n = n;
        this.m = m;
        matrice = new int[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0;j < m; ++j){
                matrice[i][j] = (int) Math.round(Math.random() * modulo);
            }
        }
    }

    @Override
    public String toString() {
        String s = "[";
        for(int i = 0; i < n; ++i){
            if (i != 0){
                s += ",";
            }
            s += "[";
            for(int j = 0;j < m; ++j){
                if (j != 0){
                    s += ",";
                }
                s += matrice[i][j];
            }
            s += "]";
        }
        s += "]";

        return s;
    }
}
