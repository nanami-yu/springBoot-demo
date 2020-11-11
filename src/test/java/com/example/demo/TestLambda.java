package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.service.MyFun;
import com.example.demo.service.cn;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class TestLambda {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "zhangsan", 18, 9999.99),
            new Employee(102, "lisi", 59, 6666.66),
            new Employee(103, "wangwu", 28, 3333.33),
            new Employee(104, "zhaoliu", 8, 7777.77),
            new Employee(105, "tianqi", 38, 5555.55)
    );

    @Test
    public void test1() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp.toString());
        }
    }

    @Test
    public void test2() {
        //MyFun mf = (x) -> x.trim().toLowerCase();
        MyFun mf = (x) -> x.toLowerCase();
        System.out.println(mf.getValue("\t\t\t FFF"));
    }

    //TODO 需要改一下
    public Long getValue(Long a, Long b, cn<Long, Long> c) {
        return c.get(a, b);
    }

    @Test
    public void test3() {
        System.out.println(getValue(100L, 200L, (x, y) -> {
            return x * y;
        }));
    }
}
