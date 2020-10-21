package com.guo.practice.codepractice.problems.example;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestExample1 {

    public static void main(String[] args) {
        String[][] data = new String[][]{{"a", "b"}, {"a", "d"}, {"e", "f"}};
        Stream<String[]> temp = Arrays.stream(data);

//        Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));

        Stream stringStream = temp.flatMap(x-> Arrays.stream(x));
        stringStream.forEach(System.out::println);

        Stream<String> stream = stringStream.filter(y -> "a".equals(y.toString()));
        stream.forEach(System.out::println);
    }
}
