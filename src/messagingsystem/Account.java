package messagingsystem;
import java.util.ArrayList;

public class Account {
    
    String name,userName,password;
    ArrayList<Message> messages = new ArrayList();
    
}

class Message
{
    String message,sender;
    int readUnreadBit, repliedUnrepliedBit;
    
    Message(){
        this.message=null;
        this.readUnreadBit=0;                //set as unread(0)
        this.repliedUnrepliedBit=0;         //set as unreplied(0)
    }
}
