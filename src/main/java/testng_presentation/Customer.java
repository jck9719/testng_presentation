package testng_presentation;

import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private List<Book> bookList;

    public Customer(String name, String surname, List<Book> bookList) {
        this.name = name;
        this.surname = surname;
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
