
package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
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
    
    public static void showAcc(Customer c){
        System.out.println("Name: " + c.getName());
        System.out.println("Surname: " + c.getSurname());
        System.out.println("Username: " + c.getAcc().getUsername());
        System.out.print("Account ID: ");
        System.out.println(c.getAcc().getId());
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
    
    public static void logout(Customer c){
        
    }
    
    public static void openAcc(Customer c){
        System.out.print("Name: ");
        c.setName(UserInput.getString());
        System.out.print("Surname: ");
        c.setSurname(UserInput.getString());
        System.out.print("Username: ");
        c.getAcc().setUsername(UserInput.getString());
        System.out.print("Password: ");
        c.getAcc().setPassword(UserInput.getString());
        generateID(c, 16);
    }
    
    public static void services(Customer c){
        System.out.println("**********Banking System Application**********" + "\n");
        System.out.println("1. Login     2. Create new account     3. Exit");
        int input;
        System.out.print("-> ");
        input = UserInput.getInteger();
        while(input!=1 && input!=2 && input!=3){
            System.out.println("Invalid input");
            System.out.print("-> ");
            input = UserInput.getInteger();
        }
        
        if(input==1){
            login(c);
            showAcc(c);
        }
        else if(input==2){
            System.out.println("\n");
            openAcc(c);
            System.out.println("\n");
            login(c);
            showAcc(c);
        }
        else if(input==3){
            return;
        }
    }
    
    public static void generateID(Customer c, int length){
        String LETTERS = "GR";
        String numbers = "0123456789";
        String combinedChars = LETTERS + numbers;
        Random rand = new Random();
        char[] ID = new char[length];
        
        ID[0] = LETTERS.charAt(0);
        ID[1] = LETTERS.charAt(1);
        
        for(int i = 2; i< length ; i++) {
         ID[i] = combinedChars.charAt(rand.nextInt(combinedChars.length()));
        }
        c.getAcc().setId(ID);        
    }
}
