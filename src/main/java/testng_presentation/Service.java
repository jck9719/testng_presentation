package testng_presentation;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private final List<Book> bookList = new ArrayList<>();
//
//    public Service(List<Book> bookList) {
//        this.bookList = bookList;
//    }

    //Add book
    public void addBook(Book book) {
        bookList.add(book);
    }

    //Get book by name
    public Book getBookByName(String name) {
        for (Book temp : bookList) {
            if (temp.getbName() == name) {
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
    public void printBooks() {
        for (Book temp : bookList) {
            System.out.println(bookList);
        }
    }

    //Count sum
    public double sumBook(List<Book> bookList) {
        double sum = 0;
        for (int i = 0; i < bookList.size(); ++i) {
            sum = bookList.get(i).getPrice();
        }
        return sum;
    }
}
