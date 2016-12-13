package mediator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Mediator
 * @author Jakob
 */
public class MediatorTest
{
    /**
     * Test of the Constructor, of class Mediator
     */
    @Test
    public void testConstructor()
    {
        System.out.println("Constructur");
        Mediator instance = new Mediator();
        assertEquals(instance.getClass(), Mediator.class);
    }

    /**
     * Test of addClient method, of class Mediator.
     */
    @Test
    public void testAddClient()
    {
        System.out.println("addClient");
        Mediator instance = new Mediator();
        Vehicle v = new Vehicle(instance, "");
        
        instance.addColleague(v);
        assertEquals(instance.getVehicleCount(), 1);
    }

    /**
     * Test of sendMessage method, of class Mediator.
     */
    @Test
    public void testSendMessage()
    {
        System.out.println("sendMessage");
        Mediator instance = new Mediator();
        Vehicle sender = new Vehicle(instance, "s");
        Vehicle receiver = new Vehicle(instance, "r");
        Incident i = new Incident(47234541, 10744279, "Detected spilled oil on driveway", sender);
        instance.addColleague(sender);
        instance.addColleague(receiver);
        
        instance.sendMessage(i, sender);
        assertEquals(receiver.getObstaclesCount(), 1);
    }    
}
