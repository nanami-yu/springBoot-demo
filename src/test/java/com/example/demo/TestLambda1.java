package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Consumer;

@SpringBootTest
public class TestLambda1 {

    @Test
    public void test(){
        //Consumer
        Consumer<String> cs = x -> System.out.println(x);
        cs.accept("ces");
    }
}
