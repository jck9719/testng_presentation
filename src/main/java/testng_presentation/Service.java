package testng_presentation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Service {
    private final List<Book> bookList = new ArrayList<>();

    //Add book
    public void addBook(Book book) {
        bookList.add(book);
    }

    //Edit book
    public void editBook(String name, Book book) {
        if (name == null) {
            throw new NullPointerException();
        }

        if (checkIfExists(name)) {
            for (Book temp : bookList) {
                if (temp.getName().equals(name)) {
                    temp.setName(book.getName());
                    temp.setPrice(book.getPrice());
                }
            }
        } else {
            System.out.println("ERROR: BOOK COULD NOT BE FOUND");
        }
    }

    //Delete book
    public void deleteBook(String name) {
        if (name == null) {
            throw new NullPointerException();
        }

        if (checkIfExists(name)) {
            bookList.removeIf(next -> next.getName().equals(name));
        } else {
            System.out.println("ERROR: BOOK COULD NOT BE FOUND");
        }
    }

    //Get book by name
    public Book getBookByName(String name) {
        if (name == null) {
            throw new NullPointerException();
        }

        for (Book temp : bookList) {
            if (temp.getName().equals(name)) {
                return temp;
            }
        }
        return null;
    }

    //Count books
    public int countBooks() {
        return bookList.size();
    }

    //Print books
    public String printBooks() {
        return bookList.stream()
                .map(String::valueOf)
                .collect(Collectors
                        .joining("\n{"
                                , "{"
                                , "}"));
    }

    //Count sum
    public double sumBook() {
        double sum = 0;
        for (Book book : bookList) {
            sum += book.getPrice();
        }
        return sum;
    }

    //Check if book exists
    public boolean checkIfExists(String name) {
        if (name == null) {
            throw new NullPointerException();
        }

        for (Book temp : bookList) {
            if (temp.getName().equals(name)) {
                return true;
            }
        }
        return false;

    }
}
