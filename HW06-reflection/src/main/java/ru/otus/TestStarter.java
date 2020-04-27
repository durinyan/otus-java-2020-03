package ru.otus;

import ru.otus.annotation.After;
import ru.otus.annotation.Before;
import ru.otus.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class TestStarter {
    private Class<?> clazz;
    private Object objectToTest;
    private List<Method> beforeMethods;
    private List<Method> afterMethods;
    private List<Method> testMethods;
    private List<Method> failedTests;

    public TestStarter(Class<?> classToTest) {
        clazz = classToTest;
        beforeMethods = new ArrayList<>();
        afterMethods = new ArrayList<>();
        testMethods = new ArrayList<>();
        for (Method method : classToTest.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Before.class)) {
                beforeMethods.add(method);
            }
            if (method.isAnnotationPresent(After.class)) {
                afterMethods.add(method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }
    }

    public void runTests() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        failedTests = new ArrayList<>();
        for (Method test : testMethods) {
            objectToTest = clazz.getConstructor().newInstance();
            for (Method before : beforeMethods) {
                runMethod(before);
            }
            boolean testPassed = runMethod(test);
            if (!testPassed) {
                failedTests.add(test);
            }
            for (Method after : afterMethods) {
                runMethod(after);
            }
        }

    }

    private boolean runMethod(Method method) {
        try {
            method.invoke(objectToTest);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void printResults() {
        System.out.println("------------");
        System.out.println("TEST RESULTS");
        System.out.println(String.format("Total tests: %s", testMethods.size()));
        System.out.println(String.format("Passed tests: %s", testMethods.size() - failedTests.size()));
        System.out.println(String.format("Failed tests: %s", failedTests.size()));
    }
}
