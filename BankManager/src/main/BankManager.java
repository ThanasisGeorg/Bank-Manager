
package main;

import Utils.UserInput;

public class BankManager {

    public static void main(String[] args) {
        Customer c1 = new Customer();
        System.out.println("""
                           **********Banking System Application**********
                           """);
        System.out.println("""
                           1. Login  2. Sign in
                           """);
        int input;
        do{
            System.out.print("--> ");
            input = UserInput.getInteger();
        }
        while(input!=1 && input!=2);
        
        if(input==1){
            c1.login();
            c1.showAccount();
        }
        else if(input==2){
            c1.signin();
        }
    }
    
}
