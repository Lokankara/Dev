package com.luxoft.tutor.module08.defaultmethods;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T a, T b);
}