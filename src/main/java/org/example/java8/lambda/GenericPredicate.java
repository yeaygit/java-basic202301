package org.example.java8.lambda;

@FunctionalInterface
public interface GenericPredicate<T> {
    //generic 쓸 때 어떤 알파벳 상관없음
    // T extends apple 이렇게 사용 가능
    boolean test(T t);


}

