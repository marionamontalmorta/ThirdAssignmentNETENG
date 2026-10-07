package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void gettersReturnCorrectValues() {
        Book book = new Book("1984", "George Orwell", 1949);
        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertEquals(1949, book.getYear());
    }

    @Test
    public void booksWithSameDataAreEqual() {
        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("1984", "George Orwell", 1949);
        assertEquals(b1, b2);
        assertEquals(b1.hashCode(), b2.hashCode());
    }

    @Test
    public void booksWithDifferentDataAreNotEqual() {
        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("Animal Farm", "George Orwell", 1945);
        assertNotEquals(b1, b2);
    }

    @Test
    public void bookIsNotEqualToNull() {
        Book b1 = new Book("1984", "George Orwell", 1949);
        assertNotEquals(null, b1);
    }
}