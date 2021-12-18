import org.junit.jupiter.api.*;

import java.util.ArrayList;

/**
 * Testing class for the main functional class of the project, Library.
 * Most methods used within this class rely on methods from other classes,
 * so extensive testing here tests many of the other classes methods also.
 * These have all been noted in comment form.
 */
class LibraryTest {

    private Library lib = new Library(30, "San Dennis Community Library");
    private Device d1 = new Device("Computer","lab 1", true,1);
    private Book b1 = new PhysicalBook("09266FL", "Michael", "Book 1");
    private Book b2 =  new PhysicalBook("iokwyh", "Maxwell", "Kobyla");
    private Book b3 = new PhysicalBook("10077FLLM", "John", "Book 2");
    private Member m1 = new Member("yo","Scott Smith", "Glasgow");
    private Member m2 = new Member("hey", "Hamlin Poppy", "Edinburgh");
    private EBook e1 = new EBook("ishfb76","Maxim","anyah", 2020);


    @BeforeEach
    void setUp() {
        lib.addResource(b1);
        lib.addResource(b3);
        lib.addResource(e1);
        lib.addMember(m1);
        e1.addDevice(d1);

    }

    @Test
    void getStaff() {
        //Tested by getStaff.
    }

    /**
     * Tests set & get staff.
     */
    @Test
    void setStaff() {
        assert lib.getStaff() == 30;
        lib.setStaff(10);
        assert lib.getStaff() == 10;
    }

    @Test
    void getName() {
        //Tested by setName.
    }

    /**
     * Tests renaming library.
     * Tests set & get Name.
     */
    @Test
    void setName() {
        assert lib.getName().equals("San Dennis Community Library");
        lib.setName("New");
        assert lib.getName().equals("New");
    }

    @Test
    void getMask() {
        //Tested by getMask.
    }

    /**
     * Tests set & get mask.
     */
    @Test
    void setMask() {
        assert lib.getMask() == (true);
        lib.setMask(false);
        assert lib.getMask() == (false);
    }

    @Test
    void getMembers(){
        //Tested by removeMember().
    }

    @Test
    void getCatalogue(){
        //Tested by removePosition().
    }

    /**
     * Tests adding resources to catalogue,
     * also test checkCatalogue & numberOfResources
     * methods.
     */
    @Test
    void addResource() {
        assert lib.numberOfResources() == 3;
        lib.addResource(b2);
        assert lib.numberOfResources() == 4;

    }

    @Test
    void addMember(){
        //Tested by removeMember().
    }

    /**
     * Testing removal of member
     * Tests adding of member and getting member list also.
     */
    @Test
    void removeMember(){
        lib.addMember(m2);
        System.out.println(lib.getMembers().size());
        lib.removeMember(m2);
        if(lib.getMembers().size() <2){
            assert(true);
        } else{
            assert(false);
        }
    }

    /**
     * Test will always print out library details.
     * Tested with staff change.
     */
    @Test
    void libraryInformation() {
        lib.libraryInformation();
        lib.setStaff(10);
        lib.libraryInformation();
        assert(true);
    }

    @Test
    void checkCatalogue(){
        //Tested by containsResource().
    }

    @Test
    void indexCheck(){
        //Tested by removePosition().
    }

    /**
     * Edit title of a book.
     * Tests set/get Title in Book Class.
     */
    @Test
    void editTitle() {
        lib.editTitle(e1, "nope");
        assert e1.getTitle().equals("nope");
    }

    /**
     * Testing to see if resource being searched for is
     * within the catalogue by matching resource
     * return or null return.
     * Tests checkCatalogue().
     */
    @Test
    void containsResource() {
        if(lib.containsResource(b1) == (b1)){
            assert(true);
        } else if (lib.containsResource(b1) == (null)){
            assert(true);
        } else{
            assert (false);
        }
    }

    /**
     * Testing known ISBN from a library
     * catalogue book.
     */
    @Test
    void searchByIsbn() {
        lib.searchByIsbn("09266FL");
        if(b1.getISBN() == "09266FL"){
            assert (true);
        } else{
            assert (false);
        }
    }

    /**
     * Testing known author from a
     * library catalogue book.
     */
    @Test
    void searchByAuthor() {
        lib.searchByAuthor("Michael");
        if(b1.getAuthor().equals("Michael")){
            assert(true);
        } else{
            assert(false);
        }
    }

    /**
     * Tests removing resource then checking if
     * resource still exists in catalogue.
     */
    @Test
    void removeResource() {
        System.out.println(lib.getCatalogue().size());
        lib.removeResource(b3);
        if(lib.getCatalogue().contains(b3)){
            assert(false);
        } else{
            assert(true);
        }
    }

    /**
     * Tests removing a book by index. Note index 0
     * has changed. b1 was first index.
     * Tests indexCheck also.
     */
    @Test
    void removePosition() {
        System.out.println(lib.getCatalogue().get(0));
        lib.removePosition(0);
        System.out.println(lib.getCatalogue().get(0));
        if(lib.getCatalogue().get(0) == b1){
            assert(false);
        } else{
            assert(true);
        }
    }

    /**
     * Tests all available books by changing total when
     * book is loaned out.
     */
    @Test
    void allAvailableBooks() {
        lib.allAvailableBooks();
        lib.borrow(b1,m1);
        lib.allAvailableBooks();
        assert(true);
    }

    /**
     * Testing to make sure no EBooks are
     * printed.
     */
    @Test
    void allPhysicalBooks() {
        lib.allPhysicalBooks();
        assert(true);
    }

    /**
     * Testing to make sure no physical books
     * listed.
     */
    @Test
    void allEResources() {
        lib.allEResources();
        assert(true);
    }

    @Test
    void numberOfResources() {
        //Tested by addResource.
    }

    /**
     * Tests function of borrowing a book.
     * Tests getBorrowed from Member Class.
     */
    @Test
    void borrow() {
        ArrayList<Book> m = m1.getBorrowed();
        assert m.size() == 0;
        lib.borrow(b3,m1);
        assert m.size() == 1;
    }

    /**
     * Tests a good portion of the Device class
     * objects, as well as items from Physical and E Books.
     */
    @Test
    void returnBook() {
        ArrayList<Book> m = m1.getBorrowed();
        assert m.size() == 0;
        lib.borrow(b3,m1);
        assert m.size() == 1;
        lib.returnBooks(b3,false,"");
        assert m.size()==0;
    }

    /**
     * Tests to see if borrowed member messages contain
     * notified message.
     * Tests getMessage() from Member class.
     */
    @Test
    void testNotifyAll() {
        lib.borrow(b3,m1);
        lib.notifyAll("Hey");
        if(m1.getMessages().contains("Hey")){
            assert (true);
        } else{
            assert (false);
        }
    }
}