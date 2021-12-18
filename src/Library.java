import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a physical library. People can
 * become members, borrow books, access e-resources by
 * using library devices. Books can also be stored here and
 * catalogued by staff. This is where the functionality
 * of the library as a building is accessed.
 */
public class Library {
    private ArrayList<Book> catalogue;
    private ArrayList<Member> members;
    private int staff;
    private String name;
    private boolean mask;
    private Device device;

    /**
     * Constructor for the library class, takes in staff number
     * and name of library initially.
     *
     * @param staff number of staff initially
     * @param name name of library
     */
    public Library(int staff, String name){
        catalogue = new ArrayList<>();
        members = new ArrayList<>();
        this.staff = staff;
        this.name=name;
        this.mask=true;
        device=new Device();
    }

    /**
     * Gets number of staff currently at library.
     *
     * @return number of staff.
     */
    public int getStaff() {
        return staff;
    }

    /**
     * Changes number of staff at library.
     *
     * @param staff new number of staff.
     */
    public void setStaff(int staff) {
        this.staff = staff;
    }

    /**
     * Gets name of library.
     *
     * @return name of library.
     */
    public String getName() {
        return name;
    }

    /**
     * Changes name of library.
     *
     * @param name new name of library.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets mask wearing covid rules.
     *
     * @return masks on(true) or off(false).
     */
    public boolean getMask() {
        return mask;
    }

    /**
     * Changes the mask-wearing rules at the library.
     *
     * @param mask true = on. false = off.
     */
    public void setMask(boolean mask) {
        this.mask = mask;
    }

    /**
     * Gets current list of members.
     * @return list of members.
     */
    public ArrayList<Member> getMembers() {
        return members;
    }

    /**
     * Gets current catalogue of books.
     * EBooks included in this list.
     *
     * @return catalogue of books.
     */
    public ArrayList<Book> getCatalogue() {
        return catalogue;
    }

    /**
     * If a resource is not already present in the catalogue,
     * this method adds the resource to the catalogue. It prints
     * a warning message if item is already there.
     *
     * @param book resource to be added.
     */
    public void addResource(Book book){
        if(checkCatalogue(book)){
            System.out.println("The catalogue already contains this resource.");
        }
        else{
            catalogue.add(book);
        }
    }

    /**
     * If member is on the list, prints message informing staff with
     * memberId attached.
     * If member does not exist, generates the member a memberId and
     * adds member to the list.
     *
     * @param member
     */
    public void addMember(Member member){
        if (checkMember(member)) {
            System.out.println("This person is already a member"+"\n"+
                    "Member Id: " + member.getUserId());
        }
        else{
            member.makeUserId();
            members.add(member);
        }
    }

    /**
     * If member exists in list, removes member from list.
     * Prints an error message if member not already in list.
     *
     * @param member member to be removed from list.
     */
    public void removeMember(Member member){
        if(checkMember(member)){
            members.remove(member);
        }
        else{
            System.out.println("Error: This member does not exist.");
        }
    }

    /**
     * Prints out all the information held about the library
     * including the current covid mask rules.
     */
    public void libraryInformation(){
        System.out.println("Name: "+name+"\n"
        +"Number of staff: "+staff+"\n"
        +"Covid Rules: ");
        if(mask){
            System.out.println("Masks on");
        }
        else{
            System.out.println("Masks off");
        }
    }

