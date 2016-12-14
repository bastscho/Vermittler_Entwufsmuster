package mediator;

import java.util.ArrayList;

/**
 * A mediator, responsible for receiving a message from one node (Vehicle) and
 * forwarding it to all other nodes (Vehicles9
 *
 * @author Jakob Tomasi
 */
public class ConcreteMediator implements Mediator<Incident>
{
    ArrayList<Vehicle> carsNearby;

    /**
     * Constructor of the Mediator class
     */
    public ConcreteMediator()
    {
        this.carsNearby = new ArrayList<>();
    }

    /**
     * Add a vehicle to the mediator object
     * @param v A Vehicle object
     */
    @Override
    public void addColleague(Colleague v)
    {
        this.carsNearby.add((Vehicle)v);
    }
    
    /**
     * Removes a vehicle from the mediator
     * @param v The vehicle to be removed
     */
    @Override
    public void removeColleague(Colleague v)
    {
        this.carsNearby.remove((Vehicle)v);
    }

    /**
     * The mediator receives a message (Incident) from one vehicle and forwards it to all vehicles except the origin
     * @param i The Incident object which is to be sent
     * @param sender The origin Vehicle which detected the obstacle (Incident)
     */
    @Override
    public void sendMessage(Incident i, Colleague sender)
    {
        for (Vehicle car : this.carsNearby)
        {
            if (car != (Vehicle)sender)
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
    
    /**
     * ConcreteMediator main method, utilizing all classes of the package to give an example usage case
     * @param args Main method arguments
     */
    public static void main(String[] args)
    {
        ConcreteMediator me = new ConcreteMediator();

        Vehicle v1 = new Vehicle(me, "TESLAX_ZE-564-BM");
        Vehicle v2 = new Vehicle(me, "AUDIA8_IM-666-HS");
        Vehicle v3 = new Vehicle(me, "FORDFO_SL-123-NA");

        me.addColleague(v1);
        me.addColleague(v2);
        me.addColleague(v3);

        Incident i = new Incident(47234541, 10744279, "Oil spilled on driveway.", v1);

        v1.send(i);
        System.out.println("Vehicle 1:");
        System.out.println(v2.getObstaclesString());
        System.out.println("Vehicle 2:");
        System.out.println(v3.getObstaclesString());
    }
}