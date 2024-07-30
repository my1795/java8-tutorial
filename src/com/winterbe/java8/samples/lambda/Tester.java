package com.winterbe.java8.samples.lambda;


@FunctionalInterface
public interface Tester<T> {


    T get();
}