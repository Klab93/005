package com.company;

/**
 * Opération représentant la multiplication entre deux matrices.
 */
public class Multiplication extends Operation {

    /**
     * Fonction effectuant la multiplication de deux entiers.
     */
    @Override
    public Integer apply(Integer lhs, Integer rhs) {
        return lhs * rhs;
    }
}
