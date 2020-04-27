package ru.otus;

import ru.otus.annotation.After;
import ru.otus.annotation.Before;
import ru.otus.annotation.Test;

public class ClassToTest {

    @Before
    public void method1(){
        System.out.println("@Before Method 1");
    }

    @Test
    public void method2(){
        System.out.println("@Test Method 2");
    }

    @Test
    public void throwException(){
        throw new RuntimeException();
    }

    @Test
    public void method5(){
        System.out.println("@Test Method 5");
    }

    @After
    public void method3(){
        System.out.println("@After Method 3");
    }

    @After
    public void method4(){
        System.out.println("@After Method 4");
    }

    public ClassToTest() {
    }
}
