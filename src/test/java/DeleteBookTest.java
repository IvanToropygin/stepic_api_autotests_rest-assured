import bookstore.tests.rest.Book;
import bookstore.tests.rest.BookValidatableResponse;
import org.testng.annotations.Test;

public class DeleteBookTest extends BookStoreTestBase {

    @Test
    public void testDeleteBook(){
        BookValidatableResponse response = testClient.create(Book.defaultOf())
                .checkStatusCode(201);

        testClient.delete(response.getID())
                .checkStatusCode(200);

        testClient.read(response.getID())
                .checkStatusCode(404);
    }

    @Test
    public void testDeleteNotExistedBook(){
        testClient.delete(99999999)
                .checkStatusCode(404);
    }
}
