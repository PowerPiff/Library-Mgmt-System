import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Testing class for the functionality of the member class,
 * its methods and how they interact with other classes lists
 * and methods.
 * Test classes have been commented if tested elsewhere by other functions.
 */
class MemberTest {

    private Member m1 = new Member("yo","Scott Smith", "Glasgow");
    private Member m2 = new Member("hey", "Hamlin Poppy", "Edinburgh");
    private Library lib = new Library(30, "San Dennis Community Library");
    private Book b3 = new PhysicalBook("10077FLLM", "John", "Book 2");


    @BeforeEach
    void setUp() {
        lib.addResource(b3);
        lib.addMember(m1);
    }

    @Test
    void getBorrowed() {
        //Tested by borrowed in Library.
    }

    @Test
    void getMessages() {
        //Tested by setMessages.
    }

    /**
     * Tests setting new message, adding it to end by
     * showing non-equality to original message.
     * Tests set & get messages.
     */
    @Test
    void setMessages() {
        assert m1.getMessages() == "yo";
        m1.setMessages("bud");
        System.out.println(m1.getMessages());
        assert m1.getMessages() != "yo";
    }

    /**
     * Tests to show userId Auto-generated instead of userId error. Will be different
     * every time as every test, "new" user is added.
     *
     */
    @Test
    void getUserId() {
        m1.getUserId();
    }

    /**
     * Tests that adding a member to the member list (BeforeEach)
     * already auto-generated a userId. So it should not be empty String.
     */
    @Test
    void makeUserId() {
        assert m1.getUserId() != "";


    }

    @Test
    void getName() {
        //Tested in setName.
    }

    /**
     * Tests changing name of user.
     * Tests getName method.
     */
    @Test
    void setName() {
        m1.getName();
        m1.setName("W");
        m1.getName();
        assert (m1.getName().equals("W"));
    }

    @Test
    void getTown() {
        //Tested in setTown().
    }

    /**
     * Tests changing the name of the town.
     * Tests getting the name also.
     */
    @Test
    void setTown() {
        m1.getTown();
        m1.setTown("Markarth");
        m1.getTown();
        assert(m1.getTown().equals("Markarth"));
    }

    /**
     * Tests printing details of member before and after ID
     * generation.
     * Tests makeUserId also.
     */
    @Test
    void memberDetails() {
        m1.memberDetails();
        m1.makeUserId();
        m1.memberDetails();
        assert (true);
    }

    @Test
    void memberMessages() {
        //Tested in notifyAll() in Library class.
    }

    /**
     * Tests for all borrowed books and lists them.
     * If borrowed list contains book, it WILL print the list.
     */
    @Test
    void listBorrowed() {
        lib.borrow(b3,m1);
        m1.listBorrowed();
        if(m1.getBorrowed().contains(b3)){
            assert(true);
        } else{
            assert(false);
        }

    }

    @Test
    void numberBorrowed() {
        //Tested in notifyAll() in Library class.
        //Tested in borrow() and returnBook().
    }

    /**
     * Test member borrowing a book, truth
     * derived from list size increasing.
     */
    @Test
    void borrow(){
       assert m1.numberBorrowed() == 0;
       m1.borrowBook(b3);
       assert m1.numberBorrowed() ==1;
    }

    /**
     * Tests member returning book.
     * Tests borrow() also.
     */
    @Test
    void returnBook(){
        assert m1.numberBorrowed() == 0;
        m1.borrowBook(b3);
        assert m1.numberBorrowed() ==1;
        m1.returnBook(b3);
        assert m1.numberBorrowed() == 0;

    }
}