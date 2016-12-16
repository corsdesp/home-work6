package com.epam.training.filter;

import com.epam.training.filter.predicates.*;
import com.epam.training.filter.predicates.Predicate;
import org.junit.Assert;
import org.junit.Test;

import javax.sql.rowset.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtilTest {
    @Test
    public void filterIntegerEvenTest() throws Exception {
        List<Integer> src = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> result = Arrays.asList(2, 4, 6);

        Assert.assertTrue(ArrayUtil.filter(src, new Even<>()).equals(result));
    }

    @Test
    public void filterIntegerUnevenTest() throws Exception {
        List<Integer> src = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> result = Arrays.asList(1, 3, 5, 7);

        Assert.assertTrue(ArrayUtil.filter(src, new Uneven<>()).equals(result));
    }

    @Test
    public void filterIntegerHundredTest() throws Exception {
        List<Integer> src = Arrays.asList(100, 2, 303, -4, 0, 60, 7777);
        List<Integer> result = Arrays.asList(100, 303, 7777);

        Assert.assertTrue(ArrayUtil.filter(src, new Hundred<>()).equals(result));
    }

    @Test
    public void filterLongNegativeTest() throws Exception {
        List<Long> src = Arrays.asList((long)1, (long)-2, (long)3, (long)-4, (long)5, (long)0, (long)7);
        List<Long> result = Arrays.asList((long)-2, (long)-4);

        Assert.assertTrue(ArrayUtil.filter(src, new Negative<>()).equals(result));
    }

    @Test
    public void filterIntegerPositiveTest() throws Exception {
        List<Integer> src = Arrays.asList(1, -2, 3, -4, 5, 6, -7);
        List<Integer> result = Arrays.asList(1, 3, 5, 6);

        Assert.assertTrue(ArrayUtil.filter(src, new Positive<>()).equals(result));
    }

    @Test
    public void filterNullPredicateTest() throws Exception {
        List<Integer> src = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Predicate<Integer> predicate = null;

        Assert.assertTrue(ArrayUtil.filter(src, predicate).equals(result));
    }

    @Test
    public void filterNullListTest() throws Exception {
        List<Double> src = null;
        List<Double> result = new ArrayList<>();

        Assert.assertTrue(ArrayUtil.filter(src, new Positive<>()).equals(result));
    }

}