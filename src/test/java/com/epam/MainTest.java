package com.epam;

import org.junit.runner.JUnitCore;

public class MainTest {

    public static void main(String[] args) {
        System.out.println("Start MainTest class...");
        JUnitCore.runClasses(TestSuiteClass.class);
    }
}
