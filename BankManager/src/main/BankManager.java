
package main;

import Utils.UserInput;

public class BankManager {

    public static void main(String[] args) {
        System.out.println("**********Banking System Application**********" + "\n");
        System.out.println("1. Login  " + "2. Sign in" + "\n");
        int input;
        do{
            System.out.print("--> ");
            input = UserInput.getInteger();
        }
        while(input!=1 && input!=2);
        
        if(input==1){
            
        }
        else if(input==2){
            
        }
    }
    
}
