import bookstore.tests.rest.Book;
import bookstore.tests.rest.BookValidatableResponse;
import org.testng.annotations.Test;

public class CreateBookTest extends BookStoreTestBase {

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testCreateBook(Book book){
        BookValidatableResponse response = testClient.create(book)
                .checkStatusCode(201)
                .checkIdNotNull()
                .checkLastUpdated()
                .checkBook(book);

        testClient.read(response.getID())
                .checkStatusCode(200)
                .checkId(response.getID())
                .checkLastUpdated()
                .checkBook(book);
    }
}
