package messagingsystem;
import java.util.ArrayList;

/**
 * The class maintains a simple record about a user's account information such as name, username and password
 * We have made use of array list for keeping a record of multiple number of users.
 * 
 */

public class Account {
    
    String name,userName,password;
    ArrayList<Message> messages = new ArrayList();
    
}

/**
 * The class below is used for message: to read the message to be send and the username of the sender.
 * Initially we have created a constructor and assigned message as 'null' and maintained a readUnreadBit and 
 * repliedUnrepliedBit to keep a track of messages which are read, unread, replied and unreplied and initially it is 
 * initialized as 0. 
 * @author Inspi
 */


class Message
{
    String message,sender,receiver;
    int readUnreadBit, repliedUnrepliedBit;
    
    Message(){
        this.message=null;
        this.readUnreadBit=0;                //set as unread(0)
        this.repliedUnrepliedBit=0;         //set as unreplied(0)
    }
}
