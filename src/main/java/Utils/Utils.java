package Utils;

import Database.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;
import main.Customer;
import kdesp73.databridge.connections.DatabaseConnection;
import java.sql.SQLException;
import Commands.*;

/**
 *
 * @author thana
 */
public class Utils {
    public static void openAcc(ArrayList<Customer> customerList, int index) throws SQLException {
        String input;
        boolean flag;

        System.out.print("\nName: ");
        input = UserInput.getString();
        while(input.isEmpty() || input.isBlank()){
            System.out.print("Invalid name\n\nName: ");
            input = UserInput.getString();
        }
        customerList.get(index).setName(input);

        System.out.print("Surname: ");
        input = UserInput.getString();
        while(input.isEmpty() || input.isBlank()){
            System.out.print("Invalid surname\n\nSurname: ");
            input = UserInput.getString();
        }
        customerList.get(index).setSurname(input);

        System.out.print("Age: ");
        input = UserInput.getString();
        if(input.length() == 1){
            System.out.println("\n[WARNING]\nYou must be at least 18 years old\nto open a bank account.");
            return;
        }
        customerList.get(index).setAge(input);
        
        System.out.print("Username: ");
        input = UserInput.getString();
        do{
            flag = false;
            if(input.isEmpty() || input.isBlank()){
                flag = true;
                System.out.print("Invalid username\n\nUsername: ");
                input = UserInput.getString();
                continue;
            }

            for (int i = 0; i < index; i++) {
                if (customerList.get(i).getAcc().getUsername().matches(input)) {
                    flag = true;
                    System.out.println("\nThis username has already been taken\n");
                    System.out.print("Username: ");
                    input = UserInput.getString();
                    break;
                }
            }

            if(flag == false){
                customerList.get(index).getAcc().setUsername(input);
                break;
            }
            
        } while(flag);

        System.out.print("Password: ");
        input = UserInput.getString();
        while(Pattern.matches("[0-9]+", input)){
            System.out.println("\nYour password must contain at least 1 character");
            System.out.print("Password: ");
            input = UserInput.getString();
        }

        do{
            flag = false;
            if(input.isEmpty() || input.isBlank()){
                flag = true;
                System.out.print("Invalid password\n\nPassword: ");
                input = UserInput.getString();
                continue;
            }

            for(int i = 0; i < index; i++){
                if(customerList.get(i).getAcc().getPassword().matches(input)){
                    flag = true;
                    System.out.println("\nThis password already exist\n");
                    System.out.print("Passsword: ");
                    input = UserInput.getString();
                    break;
                }
            }

            if(flag == false){
                customerList.get(index).getAcc().setPassword(input);
                break;
            }
        } while(flag);

        generateID(customerList, index);

        DBMethods.insertCustomer(customerList, index);
        DBMethods.insertCustomerAcc(customerList, index);
    }

    public static int login(ArrayList<Customer> customerList) {
        String tempUsername;
        String tempPassword;
        boolean flag = true;
        int j = 0;

        if(customerList.isEmpty()){
            System.out.println("Empty account list");
            return -1;
        }

        System.out.print("\nUsername: ");
        tempUsername = UserInput.getString();

        System.out.print("Password: ");
        tempPassword = UserInput.getString();

        while(flag){
            for(int i = 0; i < customerList.size(); i++){
                if(!tempUsername.matches(customerList.get(i).getAcc().getUsername())
                   || !tempPassword.matches(customerList.get(i).getAcc().getPassword())){
                    continue;
                }

                showAcc(customerList, i);
                j = i;
                flag = false;
                break;
            }

            if(flag == true){
                System.out.println("\nUsername or password are incorrect. Please try again\n");
                System.out.print("Username: ");
                tempUsername = UserInput.getString();

                System.out.print("Password: ");
                tempPassword = UserInput.getString();
            }
        }
        return j;
    }

    public static void generateID(ArrayList<Customer> customerList, int index) {
        String LETTERS = "GR";
        String numbers = "0123456789";
        Random rand = new Random();
        String ID = LETTERS;

        for(int i = 0; i < 16; i++){
            ID = ID + numbers.charAt(rand.nextInt(numbers.length()));
        }

        customerList.get(index).getAcc().setId(ID);
    }

    public static void deposit(ArrayList<Customer> customerList, int j) throws SQLException {
        int amount;

        System.out.println("\nEnter the amount of money you want to deposit: ");
        System.out.print("> ");
        amount = UserInput.getInteger();
        while(amount < 0 || amount > 1000){
            if(amount < 0){
                System.out.println("Invalid input");
                System.out.print("\n> ");
                amount = UserInput.getInteger();
            } else{
                System.out.println("You cannot deposit above 1000$");
                System.out.print("\n> ");
                amount = UserInput.getInteger();
            }
        }

        customerList.get(j).getAcc().setBalance(customerList.get(j).getAcc().getBalance() + amount);

        DBMethods.updateCustomerAcc(customerList, j);
    }

    public static void showAcc(ArrayList<Customer> customerList, int index) {
        System.out.println("\nName: " + customerList.get(index).getName());
        System.out.println("Surname: " + customerList.get(index).getSurname());
        System.out.println("Username: " + customerList.get(index).getAcc().getUsername());
        System.out.print("Account ID: ");
        System.out.println(customerList.get(index).getAcc().getId());
        System.out.print("Account Balance : ");
        System.out.println(customerList.get(index).getAcc().getBalance() + "$");   
    }

    public static String[] getInfo(ArrayList<Customer> customerList, int index) {
        String[] info = new String[4];

        info[0] = customerList.get(index).getAcc().getId();
        info[1] = customerList.get(index).getName();
        info[2] = customerList.get(index).getSurname();
        info[3] = customerList.get(index).getAge();

        return info;
    }

