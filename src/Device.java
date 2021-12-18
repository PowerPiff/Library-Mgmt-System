import java.util.ArrayList;

/**
 * This class represents a device that can be found and accessed
 * at the library to get access to EBooks. It has individual fields
 * as well as its availability; wether or not it is being used by
 * a member currently.
 */
public class Device {

    private String location;
    private boolean available;
    private String type;
    private int numberId;

    /**
     * Constructor to generate a device. All devices are, by
     * default, available until used to access resources.
     *
     * @param type "Computer" "Ipad" - What type.
     * @param location "Lab 1" "back corner" - Where located.
     * @param available true by default.
     * @param number 1, 2 etc - Id number.
     */
    public Device(String type, String location, boolean available, int number) {
        this.type = type;
        this.location = location;
        this.available = true;
        this.numberId=number;

    }

    /**
     * Constructor empty for use elsewhere.
     */
    public Device(){}

    /**
     * Provides current location of device within the library.
     *
     * @return location of device.
     */
    public String getLocation() {
        return location;
    }

    /**
     * If device moves, changes location to new one.
     *
     * @param location new Location.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Provides the type of device e.g Computer or Ipad.
     *
     * @return type
     */
    public String getType(){
        return type;
    }

    /**
     * Shows wether a device is currently available or not.
     *
     * @return true = available. false = not available/
     */
    public boolean isAvailable() {
        if(available){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Changes the availability of the device when it is
     * in use by a member.
     *
     * @param avail true = in use. false = not in use.
     */
    public void setAvailDevice(boolean avail){
        this.available=avail;
    }

    /**
     * Changes type of device in instance device is upgraded
     * or incorrectly input.
     *
     * @param type new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Provides the numberId of a device currently.
     *
     * @return current device number.
     */
    public int getNumberId() {
        return numberId;
    }

    /**
     * Allows changing of device numberId in event
     * relocated or required to be updated.
     *
     * @param numberId new numberId.
     */
    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    /**
     * Provides a printed out list of all the details of
     * a device and wether or not it is available currently.
     */
    public void deviceDetails(){
        System.out.println("Type: "+type+"\n"+
                "Id: "+numberId+"\n"+"Location: "
                +location);
        if(isAvailable()){
            System.out.println("Availability: Available.");
        }
        else{
            System.out.println("Availability: Not available.");
        };
    }
}
