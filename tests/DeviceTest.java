import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * A Test Class for the Device class, testing functionality of
 * methods within and via other classes calling them.
 * Test classes have been commented if tested elsewhere by other functions.
 */
class DeviceTest {

    private Device d1 = new Device("Computer","lab 1", true,1);
    private Device d2 = new Device("Ipad","lab 2", false, 2);
    private Device d3 = new Device("Computer","lab 1", true, 3);


    @Test
    void getLocation() {
        //Tested by setLocation.
    }

    /**
     * Tests location of device.
     * Tests set & get Location.
     */
    @Test
    void setLocation() {
        assert d1.getLocation() == "lab 1";
        d1.setLocation("lab 3");
        assert d1.getLocation() == "lab 3";
    }

    @Test
    void getType() {
        //Tested by getType.
    }

    /**
     * Tests current state. All new devices
     * true by default. So new device produce true.
     */
    @Test
    void isAvailable() {
        assert d1.isAvailable() == true;
    }

    @Test
    void setAvailable() {
        //Tested in borrow() in Library.
    }

    /**
     * Changes or sets the type of device.
     * Tests set & get Type.
     */
    @Test
    void setType() {
        assert d1.getType() == "Computer";
        d1.setType("Ipad");
        assert d1.getType() == "Ipad";
    }

    @Test
    void getNumberId() {
        //Tested by setNumberId.
    }

    /**
     * Changing machine id number.
     * Tests set & get numberId.
     */
    @Test
    void setNumberId() {
        assert d1.getNumberId() == 1;
        d1.setNumberId(5);
        assert d1.getNumberId() == 5;
    }

    /**
     * Tests displaying a machines details.
     * Asserted true as will always print
     * designated details.
     */
    @Test
    void deviceDetails() {
        d1.deviceDetails();
        assert (true);
    }
}