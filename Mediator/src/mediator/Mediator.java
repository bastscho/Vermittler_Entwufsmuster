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

    ArrayList<Vehicle> carsNearby = new ArrayList<>();

    /**
     * The constructor of the Mediator class
     */
    public void Mediator()
    {
    }

    /**
     * Add a vehicle to the mediator object
     * @param v A Vehicle object
     */
    public void addClient(Vehicle v)
    {
        this.carsNearby.add(v);
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

    public static void main(String[] args)
    {
        Mediator me = new Mediator();

        Vehicle v1 = new Vehicle(me, "TESLAX_ZE-564-BM");
        Vehicle v2 = new Vehicle(me, "AUDIA8_IM-666-HS");
        Vehicle v3 = new Vehicle(me, "FORDFO_SL-123-NA");

        me.addClient(v1);
        me.addClient(v2);
        me.addClient(v3);

        Incident i = new Incident(47234541, 10744279, "Oil spilled on driveway.", v1);

        v1.send(i);
        System.out.println("Vehicle 1:");
        System.out.println(v2.getObstaclesString());
        System.out.println("Vehicle 2:");
        System.out.println(v3.getObstaclesString());
    }
}
