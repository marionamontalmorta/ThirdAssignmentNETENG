package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- LIBRARY ---");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search by author");
            System.out.println("4. Search by year");
            System.out.println("5. List all books");
            System.out.println("0. Exit");
            System.out.print("Option: ");
            String option = scanner.nextLine();
            try {
                switch (option) {
                    case "1" -> {
                        library.addBook(readBook(scanner));
                        System.out.println("Book added.");
                    }
                    case "2" -> {
                        boolean removed = library.removeBook(readBook(scanner));
                        System.out.println(removed ? "Book removed." : "Book not found.");
                    }
                    case "3" -> {
                        System.out.print("Author: ");
                        printBooks(library.getBooksByAuthor(scanner.nextLine()));
                    }
                    case "4" -> {
                        System.out.print("Year: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        printBooks(library.getBooksByYear(year));
                    }
                    case "5" -> printBooks(library.getAllBooks());
                    case "0" -> running = false;
                    default -> System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("The year must be a number.");
            }
        }
        System.out.println("Bye!");
    }

    private static Book readBook(Scanner scanner) {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        return new Book(title, author, year);
    }

    private static void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }
}