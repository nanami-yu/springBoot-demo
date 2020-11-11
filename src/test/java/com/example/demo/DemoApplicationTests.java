package com.example.demo;

import com.example.demo.service.MyFun;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void test1(){

        int num = 0;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world" + num);
            }
        };

        r.run();

        System.out.println("---------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda" + num);

        r1.run();
    }

    @Test
    public void test2(){
        Consumer<String> con = k -> System.out.println(k);
        con.accept("ces");
    }

    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> {
            System.out.println("kkk");
            return Integer.compare(x,y);
        };
        System.out.println(com.compare(1,2));
    }

//    @Test
//    public void test4(){
//        Integer i = operation(100,(x) -> (Integer)x + (Integer)x);
//        System.out.println(i+"-----------");
//        MyFun mf = (x) -> (Integer)x+1;
//        System.out.println(mf.getValue(100));
//    }
//
//    public Integer operation(Integer num, MyFun mf){
//        return mf.getValue(num);
//    }
}
