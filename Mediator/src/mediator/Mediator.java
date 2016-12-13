package mediator;

import java.util.ArrayList;

/**
 * A mediator, responsible for receiving a message from one node (Vehicle) and
 * forwarding it to all other nodes (Vehicles9
 *
 * @author Jakob Tomasi
 */
public class Mediator
{

    ArrayList<Vehicle> carsNearby;

    /**
     * Constructor of the Mediator class
     */
    public Mediator()
    {
        this.carsNearby = new ArrayList<>();
    }

    /**
     * Add a vehicle to the mediator object
     * @param v A Vehicle object
     */
    public void addColleague(Vehicle v)
    {
        this.carsNearby.add(v);
    }
    
    /**
     * Removes a vehicle from the mediator
     * @param v The vehicle to be removed
     */
    public void removeColleague(Vehicle v)
    {
        this.carsNearby.remove(v);
    }

    /**
     * The mediator receives a message (Incident) from one vehicle and forwards it to all vehicles except the origin
     * @param i The Incident object which is to be sent
     * @param sender The origin Vehicle which detected the obstacle (Incident)
     */
    public void sendMessage(Incident i, Vehicle sender)
    {
        for (Vehicle car : this.carsNearby)
        {
            if (car != sender)
            {
                car.receive(i);
            }
        }
    }
    
    /**
     * Returns the amount of colleagues the mediator has knowledge of
     * @return The amount of vehicles
     */
    public int getVehicleCount()
    {
        return this.carsNearby.size();
    }
}