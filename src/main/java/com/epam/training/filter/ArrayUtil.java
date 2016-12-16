package com.epam.training.filter;

import com.epam.training.filter.predicates.Predicate;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
    public static <T> List<T> filter(List<T> src, Predicate<? super T> predicate) {
        List<T> result = new ArrayList<T>();
        if (src == null || predicate == null) {
            return result;
        }
        for (T value : src) {
            if (predicate.check(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
