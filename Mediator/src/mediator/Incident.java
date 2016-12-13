package mediator;

/**
 * A representation of an obstacle in a specific geographic location
 * @author Jakob Tomasi
 */
public class Incident
{
    private final int latitude;
    private final int longitude;
    private String customerInfo;
    private final Vehicle origin;

    /**
     * The constructor of the Incident class
     * @param latitude The geographic north-south location of the incident
     * @param longitude The geographic east-west location of the incident
     * @param info A string containing human-readable information about an Incident (Obstacle)
     * @param origin The vehicle which detected the Incident
     */
    public Incident(int latitude, int longitude, String info, Vehicle origin)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.customerInfo = info;
        this.origin = origin;
    }
    
    /**
     * A setter for the human-readable info text
     * @param info A string of letters containing information about the obstacle
     */
    public void setCustomerInfo(String info)
    {
        this.customerInfo = info;
    }
    
    /**
     * Returns a formatted String containing all data fields of the Incident class
     * @return String containing data fields
     */
    @Override
    public String toString()
    {
        String out = "Location:\n\tLAT: " + this.latitude + "\n\tLON: " + this.longitude + "\nInformation source: " + this.origin.toString() + "\nInfo: " + this.customerInfo;
        return out;
    }
    
    /**
     * Returns the latitude of the Incident
     * @return latitude
     */
    public int getLatitude()
    {
        return this.latitude;
    }
    
    /**
     * Returns the longitude of the incident
     * @return longitude
     */
    public int getLongitude()
    {
        return this.longitude;
    }
    
    /**
     * Returns the info text of the Incident
     * @return String of letters, containing incident information
     */
    public String getCustomerInfo()
    {
        return this.customerInfo;
    }
    
    /**
     * Returns a reference to the vehicle the incident originated from
     * @return Vehicle which detected the incident
     */
    public Vehicle getOrigin()
    {
        return this.origin;
    }
}