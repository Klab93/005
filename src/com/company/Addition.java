package com.company;

public class Addition extends Operation {

    @Override
    public Integer apply(Integer lhs, Integer rhs) {
        return lhs + rhs;
    }
}
