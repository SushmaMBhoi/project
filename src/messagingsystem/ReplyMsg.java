package messagingsystem;
import java.util.Scanner;
import static messagingsystem.SignUpSignIn.users;

/**
 * The class below will only get executed only if the user is already existing into the records and the validationForLogin 
 * turns out to be true. 
 * The accountIndex is used to obtain the index where we have find the user in the array list of all the users. 
 * The displayMenuReply method displays the menu for the user to reply to a message, read/write to a message or logout of a system. 
 */
public class ReplyMsg {
     static int accountIndex;
    
     /**
     *@param Reciever
     */
     
   void displayMenuReply(String sender)
    {
        int choice, numberOfMessages;
        String to,message;
        Scanner s = new Scanner(System.in);
         SignUpSignIn rs = new SignUpSignIn();
          to= sender;
         
        while(true){
            
            System.out.println("Enter your choice\n");
            System.out.println("1:Reply mail");
            System.out.println("2:Read/Write mails");
            System.out.println("3:Logout");
            
            choice=s.nextInt();
                          
                          switch(choice)
                          {
                              case 1:System.out.println("TO: "+ sender);
                                     //to=
                                     System.out.println("Message: ");
                                     message=s.next();
                                     numberOfMessages=this.replyMail(to,message);
                                     break;
                                     
                              case 2:rs.displayMenu();
                                     return;
                                     
                              case 3:return;
                                                                          
                              default : System.out.println("Invalid Choice!\n");
                          }
                        }
    }
     
     
  /**
  * The method below will add the message into the receiver's unread messages after comparing for the presence of the receiver into the 
  * the arraylist records only and returns the number of messages.
  * @param to Reciever user name
  * @param message Message to be sent
  * @return Number of mails in reciever's inbox
  */ 
     int replyMail(String to,String message)
    {
        int i;
        for( i=0; i<users.size(); i++)
        {
            if(users.get(i).userName.compareTo(to) == 0)
            {
                Message m=new Message();
                m.message=message;
                m.sender=users.get(accountIndex).userName;
                
                users.get(i).messages.add(m);
                System.out.println("Message sent!\n");
                break;
            }
        }
        int numberOfMessages=users.get(i).messages.size();
 
        return numberOfMessages;
    }
    

}

