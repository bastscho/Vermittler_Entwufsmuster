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
public interface Mediator<T>
{
    public void addColleague(Colleague c);
    public void removeColleague(Colleague c);
    public void sendMessage(T m, Colleague c);
}
