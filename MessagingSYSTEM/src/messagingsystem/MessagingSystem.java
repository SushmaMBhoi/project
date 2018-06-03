package messagingsystem;
import java.util.Scanner;

/**
 *
 * @author Shifa
 */
public class MessagingSystem {

    /**Main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String name, password,userName;
        boolean valdationForLogin;
        SignUpSignIn ss = new SignUpSignIn();
        int choice;
        
        Scanner s=new Scanner(System.in);
        
            System.out.println("Please enter your choice\n");
            System.out.println("1:Sign In\n");
            System.out.println("2:Sign Up\n");
            choice=s.nextInt();
            
            switch(choice){
                
                case 1:System.out.println("Enter your Name\n");
                       name = s.next();
                       System.out.println("Form a PASSWORD for your account that should start with a LETTER.\n");
                       password = s.next();
                       userName = ss.signUp(name, password);
                       System.out.println("Your user name is:" + userName + "\n");
                       break;
                       
                case 2:System.out.println("Enter User Name\n");
                       name = s.next();
                       System.out.println("Enter Password\n");
                       password = s.next();
                       valdationForLogin = ss.signIn(name, password);
                       if(valdationForLogin==false)
                           System.out.println("Invald user name or password!");
                       break;
                       
               default:System.out.println("You entered an invalid choice\n");
            }
    }
    
}
