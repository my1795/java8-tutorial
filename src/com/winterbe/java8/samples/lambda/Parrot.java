package com.winterbe.java8.samples.lambda;

public class Parrot {

    String name;

    Parrot(String name ){
        this.name=name;
    }

    public void sayMyName(){
        System.out.println(name);
    }
}
