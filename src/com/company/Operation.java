package com.company;

/**
 * Interface représentant une opération à effectuer sur les composantes
 * correspondantes de deux matrices.
 */
public interface Operation {

    /**
     * Fonction effectuant une opération à partir de deux opérandes.
     */
    public Integer apply(Integer lhs, Integer rhs);
}