    /**
     * Checks to see if a resource is already present
     * in the library catalogue.
     *
     * @param resource resource to look for.
     * @return true = it's present. false = it's not present.
     */
    public boolean checkCatalogue(Book resource){
        if (catalogue.contains(resource)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Checks to see if a member exists already in the
     * members list.
     *
     * @param member member to check for.
     * @return true = is present. false = is not present.
     */
    public boolean checkMember(Member member){
        if(members.contains(member)){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Checks the catalogue for the existence of an index
     * and catches the error for any index not present, it then
     * prints an Error for the user.
     *
     * @param index index to be checked.
     * @return true = index exists. false = index does not exist.
     */
    public boolean indexCheck(int index){
        try{
            catalogue.get(index);
            return true;
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Error: Index does not exist.");
            return false;
        }
    }

    /**
     * This edits the Title of the book after checking if the book exists.
     * if it does not, it provides an appropriate error message.
     *
     * @param resource resource being edited.
     * @param input new Title for the resource.
     */
    public void editTitle(Book resource, String input){
        if(checkCatalogue(resource)){
            resource.setTitle(input);
        }
        else{
            System.out.println("The resource could not be found.");
        }
    }

    /**
     * This checks that if the catalogue holds the resource, then the
     * resource is returned for use elsewhere as a parameter or print
     * statement.
     *
     * @param resource resource being checked.
     * @return resource = if it exists. null = if resource does not exist.
     */
    public Book containsResource(Book resource) {
        if (checkCatalogue(resource)) {
            return resource;
        }
        else{
            return null;
        }
    }

    /**
     * Searches the catalogue for resources with a matching
     * ISBN. If ISBN is an E-resource, provides this information
     * to the user as well as year uploaded.
     *
     * @param ISBN ISBN String to search for.
     */
    public void searchByIsbn(String ISBN){
        int i = 0;
        for(Book isbn:catalogue){
            if(isbn.getISBN() == ISBN){
                System.out.println(isbn.toString());
                i++;
                if(isbn instanceof EBook){
                    System.out.println("This is an E-Resource." + "\n" +
                                        "Uploaded: "+ ((EBook) isbn).getUploadYear());
                }
            }
        }
        System.out.println("Total found: "+i);
    }

    /**
     * Searches the catalogue by Author and provides a total number of
     * books by this author. If no books found, message printed to
     * provide user this information.
     *
     * @param author Author String being searched for.
     */
    public void searchByAuthor(String author){
        int i=0;
        for(Book auth:catalogue){
            if(auth.getAuthor() == author){
                System.out.println(auth.toString());
                i++;
            }
        }
        if(i == 0){
            System.out.println("No books by this author were found. " +
                    "Please amend your search.");
        } else{
            System.out.println("Number of books by "
                    +author +": "+i);
        }
    }

    /**
     * Checks for the presence of the resource and removes it from
     * the catalogue if present. If no resources found, alerts
     * user.
     *
     * @param resource resource being searched for
     */
    public void removeResource(Book resource
    ){
        boolean c = checkCatalogue(resource);
        int i = 0;
        Iterator<Book> it = catalogue.iterator();
        while(c && it.hasNext()){
            Book b = it.next();
            if(b == resource){
                it.remove();
                i++;
            }
        }
        if(i<=0){
            System.out.println("No resources matched your search");
        }
    }

    /**
     * If an index exists, this method removes a resource by
     * its index position in the catalogue.
     *
     * @param i index to be removed.
     */
    public void removePosition(int i){
        if(indexCheck(i)){
            Book index = catalogue.get(i);
            Iterator<Book> it = catalogue.iterator();
            while(i<catalogue.size() && it.hasNext()){
                Book b = it.next();
                if(b == index) {
                    it.remove();
                    System.out.println("Index removed.");
                    i++;
                }
            }
        }
    }

    /**
     * Checks through catalogue for all available books and
     * provides a list of these.If all are available, the user is
     * also informed of this & the Total is provided.
     * If the book is an EBook sub-type,it informs the user of this
     * as well as how & where to access it.
     */
    public void allAvailableBooks(){
        int i = 0;
        for(Book book:catalogue){
            if(book instanceof PhysicalBook && ((PhysicalBook) book).bookAvailable()){
                System.out.println(book);
                i++;
            }
            else if(book instanceof EBook){
                System.out.println(book+"\n"+ "This is a digital resource."+"\n"
                +"It can be accessed at any of the Library devices. If you borrow an EBook," +
                        " you will be directed to an available device.");
                i++;
            }
        }
        if(i == catalogue.size()){
            System.out.println("All Books available");
        }
        System.out.println("Total: "+i);
    }

    /**
     * Produces a printed list of all PhysicalBook sub-type
     * books for the user.
     */
    public void allPhysicalBooks(){
        Iterator<Book> it = catalogue.iterator();
        while(it.hasNext()){
            Book p = it.next();
            if(p instanceof PhysicalBook){
                System.out.println(p);
            }
        }
    }

    /**
     * Produces a list of all EBook sub-type books
     * for the user.
     */
    public void allEResources(){
        Iterator<Book> it = catalogue.iterator();
        while(it.hasNext()){
            Book e = it.next();
            if(e instanceof EBook){
                System.out.println(e);
            }
        }
    }

    /**
     * Provides the number of books held in the catalogue.
     *
     * @return integer size of the catalogue.
     */
    public int numberOfResources(){
        int i = catalogue.size();
        return i;
    }

    /**
     * Method for a member borrowing a book. If the book doesnt
     * exist, provides an error message. If member and book both exist;
     * PhysicalBook sub-types are checked to see if they are available then
     * assigned to the member provided they have not reached their borrow limit
     * of 5, EBook sub-types assign an available device to access it and provide
     * the details of said device.
     *
     * @param book resource being borrowed
     * @param mem member borrowing
     */
    public void borrow(Book book, Member mem) {
        if(containsResource(book) == null){
            System.out.println("This resource does not exist");
        } else if(checkMember(mem)) {
            for (Member member : members) {
                if ((book instanceof PhysicalBook) && member.numberBorrowed() < 5 && member == mem &&
                        ((PhysicalBook) book).bookAvailable()) {
                    ((PhysicalBook) book).setUser(mem);
                    mem.borrowBook(book);
                } else if (member == mem && member.numberBorrowed() >= 5) {
                    System.out.println(member.getUserId() + " has taken the" +
                            "maximum amount of books allowed. Please" +
                            "return before taking out more.");
                }
                if (book instanceof EBook) {
                    ArrayList<Device> d = ((EBook) book).getDevices();
                    Iterator<Device> it = d.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        this.device = it.next();
                        if (device.isAvailable()) {
                            System.out.println("This is a digital resource. Please use " +
                                    "device number: " + device.getNumberId()
                                    + "\n" + "It is a: " + device.getType() + "\n" +
                                    "Which can be found in: " + device.getLocation());
                            device.setAvailDevice(false);
                            i++;
                            break;
                        }
                        if (i == d.size()) {
                            System.out.println("There are no free devices currently.");
                        } else {
                            System.out.println("This book is currently unavailable.");
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Error: This member does not exist");
        }
    }

    /**
     * This allows the returning of books if they exist in the catalogue,
     * as well as checking for damage and adding any to the book objects
     * damages to PhysicalBook sub-types. If an EBook sub-type is being
     * returned, a device is freed up again for use.
     *
     * @param book book being returned.
     * @param damage true = damage to record. false = no damage.
     * @param description String description of any damages.
     */
    public void returnBooks(Book book, boolean damage, String description){
        if(containsResource(book) == book){
            if(book instanceof PhysicalBook) {
                Member x = ((PhysicalBook) book).getUser();
                x.returnBook(book);
                ((PhysicalBook) book).setUser(null);

                if (damage) {
                    ((PhysicalBook) book).setDamages(description);
                }
            }
            else if(book instanceof EBook){
                ArrayList<Device> d = ((EBook)book).getDevices();
                Iterator<Device> it = d.iterator();
                while(it.hasNext()) {
                    this.device = it.next();
                    if(!(device.isAvailable())){
                        device.setAvailDevice(true);
                        break;
                    }
                }
            }
        }
        else{
            System.out.println("This book is not in the catalogue.");
        }
    }

    /**
     * Sends out a notification to all members who currently
     * have a book out on loan.
     *
     * @param message notification to be sent to all.
     */
    public void notifyAll(String message){
        for(Member mem:members){
            if(mem.numberBorrowed()>0){
                mem.setMessages(message);
                System.out.println(message + " added to Id:  " +
                        mem.getUserId());
            }
        }
    }
}

