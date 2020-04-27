package ru.otus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
    public static void main(String... args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ClassToTest classToTest = new ClassToTest();
        TestStarter testStarter = new TestStarter(classToTest.getClass());
        testStarter.runTests();
        testStarter.printResults();
    }
}
