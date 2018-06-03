package messagingsystem;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Shifa
 */
public class SignUpSignIn {
    
    static ArrayList<Account> users = new ArrayList();
    private static long count=0;
    Scanner s=new Scanner(System.in);
    Operations op = new Operations();
    
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
    
    boolean signIn(String userName,String password)
    {
        int flag=0,accountIndex=0,choice=0;
        
        for(int i=0; i<count; i++){   
            if(users.get(i).userName.compareTo(userName)==0 && users.get(i).password.compareTo(password)==0){                
                flag=1;
                accountIndex=i;
                break;
            }
        }    
        if(flag==1){                                                      //Valid account
            System.out.println("Welcome\t" + users.get(accountIndex).name);
            op.displayMenu(users, accountIndex);
            return true;
        }
        else
            return false;
        
    }
    
}
