import bookstore.tests.rest.Book;
import bookstore.tests.rest.Category;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class BookData {
    @DataProvider
    public static Object[][] positive(){
        return new Object[][]{
                {Book.defaultOf()},
                // title min = 3;
                // title max = 256;
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3))},
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256))},

                // description min = 3;
                // description max = 512;
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3))},
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512))},

                // author min = 3;
                // author max = 100;
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3))},
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100))},

                // price >= 0;
                {Book.defaultOf().setPrice(0)},

                // count max >= 0;
                {Book.defaultOf().setCount(0)},

                // categories from enum : [ Adventures, Detective, Fiction, Horror, Thriller ]
                {Book.defaultOf().setCategory(Category.Detective)},
                {Book.defaultOf().setCategory(Category.Fiction)},
                {Book.defaultOf().setCategory(Category.Horror)},
                {Book.defaultOf().setCategory(Category.Thriller)},
        };
    }

    @DataProvider
    public static Object[][] negative(){
        return new Object[][]{

                // title < min = 2;
                // title > max = 257;
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(2))},
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(257))},

                // description < min = 2;
                // description > max = 513;
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(2))},
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(513))},

                // author < min = 2;
                // author > max = 101;
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(2))},
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(101))},

                // price = -1;
                {Book.defaultOf().setPrice(-1)},

                // count = -1;
                {Book.defaultOf().setCount(-1)},

                // categories from enum : [ Unknown ]
                {Book.defaultOf().setCategory(Category.Unknown)},
        };
    }
}
