import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents physical members of the library,
 * used to facilitate the borrowing of books and adding them
 * to members borrowed lists, creation of ID and provide general
 *  get&set methods to access member details.
 */
public class Member {

    private ArrayList<Book> borrowed;
    private String messages;
    private String userId;
    private String name;
    private String town;

    /**
     * Constructor takes in initial member details when generating a
     * member object.
     *
     * @param messages any messages to member from library.
     * @param name Full name of member.
     * @param town Town member lives in.
     */
    public Member(String messages, String name, String town) {
        borrowed = new ArrayList<>();
        this.messages = messages;
        this.name = name;
        this.town = town;
        this.userId = "";
    }

    /**
     * Empty constructor for use in generating member objects
     * in other classes.
     */
    public Member() {
    }

    /**
     * Provides access to a members borrowed books list.
     *
     * @return borrowed books list
     */
    public ArrayList<Book> getBorrowed() {
        return borrowed;
    }

    /**
     * Provides access to a members messages from
     * the library.
     *
     * @return messages from library.
     */
    public String getMessages() {
        return messages;
    }

    /**
     * Allows the creation of new messages to be added on
     * to any previous messages.
     *
     * @param message Notification from the library.
     */
    public void setMessages(String message) {
        messages+= " | "+ message;
    }

    /**
     * Checks to see wether the username has been generated or
     * not. If not, it requests one to be made. If so, returns
     * the userId, validating it.
     *
     * @return "" = if empty. userId = if generated.
     */
    public String getUserId() {
        if(userId == ""){
            System.out.println("no userId found, please make one.");
            return "";
        }
        else{
            System.out.println(userId);
            return userId;
        }
    }

    /**
     * Generates a userId for a member when a member
     * is being added. This produces a unique Id for
     * members who potentially share the same name.
     */
    public void makeUserId(){
        Random rand = new Random();
        int upper = 300;
        if(name.length()>3 && town.length()>4) {
            this.userId = name.substring(0, 2) + town.substring(1, 3);
            this.userId += rand.nextInt(upper);
        }
        else{
            this.userId += rand.nextInt(upper);
            this.userId += name.substring(0,1);
            this.userId+= town.substring(0,1);
        }
    }

    /**
     * Provides the name of the member.
     *
     * @return name of member.
     */
    public String getName() {
        return name;
    }

    /**
     * Allows the changing of a members name.
     *
     * @param name new name for member.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Provides the town the member lives in.
     *
     * @return curren member town.
     */
    public String getTown() {
        return town;
    }

    /**
     * Allows changes to town in event member moves.
     *
     * @param town new town member lives in.
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Provides ability for member to add book
     * they are borrowing to borrowed list.
     *
     * @param book book borrowing.
     */
    public void borrowBook(Book book){
            borrowed.add(book);
    }

    /**
     * Allows member to remove book from borrowed list
     * and return it.
     *
     * @param book book being returned.
     */
    public void returnBook(Book book){
        borrowed.remove(book);
    }

    /**
     * Provides a printed list of a members details including;
     * name, Id and town.
     */
    public void memberDetails(){
        System.out.println("Name: "+name+"\n"+
                            "Id: "+userId+"\n"+
                            "Town: "+town+"\n");

    }

    /**
     * Provides a printed list of all messages sent to member.
     */
    public void memberMessages(){
        System.out.println("Messages: "+messages+"\n");
    }

    /**
     * provides a printed list of all the books a member has
     * borrowed from the library.
     */
    public void listBorrowed(){
        for(Book book:borrowed){
            System.out.println(book);
        }
    }

    /**
     * Returns the integer number of books borrowed by a member.
     *
     * @return number of books borrowed by member.
     */
    public int numberBorrowed(){
      int i = 0;
      for(Book book:borrowed){
          i++;
      }
      return i;
    }
}
