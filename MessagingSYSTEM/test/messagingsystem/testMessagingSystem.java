
package messagingsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test methods of MessagingSystem class.
 * @author Shifa
 */
public class testMessagingSystem {
    SignUpSignIn s;
    Operations o;
    public testMessagingSystem() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        s = new SignUpSignIn();
        o = new Operations();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSignUp() {
    
        assertEquals("0Shifa",s.signUp("Shifa","shifa123"));
        
    }
    
    @Test
    public void testSignIn() {
    
        assertEquals(true,s.signIn("0Shifa","shifa123"));
        
    }
    
    @Test
    public void testReadMails() {
    
        assertEquals(0,o.readMails());
        
    }
    
    @Test
    public void testWriteMail() {
    
        assertEquals(0,o.writeMail());
        
    }
    
}
