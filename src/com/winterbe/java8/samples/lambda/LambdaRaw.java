package com.winterbe.java8.samples.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class LambdaRaw {

    public static void main(String... args) {

        List<String> names = Arrays.asList("Ali", "Ayşe", "Ahmet", "Fatma", "Mehmet");

        Predicate<String> startsWithA = name -> name.startsWith("A");

        names.stream()
                .filter(startsWithA)
                .forEach(name -> System.out.println(name));



        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        int result = add.apply(5, 3);
        System.out.println(result);


        // lambda expression

        Function<String, Integer> stringLength = (String s) -> s.length();

        System.out.println(stringLength.apply("this is for lambda"));

        //
        Tester<String> s = () -> "test";

        System.out.println(s.get());

        // Parrot Challenge

        Parrot p1 =  new Parrot("Ziya");
        Parrot p2 =  new Parrot("Ziya2");
        Parrot p3 =  new Parrot("Ziya3");


        Arrays.asList(p1,p2,p3).stream().forEach(Parrot::sayMyName);


    }


}
