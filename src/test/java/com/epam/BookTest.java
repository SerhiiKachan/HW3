package com.epam;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class BookTest {

    private static Book book;
    private static final Logger LOG = Logger.getLogger(BookTest.class.getSimpleName());

    @BeforeClass
    public static void initTest() {
        book = new Book();
    }

    @AfterClass
    public static void finishTest() {
        book = null;
    }

    @Test
    public void testBooksForEquality() {
        Book newBook = new Book();
        assertNotSame(newBook, book);
    }

    @SuppressWarnings(value = "unchecked")
    @Test
    public void testChangeBookName() {
        Class cl = Book.class;
        Book book1 = new Book("HP1", 300, "Charles");
        Book book2 = new Book();
        try {
            Method method = cl.getDeclaredMethod("changeBookName", Book.class, String.class);
            method.setAccessible(true);
            method.invoke(book, book2, "default");
            assertNotEquals(book2.getBookName(), book1.getBookName());
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
