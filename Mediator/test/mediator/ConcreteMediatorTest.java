package mediator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for ConcreteMediator
 * @author Jakob
 */
public class ConcreteMediatorTest
{
    /**
     * Test of addClient method, of class ConcreteMediator.
     */
    @Test
    public void testAddClient()
    {
        System.out.println("addClient");
        ConcreteMediator instance = new ConcreteMediator();
        Vehicle v = new Vehicle(instance, "");
        
        instance.addColleague(v);
        assertEquals(instance.getVehicleCount(), 1);
    }

    /**
     * Test of sendMessage method, of class ConcreteMediator.
     */
    @Test
    public void testSendMessage()
    {
        System.out.println("sendMessage");
        ConcreteMediator instance = new ConcreteMediator();
        Vehicle sender = new Vehicle(instance, "s");
        Vehicle receiver = new Vehicle(instance, "r");
        Incident i = new Incident(47234541, 10744279, "Detected spilled oil on driveway", sender);
        instance.addColleague(sender);
        instance.addColleague(receiver);
        
        instance.sendMessage(i, sender);
        assertEquals(receiver.getObstaclesCount(), 1);
    }    
}