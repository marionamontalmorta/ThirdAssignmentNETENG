package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> getBooksByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getYear() == year) {
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}