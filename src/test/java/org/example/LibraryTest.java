package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book b1984;
    private Book animalFarm;
    private Book dune;

    @BeforeEach
    public void setUp() {
        library = new Library();
        b1984 = new Book("1984", "George Orwell", 1949);
        animalFarm = new Book("Animal Farm", "George Orwell", 1945);
        dune = new Book("Dune", "Frank Herbert", 1965);
    }

    @Test
    public void newLibraryIsEmpty() {
        assertTrue(library.getAllBooks().isEmpty());
    }

    @Test
    public void addBookAddsIt() {
        library.addBook(b1984);
        assertEquals(1, library.getAllBooks().size());
        assertTrue(library.getAllBooks().contains(b1984));
    }

    @Test
    public void addNullBookThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    public void removeExistingBookReturnsTrue() {
        library.addBook(b1984);
        assertTrue(library.removeBook(b1984));
        assertTrue(library.getAllBooks().isEmpty());
    }

    @Test
    public void removeBookWithEqualDataWorks() {
        library.addBook(b1984);
        assertTrue(library.removeBook(new Book("1984", "George Orwell", 1949)));
    }

    @Test
    public void removeNonExistingBookReturnsFalse() {
        library.addBook(b1984);
        assertFalse(library.removeBook(dune));
        assertEquals(1, library.getAllBooks().size());
    }

    @Test
    public void getBooksByAuthorReturnsMatchingBooks() {
        library.addBook(b1984);
        library.addBook(animalFarm);
        library.addBook(dune);
        assertEquals(List.of(b1984, animalFarm), library.getBooksByAuthor("George Orwell"));
    }

    @Test
    public void getBooksByAuthorIgnoresCase() {
        library.addBook(dune);
        assertEquals(List.of(dune), library.getBooksByAuthor("frank herbert"));
    }

    @Test
    public void getBooksByUnknownAuthorReturnsEmptyList() {
        library.addBook(b1984);
        assertTrue(library.getBooksByAuthor("Tolkien").isEmpty());
    }

    @Test
    public void getBooksByYearReturnsMatchingBooks() {
        library.addBook(b1984);
        library.addBook(dune);
        assertEquals(List.of(dune), library.getBooksByYear(1965));
    }

    @Test
    public void getBooksByYearWithNoMatchesReturnsEmptyList() {
        library.addBook(b1984);
        assertTrue(library.getBooksByYear(2000).isEmpty());
    }

    @Test
    public void getAllBooksReturnsCopy() {
        library.addBook(b1984);
        library.getAllBooks().clear();
        assertEquals(1, library.getAllBooks().size());
    }
}