import bookstore.tests.rest.Book;
import bookstore.tests.rest.BookResponse;
import bookstore.tests.rest.Category;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateBookTestNegative extends BookStoreTestBase {

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testCreateBook(Book book){
        testClient.create(book).checkStatusCode(400)
                .checkErrorResponse(BookResponse.createError400());
    }
}
