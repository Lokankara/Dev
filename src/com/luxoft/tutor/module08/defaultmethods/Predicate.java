package com.luxoft.tutor.module08.defaultmethods;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}