/**
 * This class inherits, adds its own values ontop. It provides
 * functionality for creation PhysicalBook objects. It also allows
 * for assignment of members to physical book objects for borrowing.
 */
public class PhysicalBook extends Book {
    private Member user;
    private String damages;
    private boolean available;

    /**
     * Constructor creates PhysicalBook books and assigns initial
     * value of no damage due to most books being new.
     * All newly added books are available by default until borrowed.
     *
     * @param ISBN ISBN og PhysicalBook.
     * @param author Author of PhysicalBook.
     * @param title Title of PhysicalBook.
     */
    public PhysicalBook(String ISBN, String author, String title){
        super(ISBN, author, title);
        this.damages="";
        this.available=true;
    }

    /**
     * Provides the current member who has the book on loan.
     * If the book is not borrowed, it returns null by default.
     *
     * @return current user
     */
    public Member getUser() {
        return user;
    }

    /**
     * Allows for current borrowing member to have the book
     * assigned to them.
     *
     * @param user member borrowing.
     */
    public void setUser(Member user) {
        this.user = user;
    }

    /**
     * Provides access to the current damages on the PhysicalBook.
     *
     * @return book damage.
     */
    public String getDamages() {
        return damages;
    }

    /**
     * Allows for the setting of any damages incurred upon
     * the return of the book.
     *
     * @param damages new damage to book.
     */
    public void setDamages(String damages) {
        this.damages += damages + " | ";
    }

    /**
     * Changes wether the book is currently available or not.
     *
     * @param available new availability.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * This changes the availability of the book based on wether
     * or not it has a current user assigned to it via borrowing.
     *
     * @return true = no current member. false = book borrowed.
     */
    public boolean bookAvailable(){
        if(user == null){
            setAvailable(true);
            return true;
        }
        else{
            setAvailable(false);
            return false;
        }
    }

    /**
     * This builds upon the inherited method and adds the extra
     * PhysicalBook details before printing them. It also checks
     * wether the book is available or not.
     */
    @Override
    public void details() {
        super.details();
        System.out.println("Damages: [ " + damages + " ]");
            if (bookAvailable()) {
                System.out.println("Availability: Available.");
            }
            else {
                System.out.println("Availability: Not available");
            }
    }

    @Override
    public String toString(){
        return super.toString() + "\n"+ "Damages: [ " + damages + " ]";
    }

}
