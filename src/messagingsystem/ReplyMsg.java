/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagingsystem;
import java.util.Scanner;
import static messagingsystem.SignUpSignIn.users;

/**
 *
 * @author sushma
 */
public class ReplyMsg {
     static int accountIndex;
    
   void displayMenu()
    {
        int choice, numberOfMessages;
        String to,message;
        Scanner s = new Scanner(System.in);
         SignUpSignIn rs = new SignUpSignIn();
         
        while(true){
            
            System.out.println("Enter your choice\n");
            System.out.println("1:Reply mail");
            System.out.println("2:Read/Write mails");
            System.out.println("3:Logout");
                          choice=s.nextInt();
                          
                         
                          switch(choice)
                          {
                              case 1:System.out.println("TO: ");
                                     to=s.next();
                                     System.out.println("Message: ");
                                     message=s.next();
                                     numberOfMessages=this.replyMail(to,message);
                                     break;
                                     
                              case 2:rs.displayMenu();
                                     break;
                                     
                              case 3:return;
                                                                          
                              default : System.out.println("Invalid Choice!\n");
                          }
                        }
    }
   
   
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
