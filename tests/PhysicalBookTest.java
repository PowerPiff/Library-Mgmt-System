import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * This Test class tests the functionality of the PhysicalBook class,
 * how its objects are created and moved about as well as how they are changed
 * when interacting with other objects and classes methods.
 * Test classes have been commented if tested elsewhere by other functions.
 */
class PhysicalBookTest extends BookTest {

    private Book b1 = new PhysicalBook("09266FL", "Michael", "Book 1");
    private Book b3 = new PhysicalBook("10077FLLM", "John", "Book 2");
    private Book b2 = new PhysicalBook("1864BNS", "Alexandra", "Book 3");


    @Test
    void getUser() {
        //Tested in borrow() & returnBooks()
        //in the Library Class.
    }

    @Test
    void setUser() {
        //Tested in borrow() & returnBooks()
        //in the Library Class.
    }

    @Test
    void getDamages() {
        //Tested by setDamages().
    }

    /**
     * Tests by printing damages list.
     * This is also tested in the returnBooks() method
     * in the Library Class.
     * Tests getDamages() also.
     */
    @Test
    void setDamages() {
        System.out.println(((PhysicalBook)b1).getDamages());
        ((PhysicalBook)b1).setDamages("left corner");
        System.out.println(((PhysicalBook)b1).getDamages());
    }

    @Test
    void setAvailable() {
        //Tested in borrow() in Library Class.
    }

    @Test
    void bookAvailable() {
        //Tested in allAvailableBooks() &
        //borrow() in Library Class.
    }

    @Test
    void testDetails() {
        //Details tested in sub-class EBook, this
        //method functions the same, so it works.
    }
}