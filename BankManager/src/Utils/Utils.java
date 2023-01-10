package Utils;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import main.Customer;

public class Utils {

    public static void showAcc(ArrayList<Customer> customerList, int index) {
        System.out.println("\nName: " + customerList.get(index).getName());
        System.out.println("Surname: " + customerList.get(index).getSurname());
        System.out.println("Username: " + customerList.get(index).getAcc().getUsername());
        System.out.print("Account ID: ");
        System.out.println(customerList.get(index).getAcc().getId());
        System.out.println("Balance: " + customerList.get(index).getAcc().getBalance() + '$');
    }

    public static void showPersonalInfo(ArrayList<Customer> customerList, int index) {
        System.out.println("\nName: " + customerList.get(index).getName());
        System.out.println("Surname: " + customerList.get(index).getSurname());
        System.out.println("Age: " + customerList.get(index).getAge());
    }

    public static void login(ArrayList<Customer> customerList) {
        String tempUsername;
        String tempPassword;

        if (customerList.isEmpty()) {
            return;
        }

        System.out.print("Username: ");
        tempUsername = UserInput.getString();

        System.out.print("Password: ");
        tempPassword = UserInput.getString();

        for (int i = 0; i < customerList.size(); i++) {
            while (tempUsername.compareTo(customerList.get(i).getAcc().getUsername()) < 0 || tempPassword.compareTo(customerList.get(i).getAcc().getPassword()) < 0) {
                System.out.println("\nUsername or password are incorrect. Please try again\n");

                System.out.print("Username: ");
                tempUsername = UserInput.getString();

                System.out.print("Password: ");
                tempPassword = UserInput.getString();
            }
            showAcc(customerList, i);
        }
    }

    public static void logout(Customer c) {

    }

    public static void openAcc(ArrayList<Customer> customerList, int index) {
        if (customerList.get(index).getName() == null) {
            System.out.print("\nName: ");
            customerList.get(index).setName(UserInput.getString());

            System.out.print("Surname: ");
            customerList.get(index).setSurname(UserInput.getString());

            System.out.print("Age: ");
            customerList.get(index).setAge(UserInput.getInteger());

            System.out.print("Username: ");
            customerList.get(index).getAcc().setUsername(UserInput.getString());

            System.out.print("Password: ");
            customerList.get(index).getAcc().setPassword(UserInput.getString());
            while (Pattern.matches("[0-9]+", customerList.get(index).getAcc().getPassword())) {
                System.out.println("\nYour password must contain at least 1 character");
                System.out.print("Password: ");
                customerList.get(index).getAcc().setPassword(UserInput.getString());
            }

            generateID(customerList, index, 16);
        }
//        if (customerList.get(index).getAge() < 18) {
//            System.out.println("Sorry but you must be at least 18 years old to become one of our customers\nand be able to open a bank account.");
//        }
    }

    public static int menu() {
        int input;

        System.out.println("1. New customer? Become one of us!     2. I'm already a customer     3. Exit");
        System.out.print("-> ");
        input = UserInput.getInteger();
        while (input != 1 && input != 2 && input != 3) {
            System.out.println("\nInvalid input");
            System.out.print("-> ");
            input = UserInput.getInteger();
        }

        return input;
    }

    public static void main(ArrayList<Customer> customerList) throws InterruptedException {
        System.out.println("********************Banking System Application********************" + "\n");

        int input = menu();

        switch (input) {
            case 1 -> {
                customerList.add(new Customer());

                for (int i = 0; i < customerList.size(); i++) {
                    if (customerList.get(i).getName() == null) {
                        openAcc(customerList, i);
                    }
                }
            }
            case 2 -> {
                login(customerList);
            }
            case 3 -> {
                return;
            }
            default -> {
            }
        }

        System.out.println("\n1. Login     2. Logout");
        System.out.print("-> ");
        input = UserInput.getInteger();
        while (input != 1 && input != 2) {
            System.out.println("Invalid input");
            System.out.print("-> ");
            input = UserInput.getInteger();
        }

        switch (input) {
            case 1:
                login(customerList);
                break;
            case 2:
                System.out.println("\nLogging out...\n");
                TimeUnit.SECONDS.sleep(2);
                
                input = menu();

                switch (input) {
                    case 1 -> {
                        customerList.add(new Customer());

                        for (int i = 0; i < customerList.size(); i++) {
                            if (customerList.get(i).getName() == null) {
                                openAcc(customerList, i);
                            }
                        }
                    }
                    case 2 -> {
                        login(customerList);
                    }
                    case 3 -> {
                        return;
                    }
                    default -> {
                    }
                }
                break;
            case 3:
            default:
                break;
        }
    }

    public static void generateID(ArrayList<Customer> customerList, int index, int length) {
        String LETTERS = "GR";
        String numbers = "0123456789";
        String combinedChars = LETTERS + numbers;
        Random rand = new Random();
        char[] ID = new char[length];

        ID[0] = LETTERS.charAt(0);
        ID[1] = LETTERS.charAt(1);

        for (int i = 2; i < length; i++) {
            ID[i] = combinedChars.charAt(rand.nextInt(combinedChars.length()));
        }
        customerList.get(index).getAcc().setId(ID);
    }
}
