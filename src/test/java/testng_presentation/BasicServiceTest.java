package testng_presentation;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.*;


public class BasicServiceTest {
    private Service service;
    Book bookAlpha = new Book("Alpha", 21);
    Book bookBeta = new Book("Beta", 37);


    @BeforeTest
    public void setUp() {
        service = new Service();
    }

    @AfterTest
    public void tearDown() {
        service = null;
    }

    @Test
    public void addBookPositiveTest() {
       service.addBook(bookBeta);

       Assert.assertNotNull(service.getBookByName("Beta"));
    }

    @Test
    public void addBookNegativeTest() {
        service.addBook(bookBeta);

        Assert.assertNull(service.getBookByName("Alpha"));
    }

    @Test
    public void addOneBookPositiveCountTest() {
        service.addBook(bookAlpha);

        Assert.assertEquals(service.countBooks(), 1 );
    }

    @Test
    public void addOneBookNegativeCountTest() {
        service.addBook(bookAlpha);

        Assert.assertNotEquals(service.countBooks(), 0);
    }

    @Test
    public void addTwoBooksPositiveCountTest() {
        service.addBook(bookAlpha);
        service.addBook(bookBeta);

        Assert.assertEquals(service.countBooks(), 2);
    }

    @Test
    public void addTwoBooksNegativeCountTest() {
        service.addBook(bookAlpha);
        service.addBook(bookBeta);

        Assert.assertEquals(service.countBooks(), 0);
    }

}
