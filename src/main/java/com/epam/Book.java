package com.epam;

public class Book {

    private String bookName;
    private int pagesAmount;
    private String authorName;

    Book() {
    }

    Book(String bookName, int pagesAmount, String authorName) {
        this.bookName = bookName;
        this.pagesAmount = pagesAmount;
        this.authorName = authorName;
    }

    String getBookName() {
        return bookName;
    }

    void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return pagesAmount == book.pagesAmount && (bookName != null ? bookName.equals(book.bookName) : book.bookName == null) &&
                (authorName != null ? authorName.equals(book.authorName) : book.authorName == null);
    }

    @Override
    public int hashCode() {
        int result = bookName != null ? bookName.hashCode() : 0;
        result = 31 * result + pagesAmount;
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", pagesAmount=" + pagesAmount +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    private void changeBookName(Book book, String newName) {
        book.setBookName(newName);
    }
}
