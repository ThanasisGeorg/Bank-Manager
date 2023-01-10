
package main;

public class Account {
    private String username;
    private String password;
    private char[] id;
    private double balance = 0.0;

    public Account() {}
    
    public Account(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public char[] getId() {
        return id;
    }

    public void setId(char[] id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", id=" + id + ", balance=" + balance + '}';
    }
}
