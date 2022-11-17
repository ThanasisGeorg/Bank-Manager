
package main;

import Utils.UserInput;

public class Customer {
    private String name;
    private String surname;
    private int age;
    private Account acc = new Account();

    public Customer() {}

    public Customer(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }
    
    public void openAccount(){
        System.out.print("Enter username: ");
        acc.setUsername(UserInput.getString());
        System.out.print("Enter password: ");
        acc.setPassword(UserInput.getString());
        System.out.println("\n");
    }
    
    public void showAccount(){
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Username: " + acc.getUsername());
        System.out.println("Account ID: " + acc.getId());
        System.out.println("Balance: " + acc.getBalance() + '$');  
    }
    
    public void login(){
        String input;
        System.out.print("Username: ");
        input = UserInput.getString();
        while(input.compareTo(acc.getUsername())!=0){
            System.out.print("Username: ");
            input = UserInput.getString();
        }
        
        input = null;
        System.out.println("Password: ");
        input = UserInput.getString();
        while(input.compareTo(acc.getPassword())!=0){
            System.out.print("Password: ");
            input = UserInput.getString();
        }
    }
    
    public void signin(){
        System.out.print("Name: ");
        name = UserInput.getString();
        System.out.print("Surname: ");
        surname = UserInput.getString();
        System.out.print("Username: ");
        acc.setUsername(UserInput.getString());
        System.out.print("Password: ");
        acc.setPassword(UserInput.getString());
    }
    
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", surname=" + surname + ", age=" + age + '}';
    }
}
