package messagingsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Shifa
 */
public class Operations {
    
    static ArrayList<Account> user;
    ArrayList<Message> messages = new ArrayList();
    int  accountIndex;
    Scanner s = new Scanner(System.in);
    
    void displayMenu(ArrayList<Account> users,int accountIndex)
    {
        this.user=users;
        this.accountIndex=accountIndex;
        int choice, numberOfMessages;
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
                case 2:numberOfMessages=this.writeMail();
                       break;
                case 3:return;
               default:System.out.println("You entered an invalid choice\n");
            }
        }
        
        
    }
    
    int readMails(){
        int choice;
        System.out.println("Select the mail you want to read");
        messages = user.get(accountIndex).messages;
        if(messages.size()==0)
            System.out.println("No mails to read\n");
        else
        {
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
            System.out.println("Message:\n");
            System.out.println(messages.get(choice-1).message);     
            return messages.size();
        }
        return 0;
    }
    
    int writeMail(){
        String to,message;
        System.out.println("TO:");
        to=s.next();
        System.out.println("Message");
        message=s.next();
        int i;
        for( i=0; i<user.size(); i++)
        {
            if(user.get(i).userName.compareTo(to) == 0)
            {
                Message m=new Message();
                m.message=message;
                m.sender=user.get(accountIndex).userName;
                
                user.get(i).messages.add(m);
                System.out.println("Message sent!\n");
                break;
            }
        }
        int numberOfMessages=user.get(i).messages.size();
 
        return numberOfMessages;
    }
}
