/**
 *This is the simulation of a messaging system with provision of operations like reading and writing messages.
 * 
 */


package messagingsystem;
import java.util.Scanner;

/**
 * The class below displays the menu for the user asking the user for the options like sign up if the user is new 
 * and wishes to create a new account, sign in if the user is already existing but wishes to check the details of the messages or the exit option. We are scanning 
 * the choice of the user in the variable 'choice' and applying the switch operation to perform respective operations of 
 * sign in, sign up or exit.
 *
 *
 */
public class MessagingSystem {

    /**Main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * name, password and userName variables of type string to scan the name of the user, password which must start
         * with a letter and a username which is system generated and is always starting with a digit.
         */
        
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
                       /**
                        * calling function signUp of the class SignUpSignIn to assign userName to the user which is generated by the program
                        * 
                        */
                       userName = ss.signUp(name, password);
                       System.out.println("Your user name is:" + userName + "\n");
                       break;
                       
                case 2:System.out.println("Enter User Name");
                       name = s.next();
                       System.out.println("Enter Password");
                       password = s.next();
                        /**
                        * if the user is already existing then for checking the availability of that user in the arraylist we are making use of 
                        * validationForLogin variable whose value is obtained by calling the method signIn of the class SignUpSignIn using the object 'ss'.
                        * If the variable evaluates to be false then the user does not exist in the list otherwise a menu is displayed for providing the options for 
                        * for reading or writing messages respectively.
                        */
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
