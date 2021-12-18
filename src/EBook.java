import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that inherits, extra values over Book. Provides
 * functionality to devices through the list, allowing members
 * to use EBooks and take devices to do it.
 */
public class EBook extends Book {
    private ArrayList<Device> devices;
    private int uploadYear;

    /**
     * Constructor for EBook uses Super class for main values, then
     * adds own values and creates devices list.
     *
     * @param ISBN ISBN of EBook.
     * @param author Author of EBook.
     * @param title Title of EBook.
     * @param uploadYear Current year.
     */
    public EBook(String ISBN, String author, String title, int uploadYear){
        super(ISBN, author, title);
        devices = new ArrayList<>();
        this.uploadYear = uploadYear;
    }

    /**
     * Provides the upload year of an EBook resource.
     *
     * @return year uploaded.
     */
    public int getUploadYear() {
        return uploadYear;
    }

    /**
     * Changes the year of upload in case of error.
     *
     * @param uploadYear new year of upload.
     */
    public void setUploadYear(int uploadYear) {
        this.uploadYear = uploadYear;
    }

    /**
     * Provides access to list of all devices in the
     * library.
     *
     * @return list of devices
     */
    public ArrayList<Device> getDevices() {
        return devices;
    }

    /**
     * Overrides from Super class to add in extra details
     * specific to EBook, then prints them all.
     */
    @Override
    public void details() {
        super.details();
        System.out.println("Uploaded: "+uploadYear);
    }

    /**
     * Adds a device to the list of devices.
     *
     * @param device device to be added.
     */
    public void addDevice(Device device){
            devices.add(device);
    }

    @Override
    public String toString(){
        return super.toString()+"\n"+ "Uploaded: "+uploadYear;
    }
}