    public static String[] getAccInfo(ArrayList<Customer> customerList, int index) {
        String[] info = new String[4];

        info[0] = customerList.get(index).getAcc().getId();
        info[1] = customerList.get(index).getAcc().getUsername();
        info[2] = customerList.get(index).getAcc().getPassword();
        info[3] = customerList.get(index).getAcc().getBalance() + "";

        return info;
    }

    public static void deleteAcc(ArrayList<Customer> customerList, int j) throws SQLException, InterruptedException {
        char input;

        System.out.println("\nAre you sure you want to delete this account (y/n)?");
        System.out.print("> ");
        input = UserInput.getChar();
        while (input != 'y' && input != 'n') {
            System.out.println("\nInvalid input");
            System.out.print("> ");
            input = UserInput.getChar();
        }

        if(input == 'y'){
            DBMethods.deleteAccount(customerList, j);
            DBMethods.deleteCustomer(customerList, j);
            customerList.remove(j);
            System.out.println("\nDeleting account...");
            TimeUnit.SECONDS.sleep(1);
        } else System.out.println("\nAbort");
    }

    public static void load(ArrayList<Customer> customerList) throws SQLException {
        customerList.clear();

        ArrayList<String[]> accInfoList = DBMethods.getCustomerAcc();
        ArrayList<String[]> infoList = DBMethods.getCustomer();

        for(int i = 0; i < infoList.size(); i++){
            Customer c = new Customer();

            String[] accInfo = accInfoList.get(i);
            c.getAcc().addAccInfo(accInfo);
            
            String[] info = infoList.get(i);

            String[] temp = new String[DBMethods.getCustomersFields().length];
            System.arraycopy(info, 0, temp, 0, temp.length);

            c.addInfo(temp);
            customerList.add(c);
        }
    }

    public static void loginPrompt(ArrayList<Customer> customerList, int index) throws SQLException, InterruptedException {
        String[] availableCommands = {"dep", "info", "del", "logout", "help"};
        StringBuilder sb = new StringBuilder();
        String input;

        load(customerList);

        sb.append("\n" + customerList.get(index).getAcc().getUsername() + ":~$ ");
        System.out.print(sb.toString());
        input = UserInput.getString();
        while(!CMDUtils.checkInput(availableCommands, input)){
            sb.delete(0, sb.capacity());
            sb.append("Invalid input. Type 'help' for the command list" + "\n\n" + customerList.get(index).getAcc().getUsername() + ":~$ ");
            System.out.print(sb.toString());
            sb.delete(0, sb.capacity());
            input = UserInput.getString();
        }

        while(!input.equals("logout")){
            switch(input){
                case "dep" : {
                    deposit(customerList, index);
                    break;
                }

                case "info" : {
                    showAcc(customerList, index);
                    break;
                }

                case "del" : {
                    deleteAcc(customerList, index);
                    return;
                }

                case "help" : {
                    CMDUtils.printCommands(availableCommands);
                    break;
                }

                default : {}
            }

            sb.delete(0, sb.capacity());
            sb.append("\n" + customerList.get(index).getAcc().getUsername() + ":~$ ");
            System.out.print(sb.toString());
            input = UserInput.getString();
            while(!CMDUtils.checkInput(availableCommands, input)){
                sb.delete(0, sb.capacity());
                sb.append("Invalid input. Type 'help' for the command list" + "\n\n" + customerList.get(index).getAcc().getUsername() + ":~$ ");
                System.out.print(sb.toString());
                sb.delete(0, sb.capacity());
                input = UserInput.getString();
            }
        }
        
        sb.delete(0, sb.capacity());
        sb.append("\nLogging out...\n");
        System.out.print(sb.toString());
        TimeUnit.SECONDS.sleep(1);
        return;
    }

    public static void prompt(ArrayList<Customer> customerList) throws SQLException, InterruptedException {
        String[] availableCommands = {"opac", "login", "exit", "help"};
        StringBuilder sb = new StringBuilder();
        String input;

        load(customerList);
        
        sb.append(":-$ ");
        System.out.print(sb.toString());
        input = UserInput.getString();
        while(!CMDUtils.checkInput(availableCommands, input)){
            sb.delete(0, sb.capacity());
            sb.append("Invalid input. Type 'help' for the command list" + "\n\n:-$ "); 
            System.out.print(sb.toString());
            sb.delete(0, sb.capacity());
            input = UserInput.getString();
        }
        
        while(!input.equals("exit")){
            switch(input){
                case "opac" : {
                    customerList.add(new Customer());
                    openAcc(customerList, customerList.size() - 1);
                    if(customerList.isEmpty()) break;
                    if(customerList.get(customerList.size() - 1).getAge() == null){
                        customerList.remove(customerList.size() - 1);
                        break;
                    }
                    break;
                }
    
                case "login" : {
                    int j = login(customerList);
                    if(j < 0) break;
                    loginPrompt(customerList, j);
                    break;
                }

                case "help" : {
                    CMDUtils.printCommands(availableCommands);
                    break;
                }
    
                default : {}
            }

            sb.delete(0, sb.capacity());
            sb.append("\n:-$ ");
            System.out.print(sb.toString());
            input = UserInput.getString();
            while(!CMDUtils.checkInput(availableCommands, input)){
                sb.delete(0, sb.capacity());
                sb.append("Invalid input. Type 'help' for the command list" + "\n\n:-$ ");
                System.out.print(sb.toString());
                sb.delete(0, sb.capacity());
                input = UserInput.getString();
            }
        }

        sb.delete(0, sb.capacity());
        sb.append("\n...\n");
        System.out.print(sb.toString());
        TimeUnit.SECONDS.sleep(1);
        return;
    }
}
