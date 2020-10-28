package com.company;

/**
 * Opération représentant la soustraction entre deux matrices.
 */
public class Soustraction extends Operation {

    /**
     * Fonction effectuant la soustration de deux entiers.
     */
    @Override
    public Integer apply(Integer lhs, Integer rhs) {
        return lhs - rhs;
    }
}
