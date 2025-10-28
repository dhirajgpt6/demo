package com.example.demo.compratorcomparable.beforejava8.comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(((Employee)o1).getAge(), ((Employee)o2).getAge());
    }
}
