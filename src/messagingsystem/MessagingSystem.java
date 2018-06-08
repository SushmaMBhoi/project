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
        boolean validationForLogin;
        SignUpSignIn ss = new SignUpSignIn();
        int choice=0;
        
        Scanner s=new Scanner(System.in);
            while(true){
            System.out.println("Please enter your choice\n");
            System.out.println("1:Sign Up");
            System.out.println("2:Sign In");
            System.out.println("3:Exit");
            choice=s.nextInt();
            

            switch(choice){
                
                case 1:System.out.println("Enter your Name");
                       name = s.next();
                       System.out.println("Form a PASSWORD for your account that should start with a LETTER.");
                       password = s.next();
                       userName = ss.signUp(name, password);
                       System.out.println("Your user name is:" + userName + "\n");
                       break;
                       
                case 2:System.out.println("Enter User Name");
                       name = s.next();
                       System.out.println("Enter Password");
                       password = s.next();
                       validationForLogin = ss.signIn(name, password);
                       if(validationForLogin==false)
                           System.out.println("Invald user name or password!");
                       else
                           ss.displayMenu();
                       break;
                       
                case 3:System.exit(0);
                       
               default:System.out.println("You entered an invalid choice\n");
            }
            }
    }
    
}
