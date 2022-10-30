import bookstore.tests.rest.Book;
import bookstore.tests.rest.BookResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateBookTestNegative extends BookStoreTestBase {
    private Integer id;

    @BeforeClass
    public void setUp(){
        id = testClient.create(Book.defaultOf())
                .checkStatusCode(201).getID();
    }

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testUpdateBookNegative(Book book){
        testClient.update(id, book)
                .checkStatusCode(400)
                .checkErrorResponse(BookResponse.updateError400(id));

        testClient.read(id)
                .checkStatusCode(200)
                .checkId(id)
                .checkLastUpdated()
                .checkBook(Book.defaultOf());
    }
}
