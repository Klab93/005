package com.company;

/**
 * Opération représentant l'addition entre deux matrices.
 */
public class Addition extends Operation {

    /**
     * Fonction effectuant l'addition de deux entiers.
     */
    @Override
    public Integer apply(Integer lhs, Integer rhs) {
        return lhs + rhs;
    }
}
