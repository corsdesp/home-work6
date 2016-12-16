package com.epam.training.filter.predicates;

public interface Predicate<T> {
    boolean check(T value);
}
