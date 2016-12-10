/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

import java.util.ArrayList;

/**
 * @date 09.12.2016
 * @author Jakob Tomasi
 */
public abstract class Mediator
{
    ArrayList<Vehicle> carsNearby;
    
    public void Mediator(Vehicle node)
    {
        this.addUser(node);
    }
    
    public void addUser(Vehicle u)
    {
        this.carsNearby.add(u);
    }
    
    public void sendMessage(Incident i, Vehicle sender)
    {
        for(Vehicle car : this.carsNearby)
        {
            if (car != sender)
            {
                car.receive(i);
            }
        }
    }
}
