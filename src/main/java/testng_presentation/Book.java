package testng_presentation;

public class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Book() {}

    public String getName() {
        return name;
    }

    public void setName(String bName) {
        this.name = bName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bName='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
