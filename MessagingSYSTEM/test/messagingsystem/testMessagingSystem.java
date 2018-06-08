
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
    SignUpSignIn s,s1;
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
        s1 = new SignUpSignIn();
        
    }
        
    @After
    public void tearDown() {
    }

    @Test
    public void testSignUp() {
    
        
        assertEquals("2Sara",s.signUp("Sara", "sara123"));
    }
    
    @Test
    public void testSignIn() {
        
        assertEquals(true,s1.signIn("0Shifa","shifa123"));
        
    }
    
    @Test
    public void testReadMails() {
        assertEquals(true,s1.signIn("0Shifa","shifa123"));
        assertEquals(0,s1.readMails());
        
    }
    
    @Test
    public void testWriteMail() {
        assertEquals("0Shifa",s1.signUp("Shifa","shifa123"));
        assertEquals("1Sana",s.signUp("Sana","sana123"));
        assertEquals(true,s1.signIn("0Shifa","shifa123"));
        assertEquals(1,s1.writeMail("1Sana","Hello"));
        
    }
    
}
