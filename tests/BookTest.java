import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of all of the methods held
 * within the book class.
 * Test classes have been commented if tested elsewhere by other functions.
 */
class BookTest {

    private Book b1 = new PhysicalBook("09266FL", "Michael", "Book 1");
    private Book b3 = new PhysicalBook("10077FLLM", "John", "Book 2");
    private Book b2 = new PhysicalBook("1864BNS", "Alexandra", "Book 3");

    @Test
    void getISBN() {
        //Tested by setISBN.
    }

    /**
     * Setting an ISBN.
     * Tests set & get ISBN.
     */
    @Test
    void setISBN() {
        assert b1.getISBN()== "09266FL";
        b1.setISBN("we3");
        assert b1.getISBN()=="we3";
    }

    @Test
    void getAuthor() {
        //Tested by setAuthor.
    }

    /**
     * Setting author.
     * Tests set & get Author.
     */
    @Test
    void setAuthor() {
        assert b1.getAuthor() == "Michael";
        b1.setAuthor("B");
        assert b1.getAuthor() == "B";
    }

    @Test
    void getTitle() {
        //Tested by editTitle in Library.
    }

    @Test
    void setTitle() {
        //Tested by editTitle in Library.
    }

    @Test
    void details() {
        //Tested in subclass EBook.
    }
}