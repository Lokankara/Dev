package com.luxoft.tutor.module08.defaultInterfaces;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}