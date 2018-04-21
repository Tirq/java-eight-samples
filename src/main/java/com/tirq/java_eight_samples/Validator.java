package com.tirq.java_eight_samples;

@FunctionalInterface
public interface Validator<T> {
	boolean isValid(T t);
}
