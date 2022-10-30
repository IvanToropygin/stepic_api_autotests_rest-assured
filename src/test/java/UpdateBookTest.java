import bookstore.tests.rest.Book;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateBookTest extends BookStoreTestBase {
    private Integer id;

    @BeforeClass
    public void setUp(){
        id = testClient.create(Book.defaultOf())
                .checkStatusCode(201).getID();
    }

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testUpdateBook(Book book){
        testClient.update(id, book)
                .checkStatusCode(200)
                .checkId(id)
                .checkLastUpdated()
                .checkBook(book);

        testClient.read(id)
                .checkStatusCode(200)
                .checkId(id)
                .checkLastUpdated()
                .checkBook(book);;
    }
}
