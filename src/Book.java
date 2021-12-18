/**
 * This class is a super class that is extended by both
 * PhysicalBook and EBook. It holds the initial fields and
 * basic functionality for accessing those fields. It also
 * holds the base details() & toString() methods.
 */
public class Book {
    private String ISBN;
    private String author;
    private String title;

    /**
     * Constructor for all Book objects. Takes in values.
     *
     * @param ISBN ISBN of book or resource.
     * @param author Author of book or resource.
     * @param title Title of book opr resource.
     */
    public Book(String ISBN, String author, String title){
        this.ISBN=ISBN;
        this.author=author;
        this.title=title;
    }

    /**
     * Constructor that provides default values for basic
     * object creation in other classes.
     */
    public Book(){
        this.ISBN="";
        this.author="";
        this.title="";
    }

    /**
     * Returns the ISBN value of book or resource.
     *
     * @return current ISBN.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Changes ISBN value of book or resource.
     *
     * @param ISBN new ISBN.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Provides Author of book or resource.
     *
     * @return current Author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Changes author of book or resource.
     * @param author new Author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Provides current Title of book or resource.
     *
     * @return current Title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Updates the Title of a book to a new one.
     *
     * @param title new Title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Provides printed out details of book or resource.
     */
    public void details(){
        System.out.println("ISBN: "+ISBN+"\n"+
                "Author: "+author+"\n"+
                "Title: "+title);
    }

    @Override
    public String toString(){
        return "ISBN: "+ISBN+"\n"+
                "Author: "+author+"\n"+
                "Title: "+title;
    }
}
