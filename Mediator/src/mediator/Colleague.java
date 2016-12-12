/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

/**
 * The interface Colleague, defining the necessity of a send and receive method.
 *
 * @param <T> The type of parameter which ought to be used in the
 * implementation.
 * @author Jakob Tomasi
 */
public interface Colleague<T>
{

    /**
     * Demands a method to send an object of the type T to a mediator.
     *
     * @param i The object which is sent to the mediator
     */
    public abstract void send(T i);

    /**
     * Demands a method to receive an object of the type T from a mediator.
     *
     * @param i The object which is received from the mediator
     */
    public abstract void receive(T i);
}
