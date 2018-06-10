package messagingsystem;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *The class below is used to carry out signUp and signIn operations respectively.
 * @author Shifa
 */
public class SignUpSignIn {
    
    static ArrayList<Account> users = new ArrayList();
    static long count=0;
    static int accountIndex;
    ArrayList<Message> messages = new ArrayList();
    Scanner s=new Scanner(System.in);
    ReplyMsg rp=new ReplyMsg();
    String sender;
    
     /**
     * The method below accepts the name and password of a user given by the user and stores them into an object 'a'
     * of class 'Account'. Later a variable count is maintained to keep a track of number of users and hence it is 
     * incremented, after creating a username for the user by concatenating the count with the name of user and returning th same.
     * 
     * 
     * @param name  Name of account holder 
     * @param password  Password for an account to be created
     * @return User name for newly created account
     */
    String signUp(String name,String password)
    {
        Account a = new Account();
        a.name = name;
        a.password = password;
        a.userName = count + name;
        count++;
        users.add(a);
        return a.userName;
    }
    
    
     /**
     * The method below allows the already existing user to login the account only after checking for the presence of user in the array list 
     * using a temporary variable flag. Once the user is found in the array list of multiple number of users the index where he/she is found
     * is maintained and kept in the variable arrayIndex. If flag is 1(i.e. the user is existing) a welcome message is displayed followed by the username
     * @param userName User name of an account
     * @param password  Password of an account
     * @return True if account is valid,false otherwise
     */
    boolean signIn(String userName,String password)
    {
        int flag=0,choice=0;
        
        for(int i=0; i<count; i++){   
            if(users.get(i).userName.compareTo(userName)==0 && users.get(i).password.compareTo(password)==0){                
                flag=1;
                accountIndex=i;
                break;
            }
        }    
        if(flag==1){                                                      //Valid account
            System.out.println("Welcome\t" + users.get(accountIndex).name);
            //op.displayMenu(users, accountIndex);
            return true;
        }
        else
            return false;
        
    }
    
    /**
     * Once the user is evaluated to be existing into the records a menu is displayed to carry out operations of 
     * read message, write message or logout respectively.
     */
     void displayMenu()
    {
        int choice, numberOfMessages;
        String to,message;
        while(true){
            
            System.out.println("Enter your choice\n");
            System.out.println("1:Read mails");
            System.out.println("2:Write mails");
            System.out.println("3:LogOut");
            
            choice=s.nextInt();
            
            switch(choice)
            {
                case 1:numberOfMessages=this.readMails();
                                      
                       break;
                       
                case 2:System.out.println("TO:");
                       to=s.next();
                       System.out.println("Message :");
                       message=s.next();
                       numberOfMessages=this.writeMail(to,message);
                       break;
                case 3:return;
               default:System.out.println("You entered an invalid choice\n");
            }
        }
        
        
    }
    
      /**
       * Method to read message.
       * @return Number of mails in inbox
       */    
    int readMails(){
        int choice=1;
        messages = users.get(accountIndex).messages;
        if(messages.size()==0)
            System.out.println("No mails to read\n");
        else
        {
            System.out.println("Select the mail you want to read");
            for(int i=0; i<messages.size(); i++)
            {
                System.out.println(i+1 + ".\t" + messages.get(i).sender);
                if(messages.get(i).readUnreadBit==0)
                      System.out.println("(Unread Message)\n");
                else
                      System.out.println("(Read Message)\n");
            }
            choice = s.nextInt();
            System.out.println("From:" + messages.get(choice-1).sender + "");
            System.out.println("Message:");
            System.out.println(messages.get(choice-1).message);
            users.get(accountIndex).messages.get(choice-1).readUnreadBit=1;
            
            sender = messages.get(choice-1).sender;
            rp.displayMenuReply(sender);  
            return messages.size();
        }
        return 0;
    }
    
    
    /**
     * Method to write message after reading in the receiver id and the message to be sent to the receiver.
     * @param to  Receiver of the mail
     * @param message  Message to be sent
     * @return Number of mails in the receiver's inbox
     */
    int writeMail(String to,String message){
        
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
