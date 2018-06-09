
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
    ReplyMsg rs;
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
        rs = new ReplyMsg();
    }
        
    @After
    public void tearDown() {
    }
    
    /**
    * A method to test SignUp function of MessagingSystem class
    */
    @Test
    public void testSignUp() {
    
        
        assertEquals("2Sara",s.signUp("Sara", "sara123"));
    }
    
    /**
    *A method to test SignIn functionality of MessagingSystem class
    */
    @Test
    public void testSignIn() {
        
        assertEquals(true,s1.signIn("0Shifa","shifa123"));
        
    }
    
    /**
    * A method to test Read mails functionality of MessagingSystem class
    */
    @Test
    public void testReadMails() {
        assertEquals(true,s1.signIn("0Shifa","shifa123"));
        assertEquals(0,s1.readMails());
        
    }
    
    /**
    *A method to test Write mail functionality of MessagingSystem class
    */
    @Test
    public void testWriteMail() {
        assertEquals("0Shifa",s1.signUp("Shifa","shifa123"));
        assertEquals("1Sana",s.signUp("Sana","sana123"));
        assertEquals(true,s1.signIn("0Shifa","shifa123"));
        assertEquals(1,s1.writeMail("1Sana","Hello"));
        
    }
    
    /**
    *A method to test Reply mail Functinality of MessagingSystem class
    */
    @Test
    public void testReplyMail() {
        assertEquals(1, rs.replyMail("1Sana", "Hii"));
        assertEquals(1,s1.writeMail("1Sana", "Hi gm"));
    }
    
}
