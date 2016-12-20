package com.epam.training.filter.predicates;

public class Negative<T extends Number> implements Predicate<T> {
    @Override
    public boolean check(T value) {
        return value.intValue() < 0;
    }
}
