package com.company;

import java.util.Arrays;

public class Matrice {
    private int n;
    private int m;
    private int mod;
    private int[][] matrice;

    private Matrice(int n, int m){
        this.n = n;
        this.m = m;
        matrice = new int[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0;j < m; ++j){
                matrice[i][j] = 0;
            }
        }
    }

    public Matrice(int n, int m, int modulo){
        this.n = n;
        this.m = m;
        this.mod = modulo;
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

    /*public boolean isSameOrder(Matrice other){
        return this.n != other.n || this.m != other.m || this.mod != other.mod;
    }*/

    public Matrice add(Matrice other){
        if(this.mod != other.mod){
            throw new RuntimeException();
        }
        Matrice res = new Matrice(this.n, this.m);
        for(int i = 0; i < n; ++i){
            for(int j = 0;j < m; ++j){
                res.matrice[i][j] = (this.matrice[i][j] + other.matrice[i][j]) % this.mod;
            }
        }
        return res;
    }

    public Matrice sub(Matrice other){
        if(isSameOrder(other)){
            throw new RuntimeException();
        }
        Matrice res = new Matrice(this.n, this.m);
        for(int i = 0; i < n; ++i){
            for(int j = 0;j < m; ++j){
                res.matrice[i][j] = (this.matrice[i][j] - other.matrice[i][j]) % this.mod;
            }
        }
        return res;
    }

    public Matrice mult(Matrice other){
        if(isSameOrder(other)){
            throw new RuntimeException();
        }
        Matrice res = new Matrice(this.n, this.m);
        for(int i = 0; i < n; ++i){
            for(int j = 0;j < m; ++j){
                res.matrice[i][j] = (this.matrice[i][j] * other.matrice[i][j]) % this.mod;
            }
        }
        return res;
    }
}
