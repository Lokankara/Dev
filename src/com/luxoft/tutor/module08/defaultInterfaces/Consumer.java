package com.luxoft.tutor.module08.defaultInterfaces;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
