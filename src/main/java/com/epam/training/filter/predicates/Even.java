package com.epam.training.filter.predicates;

public class Even<T extends Number> implements Predicate<T>{
    @Override
    public boolean check(T value) {
        return value.intValue() % 2 == 0;
    }
}
