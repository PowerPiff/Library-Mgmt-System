public class Main {

    public static void main(String[] args) {

        Library lib = new Library(30, "San Dennis Community Library");
        Book b1 = new PhysicalBook("I7789hgn", "Michael", "Book1");
        Book e1 = new EBook("ishfb76","Maxim","anyah", 2020);
        Book b3 = new PhysicalBook("I779hgn", "Micael", "Bok1");
        Book b2 = new PhysicalBook("I7789hgn", "Michael", "Book2");

        Device d1 = new Device("Computer","lab 1", true,1);
        Device d2 = new Device("Ipad","lab 2", false, 2);
        Device d3 = new Device("Computer","lab 1", true, 3);

        Member m1 = new Member("yo","Scott Smith", "Glasgow");
        Member m2 = new Member("hey", "Hamlin Poppy", "Edinburgh");


        System.out.println(e1.getAuthor());


        m1.makeUserId();
        m2.getUserId();
        m2.makeUserId();
        m1.setMessages("extra");
        m1.setMessages("wide");
        m1.memberDetails();
        m2.memberDetails();
        m1.memberMessages();
        ((EBook)e1).addDevice(d1);
        ((EBook)e1).addDevice(d2);
        ((EBook)e1).addDevice(d3);

        lib.addResource(b1);
        lib.addResource(e1);
        lib.addResource(b2);
        lib.addResource(b3);

        lib.addMember(m1);
        lib.addMember(m2);

        lib.borrow(e1,m1);
        //lib.editTitle(e1, "hujh");
        //lib.checkCatalogue(b1);
        //lib.searchByIsbn("ishfb76");
        //lib.searchByAuthor("Michael");
        //lib.getSize();
        //lib.removeResource(b3);
        //lib.getSize();
        //lib.removePosition(6);
        //lib.getSize();

        lib.borrow(b1,m1);
        lib.allAvailableBooks();
        lib.returnBooks(e1,false,"");
        System.out.println(d1.isAvailable());


        //m1.borrow(b1);
        //m1.borrow(b2);// if change to m2, both print 1 each
        //System.out.println(((PhysicalBook) b1).bookAvailable());
        //m1.listBorrowed();
        //m2.listBorrowed();
        //System.out.println(m1.numberBorrowed());

        //((PhysicalBook) b1).details();

        //e1.details();

        //System.out.println((Lib.numberOfResources()));
       // lib.allAvailableBooks();
        //lib.returnBook(b1,true,"Left corner");
        //System.out.println(((PhysicalBook)b1).getDamages());

        //lib.allPhysicalBooks();
        //lib.allEResources();


    }
}
