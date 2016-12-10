/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

/**
 * @date 09.12.2016
 * @author Jakob Tomasi
 */
public interface Colleague
{    
    /**
     * 
     * @param i 
     */
    public abstract void send(Incident i);
    public abstract void receive(Incident i);
}
