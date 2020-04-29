package ru.otus;

import ru.otus.test.ClassToTest;
import ru.otus.testEngine.TestStarter;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String... args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ClassToTest classToTest = new ClassToTest();
        TestStarter testStarter = new TestStarter(classToTest.getClass());
        testStarter.runTests();
        testStarter.printResults();
    }
}
