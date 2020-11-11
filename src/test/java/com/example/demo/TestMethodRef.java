package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintStream;
import java.util.function.Consumer;

@SpringBootTest
public class TestMethodRef {
    @Test
    public void test1(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("111");
        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
        con1.accept("222");

        
    }
}
