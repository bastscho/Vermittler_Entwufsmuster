package mediator;

import java.util.ArrayList;

/**
 * A small simulation of a vehicle. Main features are sending and receiving
 * warnings about incidents in specific geographic locations
 *
 * @author Jakob Tomasi
 */
public class Vehicle implements Colleague<Incident>
{

    private ArrayList<Incident> obstacles;
    private final Mediator mediator;
    private final String name;

    /**
     * The constructor of the vehicle class
     *
     * @param med The mediator object which is used for communication between
     * vehicles
     * @param name The designation of the vehicle
     */
    public Vehicle(Mediator med, String name)
    {
        this.mediator = med;
        this.name = name;
        this.obstacles = new ArrayList<>();
    }

    /**
     * Sends an object of the type Incident to the mediator
     *
     * @param i The Incident object to be sent
     */
    @Override
    public void send(Incident i)
    {
        if (!this.obstacles.contains(i))
        {
            this.obstacles.add(i);
        }
        this.mediator.sendMessage(i, this);

        //System.out.println("Found an obstacle. Informing nearby cars.\n" + i.toString());
    }

    /**
     * Receives an object of the type Incident from the mediator
     *
     * @param i The Incident object to be received
     */
    @Override
    public void receive(Incident i)
    {
        this.obstacles.add(i);
    }

    /**
     * A helper method to get a formatted String with all received and detected
     * Incidents
     *
     * @return A String containing information about all collected Incidents
     */
    public String getObstaclesString()
    {
        String obstaclesString = "";
        int counter = 1;

        for (Incident i : this.obstacles)
        {
            obstaclesString += "Obstacle #" + counter + "\n" + i.toString();
        }
        return obstaclesString;
    }

    /**
     * A helper method to get a formatted String containing information about
     * the vehicle
     *
     * @return A String containing vehicle information
     */
    @Override
    public String toString()
    {
        String vehicleString = "vName: " + this.name + ", vObstacles: " + this.obstacles.size();
        return vehicleString;
    }
}
