import bookstore.tests.rest.TestClient;

public class BookStoreTestBase {
    protected static TestClient testClient;

    static {
        testClient = new TestClient();
    }
}
