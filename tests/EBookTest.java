import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * Tests the functionality of the methods held within the EBook
 * class, their interactions with their SuperClass and how well
 * they all work.
 * Test classes have been commented if tested elsewhere by other functions.
 */
class EBookTest extends BookTest {

    private EBook e1 = new EBook("ishfb76","Maxim","anyah", 2020);
    private Device d1 = new Device("Computer","lab 1", true,1);

    @Test
    void getUploadYear() {
        //Tested by setUploadYear.
    }

    /**
     * Set upload year.
     * Tests set & get uploadYear.
     */
    @Test
    void setUploadYear() {
        assert e1.getUploadYear() == 2020;
        e1.setUploadYear(2024);
        assert e1.getUploadYear() == 2024;
    }

    @Test
    void getDevices() {
        //Tested by addDevice.
    }

    @Test
    void testDetails() {
        //Tested by addDevice.
    }

    /**
     * Adding device, list starts from 0 as no entries yet.
     * tests getDevices method.
     * Tests details also. As details() draws from the superclass,
     * there is no need to test any details methods farther.
     */
    @Test
    void addDevice() {
        System.out.println(e1.getDevices().size());
        e1.addDevice(d1);
        e1.details();
        System.out.println(e1.getDevices().size());
        assert e1.getDevices().size() >0;
    }
}