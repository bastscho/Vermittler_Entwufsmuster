/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

/**
 *
 * @author Jakob Tomasi
 */
public class Incident
{

    private final int latitude;
    private final int longitude;
    private String customerInfo;
    private final Vehicle origin;

    public Incident(int latitude, int longitude, String info, Vehicle origin)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.customerInfo = info;
        this.origin = origin;
    }
    
    public void setCustomerInfo(String info)
    {
        this.customerInfo = info;
    }
    
    @Override
    public String toString()
    {
        String out = "Location:\n\tLAT: " + this.latitude + "\n\tLON: " + this.longitude + "\nInformation source: " + this.origin.toString() + "\nInfo: " + this.customerInfo;
        return out;
    }
    
    public int getLatitude()
    {
        return this.latitude;
    }
    
    public int getLongitude()
    {
        return this.longitude;
    }
    
    public String getCustomerInfo()
    {
        return this.customerInfo;
    }
    
    public Vehicle getOrigin()
    {
        return this.origin;
    }
}
