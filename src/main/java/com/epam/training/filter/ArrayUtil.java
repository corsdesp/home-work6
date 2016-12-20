package com.epam.training.filter;

import com.epam.training.filter.predicates.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayUtil {
    public static <T> List<T> filter(List<T> src, Predicate<? super T> predicate) {
        List<T> result = new ArrayList<T>();
        if (checkSource(src) || predicate == null) {
            return result;
        }
        for (T value : src) {
            if (predicate.check(value)) {
                result.add(value);
            }
        }
        return result;
    }

    public static <T extends Comparable<? super T>> T averageElement(Collection<? extends T> src) {
        if (checkSource(src)) {
            return null;
        }
        List<T> items = new ArrayList<T>(src);
        Collections.sort(items);
        return items.get(items.size() / 2);
    }

    private static <T> boolean checkSource(Collection<? extends T> src) {
        return src == null || src.isEmpty();
    }
}
