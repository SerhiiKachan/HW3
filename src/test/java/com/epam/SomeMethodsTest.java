package com.epam;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class SomeMethodsTest {

    private static SomeMethods methods;
    private static final Logger LOG = Logger.getLogger(SomeMethodsTest.class.getSimpleName());

    @BeforeClass
    public static void initTest() {
        methods = new SomeMethods();
    }

    @AfterClass
    public static void finishTest() {
        methods = null;
    }

    @Test
    public void testSumNegative() {
        assertFalse("Sum is negative", methods.sum() < 0);
    }

    @Test
    public void testListsForEquality() {
        List list1 = methods.generateListABC();
        List list2 = methods.generateListDEF();
        assertNotEquals(list1, list2);
    }

    @Test
    public void testChars() {
        assertThat(SomeMethods.getRandomChar('a', 'b', 'c'), CoreMatchers.is(Character.TYPE));
    }

    @Test
    public void testListForNull() {
        assertNotNull(methods.generateListABC());
    }

    @Test
    public void testArraysForEquality() {
        Object[] array1 = methods.generateListABC().toArray();
        Object[] array2 = {'a', 'b', 'c'};
        assertArrayEquals(array1, array2);
    }

    @Test
    public void listsAreNotSame() {
        List list1 = methods.generateListABC();
        List list2 = methods.generateListABC();
        assertNotSame(list1, list2);
    }

    @SuppressWarnings(value = "unchecked")
    @Test
    public void testDivide() {
        Class cl = SomeMethods.class;
        try {
            Method method = cl.getDeclaredMethod("divide");
            method.setAccessible(true);
            assertNotEquals(0, method.invoke(methods));
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
    }

    @SuppressWarnings(value = "unchecked")
    @Test
    public void testPrintMessage() {
        Class cl = SomeMethods.class;
        try {
            Method method = cl.getDeclaredMethod("printMessage", String.class);
            method.setAccessible(true);
            assertEquals("messy", method.invoke(methods, "mess"));
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
    }

    @Rule
    public MethodRule watchman = new TestWatchman() {
        public void failed(Throwable e, FrameworkMethod method) {
            LOG.warning("Test " + method.getName() + " failed with reason: " + e.getMessage());
        }
    };
}

