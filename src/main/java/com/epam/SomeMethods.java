package com.epam;

import java.util.*;

public class SomeMethods {

    int sum() {
        return (int) (Math.random() * 50 + Math.random() * 50 - 10);
    }

    List<Character> generateListABC() {
        return Arrays.asList(getRandomChar('a', 'b', 'c'),
                getRandomChar('a', 'b', 'c'),
                getRandomChar('a', 'b', 'c'));
    }

    List<Character> generateListDEF() {
        return Arrays.asList(getRandomChar('d', 'e', 'f'),
                getRandomChar('d', 'e', 'f'),
                getRandomChar('d', 'e', 'f'));
    }

    static char getRandomChar(char c1, char c2, char c3) {
        char[] charArray = {c1, c2, c3};
        return charArray[(int) (Math.random() * charArray.length)];
    }

    private double divide() {
        return Math.random() * 50 / (Math.random() * 50 - 30);
    }

    private String printMessage(String msg) {
        return msg + getRandomChar('x', 'y', 'z');
    }
}
