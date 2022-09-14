package com.luxoft.tutor.module08.defaultmethods;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
