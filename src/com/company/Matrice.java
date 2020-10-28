package com.company;

/**
 * Matrice de taille quelconque (n x m) contenant des éléments entre 0 et mod-1
 * où mod est un entier définit comme le modulo utilisé pour toutes les
 * opérations sur la matrice.
 */
public class Matrice {

    /**
     * Le nombre de lignes de la matrice. 
     */
    final private int n;

    /**
     * Le nombre de colonnes de la matrice.
     */
    final private int m;

    /**
     * Le modulo utilisé pour effectuer les opérations. 
     */
    private int mod;

    /**
     * Les composantes de la matrice.
     */
    final private int[][] matrice;

    /**
     * Constructeur principal initialisant toutes les composantes à zéro.
     *
     * @throws RuntimeException si le modulo est négatif ou nul
     */
    private Matrice(int n, int m) {
        if (n < 0 || m < 0) {
            throw new RuntimeException();
        }
        this.n = n;
        this.m = m;
        matrice = new int[n][m];
    }

    /**
     * Constructeur à partir de valeurs données.
     * S'il manque des valeurs, elles sont remplacées par 0 et les valeurs
     * supplémentaires sont ignorées.
     *
     * @throws RuntimeException si le modulo est négatif ou nul
     */
    public Matrice(int[][] values, int n, int m, int modulo) {
        this(n, m);
        if (modulo <= 0) {
            throw new RuntimeException();
        }
        this.mod = modulo;
        for(int i = 0; i < Math.min(values.length, n); ++i){
            for(int j = 0; j < Math.min(values[0].length, m); ++j){
                matrice[i][j] = Math.floorMod(values[i][j], this.mod);
            }
        }
    }

    /**
     * Constructeur générant les composantes aléatoirement.
     *
     * @throws RuntimeException si le modulo est négatif ou nul
     */
    public Matrice(int n, int m, int modulo) {
        this(n, m);
        if (modulo <= 0) {
            throw new RuntimeException();
        }
        this.mod = modulo;
        for (int i = 0; i < n; ++i) {
            for (int j = 0;j < m; ++j) {
                matrice[i][j] = (int) Math.round(Math.random() * modulo);
            }
        }
    }

    /**
     * Renvoie la représentation d'une matrice sous la forme d'une chaîne de
     * caractères
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < n; ++i) {
            for (int j = 0;j < m; ++j) {
                s += matrice[i][j];
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Effectue une opération sur toutes les composantes de la matrice.
     * 
     * @throws RuntimeException si les deux matrices ont un modulo différent
     */
    private Matrice operation(Matrice other, Operation op) {
        if (this.mod != other.mod) {
            throw new RuntimeException();
        }
        int nMax = Math.max(this.n, other.n);
        int mMax = Math.max(this.m, other.m);
        Matrice one = new Matrice(this.matrice, nMax, mMax, this.mod);
        Matrice two = new Matrice(other.matrice, nMax, mMax, other.mod);
        Matrice res = new Matrice(nMax, mMax);
        for (int i = 0; i < nMax; ++i) {
            for (int j = 0;j < mMax; ++j) {
                res.matrice[i][j] = Math.floorMod(
                    op.apply(one.matrice[i][j], two.matrice[i][j]),
                    this.mod
                );
            }
        }
        return res;
    }

    /**
     * Effectue l'addition des composantes correspondantes de deux matrices.
     *
     * @throws RuntimeException si les deux matrices ont un modulo différent
     */
    public Matrice add(Matrice other) {
        return operation(other, new Addition());
    }

    /**
     * Effectue la soustraction des composantes correspondantes de deux
     * matrices.
     *
     * @throws RuntimeException si les deux matrices ont un modulo différent
     */
    public Matrice sub(Matrice other) {
        return operation(other, new Soustraction());
    }

    /**
     * Effectue la multiplication des composantes correspondantes de deux
     * matrices.
     *
     * @throws RuntimeException si les deux matrices ont un modulo différent
     */
    public Matrice mult(Matrice other) {
        return operation(other, new Multiplication());
    }
}
