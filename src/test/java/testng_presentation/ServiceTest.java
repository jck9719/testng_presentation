package testng_presentation;

import org.testng.Assert;
import org.testng.annotations.*;


public class ServiceTest {
    private Service service;
    private Book bookAlpha;
    private Book bookBeta;

    @BeforeMethod
    public void setUp() {
        service = new Service();
        bookAlpha = new Book("Alpha", 21);
        bookBeta = new Book("Beta", 37);
    }

    @AfterMethod
    public void tearDown() {
        service = null;
        bookAlpha = null;
        bookBeta = null;
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
    public void addTwoBooksNegativeCountTest() {
        service.addBook(bookAlpha);
        service.addBook(bookBeta);

        Assert.assertNotEquals(service.countBooks(), 0);
    }

    @Test
    public void getBookByNamePositiveNameTest() {
        service.addBook(bookAlpha);
        service.addBook(bookBeta);
        Book temp = service.getBookByName("Beta");

        Assert.assertEquals(temp.getName(), "Beta");
    }

    @Test
    public void getBookByNamePositivePriceTest() {
        service.addBook(bookAlpha);
        Book temp = service.getBookByName("Alpha");

        Assert.assertEquals(temp.getPrice(), 21.00);
    }

    @Test
    public void editBookPositiveTest() {
        service.addBook(bookAlpha);
        service.editBook("Alpha", bookBeta);
        Book temp = service.getBookByName("Beta");
        String name = temp.getName();

        Assert.assertEquals(name, "Beta");
    }

    @Test
    public void deleteBookPositiveTest() {
        service.addBook(bookAlpha);
        service.addBook(bookBeta);
        service.deleteBook("Alpha");

        Assert.assertEquals(service.countBooks(), 1);
    }

    @Test
    public void sumBooksPositiveTest() {
        service.addBook(bookAlpha);
        service.addBook(bookBeta);
        double sum = service.sumBook();

        Assert.assertEquals(sum, 58.00);
    }

    @Test(enabled = false)
    public void printBooksDisabledTest() {
        service.addBook(bookBeta);
        service.addBook(bookAlpha);

        Assert.assertEquals(service.printBooks(), "To się nie wykona");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void nullExceptionOnGetBookByNameTest() {
        service.getBookByName(null);
    }

    @Test
    @Parameters("Gamma")
    public void parametrizedCheckIfExistsBookTest(@Optional("Gamma") String name) {
        service.addBook(bookAlpha);
        service.addBook(bookBeta);

        Assert.assertFalse(service.checkIfExists(name));
    }

    @Test(dependsOnMethods = { "tempMethod" })
    public void dependsOnMethodTempCheckIfExistsTest() {

        service.addBook(bookAlpha);

        Assert.assertTrue(service.checkIfExists("Alpha"));
    }

    @Test
    public void tempMethod() {
        System.out.println("Metoda potrzebna do ukazania dependsOnMethods");
    }



}
