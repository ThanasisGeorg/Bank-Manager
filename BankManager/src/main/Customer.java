package main;

import Utils.UserInput;

public class Customer {

    private String name;
    private String surname;
    private int age;
    private Account acc = new Account();
    private String[] info;

    public Customer() {
    }

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

    public String[] getInfo() {
                
        info[0] = name;
        info[1] = surname;
        info[2] = getAcc().getUsername();
        info[3] = getAcc().getPassword();
        info[4] = getAcc().getId().toString();               
                
        return info;
    }
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", surname=" + surname + ", age=" + age + '}';
    }
}
