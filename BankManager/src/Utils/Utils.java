
package Utils;

import java.util.ArrayList;
import java.util.Collections;
import main.Account;
import main.Customer;

public class Utils {
    /*public static void openAccount(Customer c){
        System.out.print("Enter username: ");
        //acc.setUsername(UserInput.getString());
        System.out.print("Enter password: ");
        //acc.setPassword(UserInput.getString());
        System.out.println("\n");
    }*/
    
    public static void showAccount(Customer c){
        System.out.println("Name: " + c.getName());
        System.out.println("Surname: " + c.getSurname());
        System.out.println("Username: " + c.getAcc().getUsername());
        System.out.println("Account ID: " + c.getAcc().getId());
        System.out.println("Balance: " + c.getAcc().getBalance() + '$');  
    }
    
    public static void login(Customer c){
        String input;
        System.out.print("Username: ");
        input = UserInput.getString();
        while(input.compareTo(c.getAcc().getUsername())!=0){
            System.out.print("Username: ");
            input = UserInput.getString();
        }
        
        input = null;
        System.out.print("Password: ");
        input = UserInput.getString();
        while(input.compareTo(c.getAcc().getPassword())!=0){
            System.out.print("Password: ");
            input = UserInput.getString();
        }
    }
    
    public static void signin(Customer c){
        System.out.print("Name: ");
        c.setName(UserInput.getString());
        System.out.print("Surname: ");
        c.setSurname(UserInput.getString());
        System.out.print("Username: ");
        c.getAcc().setUsername(UserInput.getString());
        System.out.print("Password: ");
        c.getAcc().setPassword(UserInput.getString());
    }
    
    public static void services(Customer c){
        System.out.println("**********Banking System Application**********" + "\n");
        System.out.println("1. Login  2. Sign in");
        int input;
        do{
            System.out.print("-> ");
            input = UserInput.getInteger();
        }
        while(input!=1 && input!=2);
        
        if(input==1){
            login(c);
            showAccount(c);
        }
        else if(input==2){
            signin(c);
            System.out.println("\n");
            login(c);
            showAccount(c);
        }
    }
}
