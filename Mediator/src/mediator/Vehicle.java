/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

import java.util.ArrayList;

/**
 *
 * @author Jakob Tomasi
 */
public class Vehicle implements Colleague
{
    private ArrayList<Incident> obstacles;
    private final Mediator mediator;
    private final String name;
    
    public Vehicle(Mediator med, String name)
    {
        this.mediator = med;
        this.name = name;
        this.obstacles = new ArrayList<>();
    }

    @Override
    public void send(Incident i)
    {
        this.mediator.sendMessage(i, this);

        System.out.println("Found an obstacle. Informing nearby cars.\n" + i.toString());
    }

    @Override
    public void receive(Incident i)
    {
        this.obstacles.add(i);
        System.out.println("Obstacle warning received. Calculating alternative route...\n" + i.toString());
    }
    
    public String getObstaclesString()
    {
        String obstaclesString = "";
        int counter = 1;
        
        for(Incident i : this.obstacles)
        {
            obstaclesString += "#" + counter + "\n" + i.toString();
        }
        
        return obstaclesString;
    }

}
